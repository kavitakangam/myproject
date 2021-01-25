package com.example.myproject.myproject.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Data {
	@Id
    private String id;
    private int quarter;
    private String stock;
    private Date date;
    private String open;
    private String high;
    private String low;
    private String close;
    private double volume;
    private double percent_change_price;
    private double percent_change_volume_over_last_wk;
    private double previous_weeks_volume;
    private String next_weeks_open;
    private String next_weeks_close;
    private double percent_change_next_weeks_price;
    private int days_to_next_dividend;
    private double percent_return_next_dividend;
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getPercent_change_price() {
		return percent_change_price;
	}
	public void setPercent_change_price(double percent_change_price) {
		this.percent_change_price = percent_change_price;
	}
	public double getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}
	public void setPercent_change_volume_over_last_wk(double percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}
	public double getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}
	public void setPrevious_weeks_volume(double previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}
	public String getNext_weeks_open() {
		return next_weeks_open;
	}
	public void setNext_weeks_open(String next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}
	public String getNext_weeks_close() {
		return next_weeks_close;
	}
	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}
	public double getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}
	public void setPercent_change_next_weeks_price(double percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}
	public int getDays_to_next_dividend() {
		return days_to_next_dividend;
	}
	public void setDays_to_next_dividend(int days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}
	public double getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}
	public void setPercent_return_next_dividend(double percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
	public Data(int quarter, String stock, Date date, String open, String high, String low, String close, double volume,
			double percent_change_price, double percent_change_volume_over_last_wk, double previous_weeks_volume,
			String next_weeks_open, String next_weeks_close, double percent_change_next_weeks_price,
			int days_to_next_dividend, double percent_return_next_dividend) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
		this.previous_weeks_volume = previous_weeks_volume;
		this.next_weeks_open = next_weeks_open;
		this.next_weeks_close = next_weeks_close;
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
	
    
}
