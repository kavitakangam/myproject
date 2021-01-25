package com.example.myproject.myproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.myproject.myproject.domain.Data;
import com.example.myproject.myproject.repository.DataRepository;
import com.example.myproject.myproject.service.DataService;
import com.example.myproject.myproject.utils.CsvUtils;
import com.example.myproject.myproject.utils.Response;

@RestController
@RequestMapping("/")
public class MainController {
	
	private final DataRepository dataRepository;
	
	@Autowired
	private DataService dataService;
	
	public MainController(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@PostMapping("/add")
	public Response test(@RequestBody Map<String, Object> obj) throws NumberFormatException, ParseException {
		Response response = new Response();
		Data data = new Data(
			Integer.parseInt(obj.get("quarter").toString()),
			obj.get("stock").toString(),
			new SimpleDateFormat("dd/MM/yyyy").parse(obj.get("date").toString()),
			obj.get("open").toString(),
			obj.get("high").toString(),
			obj.get("low").toString(),
			obj.get("close").toString(),
			Double.parseDouble(obj.get("volume").toString()),
			Double.parseDouble(obj.get("percent_change_price").toString()),
			Double.parseDouble(obj.get("percent_change_volume_over_last_wk").toString()),
			Double.parseDouble(obj.get("previous_weeks_volume").toString()),
			obj.get("next_weeks_open").toString(),
			obj.get("next_weeks_close").toString(),
			Double.parseDouble(obj.get("percent_change_next_weeks_price").toString()),
			Integer.parseInt(obj.get("days_to_next_dividend").toString()),
			Double.parseDouble(obj.get("percent_return_next_dividend").toString())
		);
		Data res = dataRepository.save(data);
		if (res != null) {
			response.setStatus(true);
			response.setMsg("Data inserted successfully");
			List<Data> responseData = new ArrayList<Data>();
			responseData.add(data);
			response.setData(responseData);
			return response;
		} else {
			response.setStatus(false);
			response.setMsg("Something went wrong while adding data");
			return response;
		}
		
	}
	
	@GetMapping("/get/{stock}")
	public Response getAll(@PathVariable("stock") String stock) {
		Response response = new Response();
		List<Data> result = this.dataRepository.findByStock(stock);
		response.setStatus(true);
		response.setMsg("Search result succssfully gotten.");
		response.setData(result);
		return response;
	}
	
	@PostMapping(value = "/upload")
	public Response saveDataFromCsvFile(@RequestParam("csvFile") MultipartFile csvfile) {
		
		Response response = new Response();
		// Checking the upload-file's name before processing
		if (csvfile.getOriginalFilename().isEmpty()) {
			response.setStatus(false);
			response.setMsg("No file selected to upload!");
			return response;
		}
		
		// checking the upload file's type is CSV or NOT
		
		if(!CsvUtils.isCSVFile(csvfile)) { 
		    response.setStatus(false);
		    response.setMsg("This file is not a csv file. Please select a csv file");
	        return response; 
		}
		
		try {
			System.out.println("Here is controller");
			// save file data to database
			List<Data> result = dataService.store(csvfile.getInputStream());
			response.setStatus(true);
			response.setMsg("Data uploaded successfully");
			response.setData(result);
			return response;
		} catch (Exception e) {
			response.setStatus(false);
		    response.setMsg("Something went wrong while uploading the data");
	        return response;
		}
	}
}
