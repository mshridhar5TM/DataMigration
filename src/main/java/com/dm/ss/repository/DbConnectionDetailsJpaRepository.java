package com.dm.ss.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.ss.bean.DbConnectionDetailsEntity;

public interface DbConnectionDetailsJpaRepository
		extends PagingAndSortingRepository<DbConnectionDetailsEntity, BigDecimal> {
	List<DbConnectionDetailsEntity> findAll();
}
