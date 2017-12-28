package com.dm.ss.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.ss.bean.DatabaseDetailsEntity;
import com.dm.ss.bean.DbConnectionDetailsEntity;
import com.dm.ss.repository.DatabaseDetailsJpaRepository;
import com.dm.ss.repository.DbConnectionDetailsJpaRepository;

@Service
public class DBDetailsService {
	@Autowired
	private DatabaseDetailsJpaRepository databaseDetailsRepository;

	@Autowired
	private DbConnectionDetailsJpaRepository dbConnectionRepository;

	final static Logger logger = Logger.getLogger(DBDetailsService.class);

	public DbConnectionDetailsEntity getDetails(DbConnectionDetailsEntity databaseDetails) {
		logger.info("Building Database details");
		DatabaseDetailsEntity detailsEntity = null;

		detailsEntity = databaseDetailsRepository.findByDatabaseName(databaseDetails.getDatabase());

		String url = detailsEntity.getDatabaseUrl().replace("host", databaseDetails.getHost());
		if (url.contains("sid"))
			url = url.replace("sid", databaseDetails.getSid());
		url = url.replace("databaseName", databaseDetails.getDatabaseName());
		url = url.replace("[", "");
		url = url.replace("]", "");
		if (databaseDetails.getPort() != null) {
			url = url.replace("port", databaseDetails.getPort());
		} else {
			url = url.replace(":port", "");
		}
		databaseDetails.setUrl(url);
		databaseDetails.setDriver(detailsEntity.getDriverName());
		logger.info("Saving connection details to repository....");
		dbConnectionRepository.save(databaseDetails);
		return databaseDetails;
	}

	public Connection getConnection(DbConnectionDetailsEntity databaseDetails)
			throws ClassNotFoundException, SQLException {
		logger.info(databaseDetails);
		Class.forName(databaseDetails.getDriver());
		Connection connection = DriverManager.getConnection(databaseDetails.getUrl(), databaseDetails.getUsername(),
				databaseDetails.getPassword());
		return connection;
	}

	public List<String> getTableList(DbConnectionDetailsEntity databaseDetails)
			throws SQLException, ClassNotFoundException {
		Connection connection = getConnection(databaseDetails);
		String[] tableTypes = { "TABLE", "ALIAS", "SYNONYM", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "SYSTEM TABLE" };
		ResultSet resultSet = connection.getMetaData().getTables(connection.getCatalog(), databaseDetails.getSchema(),
				"%", tableTypes);
		List<String> tableList = new ArrayList<>();
		while (resultSet.next()) {
			tableList.add(resultSet.getString("TABLE_NAME"));
		}
		connection.close();
		return tableList;

	}

	public void retrieveData(List<String> tables) throws ClassNotFoundException, SQLException, IOException {
		logger.info("Data retrieval has started...");
		List<DbConnectionDetailsEntity> databaseDetails = dbConnectionRepository.findAll();
		Connection sourceDb = getConnection(databaseDetails.get(0));
		sourceDb.setSchema(databaseDetails.get(0).getSchema());
		File file = null;
		Long start = System.currentTimeMillis();
		switch (databaseDetails.get(0).getDatabase()) {
		case "PostgreSQL":
			logger.info("PostgreSQL Data Retrieval...");
			CopyManager copyManager = new CopyManager((BaseConnection) sourceDb);
			for (String t : tables) {
				logger.info(
						"File " + "D:/GEGDC/SS460711/ServiceWS/DatabaseMigration/DataDump/" + t + ".txt" + "  Created");
				file = new File("D:/GEGDC/SS460711/ServiceWS/DatabaseMigration/DataDump/" + t + ".txt");
				FileOutputStream outputStream = new FileOutputStream(file);
				String statement = "COPY " + t + " to STDOUT";
				copyManager.copyOut(statement, outputStream);
			}

			break;
		default:
			break;
		}
		Long end = System.currentTimeMillis();
		logger.info("Data retrieval is done with time" + (start - end) + "...Closing connection");

		sourceDb.close();
	}

}