package spellchecker;

import static sbcc.Core.*;

import java.io.*;
import java.util.regex.*;

public class BasicSpellChecker implements SpellChecker {
	BasicDictionary dict;
	String document;
	int i;

	public BasicSpellChecker() {
		super();
		dict = new BasicDictionary();
		i = 0;
		document = "";
	}


	@Override
	public void importDictionary(String filename) throws Exception {
		dict.importFile(filename);

	}


	@Override
	public void loadDictionary(String filename) throws Exception {
		dict.load(filename);

	}


	@Override
	public void saveDictionary(String filename) throws Exception {
		dict.save(filename);

	}


	@Override
	public void loadDocument(String filename) throws Exception {
		document = readFile(filename);

	}


	@Override
	public void saveDocument(String filename) throws Exception {
		FileWriter f = new FileWriter(filename);
		var strToBytes = document.getBytes();
		for (var str : strToBytes)
			f.write(str);
		f.close();
	}


	@Override
	public String getText() {
		return document;

	}


	@Override
	public String[] spellCheck(boolean continueFromPrevious) {
		Pattern p = Pattern.compile("\\b[\\w|']+\\b");
		Matcher m = p.matcher(document);

		if (continueFromPrevious != true)
			i = 0;

		while (m.find(i)) {
			i = m.end();
			var s = dict.find(m.group());
			if (s != null) {
				String[] Str = { m.group(), String.valueOf(m.start()), s[0], s[1] };
				return Str;
			}

		}
		return null;
	}


	@Override
	public void addWordToDictionary(String word) {
		dict.add(word);

	}


	@Override
	public void replaceText(int startIndex, int endIndex, String replacementText) {
		i = endIndex + (replacementText.length() - (endIndex - startIndex));
		document = document.substring(0, startIndex) + replacementText + document.substring(endIndex);
	}

}
