package rockcountdown;

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

		String filename = readLine();
		List<String> ListLines = readFileAsLines(filename);
		ArrayList<Song> List = new ArrayList();

		// looping List and creating new object, adding to Array List
		for (int i = 0; i < ListLines.size(); i++) {

			Song song = new Song(ListLines.get(i));
			List.add(song);
		}
		// creating String builder
		StringBuilder sb = new StringBuilder();

		// looping and appending
		for (int i = List.size() - 1; i >= 0; i--) {

			sb.append((List.get(i)).getRank() + "\t");
			sb.append((List.get(i)).getTitle() + "\r\n");
		}
		// converting to String and printing result
		String result = sb.toString();
		println(result);
		println("Complete");
	}

}
