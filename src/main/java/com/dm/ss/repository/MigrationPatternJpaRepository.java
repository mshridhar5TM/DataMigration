package com.dm.ss.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.ss.bean.MigrationPatternEntity;

/**
 * Repository : MigrationPattern.
 */
public interface MigrationPatternJpaRepository extends PagingAndSortingRepository<MigrationPatternEntity, BigDecimal> {

}
