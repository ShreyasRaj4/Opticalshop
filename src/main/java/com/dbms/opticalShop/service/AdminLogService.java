package com.dbms.opticalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.AdminLog;
import com.dbms.opticalShop.repository.AdminLogRepository;

@Service
public class AdminLogService {
	
	@Autowired
	AdminLogRepository adminLogRepository;
	
	public void addLog(AdminLog adminLog) {
		adminLogRepository.save(adminLog);
	}

	public List<AdminLog> getAllAdminLogs() {
		return adminLogRepository.findAll();
	}
}
