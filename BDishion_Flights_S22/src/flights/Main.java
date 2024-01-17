package flights;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;

/**
 * 
 * @author Brendan Dishion
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList flightlist = loadFlights("flights.txt");
		flightPrint(flightlist);

	}


	public static void flightPrint(ArrayList<Flight> flights) {

		printf("%-15s %-7s %-7s %-4s\n", "AIRLINE", "FROM", "TO", "PRICE");
		printf("%-15s %-7s %-7s %-4s\n", "-------", "----", "--", "-----");

		for (Flight aryL : flights) {
			printf("%-16s %-6s %-7s %-4s\n", aryL.getAirline(), aryL.getFrom(), aryL.getTo(), aryL.getPrice());

		}
	}


	public static ArrayList<Flight> loadFlights(String filename) throws IOException {

		ArrayList<Flight> flights = new ArrayList<Flight>();
		String fileName = readLine();
		List<String> listFlights = readFileAsLines(fileName);

		for (String lf : listFlights) {
			Flight flight = new Flight(lf, lf, lf, lf);
			flight.setFrom(substringBefore(lf, "=>"));
			flight.setTo(substringBetween(lf, "=>", ","));
			flight.setAirline(substringBetween(lf, ",", ","));
			flight.setPrice(substringAfterLast(lf, ","));

			flights.add(flight);

		}
		return (flights);

	}

}
