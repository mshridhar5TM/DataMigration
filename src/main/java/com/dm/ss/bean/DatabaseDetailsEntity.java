/*
 * Created on 26 Dec 2017 ( Time 13:25:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dm.ss.bean;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="database_details", schema="public" )
@NamedQueries ( {
  @NamedQuery ( name="DatabaseDetailsEntity.countAll", query="SELECT COUNT(x) FROM DatabaseDetailsEntity x" )
} )
public class DatabaseDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sl_no", nullable=false)
    private BigDecimal slNo         ;


    @Column(name="database_name", length=2147483647)
    private String     databaseName ;

    @Column(name="driver_name", length=2147483647)
    private String     driverName   ;

    @Column(name="database_url", length=2147483647)
    private String     databaseUrl  ;



    public DatabaseDetailsEntity() {
		super();
    }
    public void setSlNo( BigDecimal slNo ) {
        this.slNo = slNo ;
    }
    public BigDecimal getSlNo() {
        return this.slNo;
    }

    public void setDatabaseName( String databaseName ) {
        this.databaseName = databaseName;
    }
    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDriverName( String driverName ) {
        this.driverName = driverName;
    }
    public String getDriverName() {
        return this.driverName;
    }

    public void setDatabaseUrl( String databaseUrl ) {
        this.databaseUrl = databaseUrl;
    }
    public String getDatabaseUrl() {
        return this.databaseUrl;
    }


    @Override
	public String toString() {
		return "DatabaseDetailsEntity [slNo=" + slNo + ", databaseName=" + databaseName + ", driverName=" + driverName
				+ ", databaseUrl=" + databaseUrl + "]";
	} 

}
