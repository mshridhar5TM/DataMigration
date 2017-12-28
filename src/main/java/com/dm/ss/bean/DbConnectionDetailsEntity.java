
package com.dm.ss.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "db_connection_details", schema = "public")
@NamedQueries({
		@NamedQuery(name = "DbConnectionDetailsEntity.countAll", query = "SELECT COUNT(x) FROM DbConnectionDetailsEntity x") })
public class DbConnectionDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "url", length = 2147483647)
	private String url;

	@Column(name = "username", length = 2147483647)
	private String username;

	@Column(name = "password", length = 2147483647)
	private String password;

	@Column(name = "database_name", length = 2147483647)
	private String databaseName;

	@Column(name = "host", length = 2147483647)
	private String host;

	@Column(name = "port", length = 2147483647)
	private String port;

	@Column(name = "schema", length = 2147483647)
	private String schema;
	@Id
	@Column(name = "database", length = 2147483647)
	private String database;

	@Column(name = "driver", length = 2147483647)
	private String driver;

	@Column(name = "sid", length = 2147483647)
	private String sid;

	public DbConnectionDetailsEntity() {
		super();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPort() {
		return this.port;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getSchema() {
		return this.schema;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getDatabase() {
		return this.database;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSid() {
		return this.sid;
	}

	@Override
	public String toString() {
		return "DbConnectionDetailsEntity [url=" + url + ", username=" + username + ", password=" + password
				+ ", databaseName=" + databaseName + ", host=" + host + ", port=" + port + ", schema=" + schema
				+ ", database=" + database + ", driver=" + driver + ", sid=" + sid + "]";
	}

}
