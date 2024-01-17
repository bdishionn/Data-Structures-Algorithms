package ecolicounts;

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
		String ecoli = readFile(filename);

		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < ecoli.length(); i++) {
			char currChar = ecoli.charAt(i);
			if (currChar == 'A')
				count += 1;
			if (currChar == 'C')
				count1 += 1;
			if (currChar == 'G')
				count2 += 1;
			if (currChar == 'T')
				count3 += 1;

		}
		println("#A = " + count);
		println("#C = " + count1);
		println("#G = " + count2);
		println("#T = " + count3);
	}
}
