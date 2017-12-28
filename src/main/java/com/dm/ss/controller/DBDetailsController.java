package com.dm.ss.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.ss.bean.DbConnectionDetailsEntity;
import com.dm.ss.service.DBDetailsService;

@RestController
public class DBDetailsController {
	@Autowired
	private DBDetailsService detailsService;
	
	final static Logger logger = Logger.getLogger(DBDetailsController.class);
	
	@RequestMapping("/getTables")
	public ResponseEntity<?> getTables(
			@RequestBody DbConnectionDetailsEntity databaseDetails) {
		logger.info(databaseDetails.toString());
		databaseDetails=detailsService.getDetails(databaseDetails);
		List<String> tables = null;
		try {
			tables = detailsService.getTableList(databaseDetails);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return ResponseEntity.ok(tables);
	}
	@PostMapping("/retrieveData")
	public ResponseEntity<?> retrieveData(@RequestBody List<String> tables){
		try {
			detailsService.retrieveData(tables);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(null);
	}
}