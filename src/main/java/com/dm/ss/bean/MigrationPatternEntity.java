
package com.dm.ss.bean;

import java.io.Serializable;
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
@Table(name = "migration_pattern", schema = "public")
@NamedQueries({
		@NamedQuery(name = "MigrationPatternEntity.countAll", query = "SELECT COUNT(x) FROM MigrationPatternEntity x") })
public class MigrationPatternEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sl_no", nullable = false)
	private BigDecimal slNo;
	
	@Column(name = "source_table", length = 2147483647)
	private String sourceTable;

	@Column(name = "target_table", length = 2147483647)
	private String targetTable;

	public BigDecimal getSlNo() {
		return slNo;
	}

	public void setSlNo(BigDecimal slNo) {
		this.slNo = slNo;
	}

	public String getSourceTable() {
		return sourceTable;
	}

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	public String getTargetTable() {
		return targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MigrationPatternEntity [slNo=" + slNo + ", sourceTable=" + sourceTable + ", targetTable=" + targetTable
				+ "]";
	}

}
