package com.dm.ss.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.ss.bean.DatabaseDetailsEntity;

public interface DatabaseDetailsJpaRepository extends PagingAndSortingRepository<DatabaseDetailsEntity, BigDecimal> {
	DatabaseDetailsEntity findByDatabaseName(String database);
}
