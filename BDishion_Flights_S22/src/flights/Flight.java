package flights;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;

public class Flight {
	private String from;
	private String to;
	private String airline;
	private String price;

	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Flight(String from, String to, String airline, String price) {
		this.from = from;
		this.to = to;
		this.airline = airline;
		this.price = price;
	}

}
