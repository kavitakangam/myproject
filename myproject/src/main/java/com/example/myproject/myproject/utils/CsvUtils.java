package com.example.myproject.myproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.myproject.myproject.domain.Data;


public class CsvUtils {
	
	private static String csvExtension = "csv";
	
	public static List<Data> parseCsvFile(InputStream is) {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		List<Data> datas = new ArrayList<Data>();

		try {
			fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			System.out.println("Here is utils...");
			for (CSVRecord csvRecord : csvRecords) {
				String temp1 = csvRecord.get("percent_change_volume_over_last_wk");
				String temp2 = csvRecord.get("previous_weeks_volume");
				double percent_change_volume_over_last_wk = temp1.equals("") ? 0.0 : Double.parseDouble(temp1);
				double previous_weeks_volume = temp1.equals("") ? 0.0 : Double.parseDouble(temp2);
				Data customer = new Data(
						Integer.parseInt(csvRecord.get("quarter")), 
						csvRecord.get("stock"), 
						new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("date").trim()),
						csvRecord.get("open"),
						csvRecord.get("high"),
						csvRecord.get("low"),
						csvRecord.get("close"),
						Double.parseDouble(csvRecord.get("volume")),
						Double.parseDouble(csvRecord.get("percent_change_price")),
						percent_change_volume_over_last_wk,
						previous_weeks_volume,
						csvRecord.get("next_weeks_open"),
						csvRecord.get("next_weeks_close"),
						Double.parseDouble(csvRecord.get("percent_change_next_weeks_price")),
						Integer.parseInt(csvRecord.get("days_to_next_dividend")),
						Double.parseDouble(csvRecord.get("percent_return_next_dividend"))
				);
				
				datas.add(customer);
			}

		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}

		return datas;
	}	
	
	public static boolean isCSVFile(MultipartFile file) {
		String extension = file.getOriginalFilename().split("\\.")[1];
		
		if(!extension.equals(csvExtension)) {
			return false;
		}
		
		return true;
	}
}
