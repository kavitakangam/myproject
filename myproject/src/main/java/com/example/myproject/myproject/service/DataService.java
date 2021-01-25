package com.example.myproject.myproject.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.myproject.domain.Data;
import com.example.myproject.myproject.repository.DataRepository;
import com.example.myproject.myproject.utils.CsvUtils;

@Service
public class DataService {
	@Autowired
	DataRepository dataRepository;
	
	public List<Data> store(InputStream is) {
		try {
			// Using ApacheCommons Csv Utils to parse CSV file
			List<Data> lstData = CsvUtils.parseCsvFile(is);
			
			// Using OpenCSV Utils to parse CSV file
			// List<Customer> lstCustomers = OpenCsvUtil.parseCsvFile(file);
			
			// Save customers to database
			dataRepository.saveAll(lstData);
			return lstData;
		} catch(Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}
}
