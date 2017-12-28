package com.dm.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.ss.repository.DbConnectionDetailsJpaRepository;

@Service
public class TargetService {
	@Autowired
	private DbConnectionDetailsJpaRepository detailsJpaRepository;
	


}
