package spellchecker;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.reflect.*;

public class BasicDictionary implements Dictionary {

	private BinaryTree tree;
	private int count;

	public BasicDictionary() {
		tree = new BinaryTree();
		count = 0;
	}


	@Override
	public void importFile(String filename) throws Exception {
		tree = new BinaryTree();
		var words = readFileAsLines(filename);
		Collections.shuffle(words);
		for (var word : words)
			add(word);
	}


	@Override
	public void load(String filename) throws Exception {
		tree = new BinaryTree();
		for (var word : readFileAsLines(filename))
			this.add(word);

	}


	@Override
	public void save(String filename) throws Exception {
		var words = tree.saveTreePreOrder(getRoot());
		FileWriter f = new FileWriter(filename);
		for (var word : words)
			f.write(word + "\n");
		f.close();
	}


	@Override
	public String[] find(String word) {
		String s[] = { "", "" };
		BinaryTreeNode curr = tree.top;
		while (true) {
			int comp = curr.value.compareToIgnoreCase(word);

			if (comp > 0) {
				s[1] = curr.value;
				if (curr.left != null)
					curr = curr.left;
				else
					return s;

			} else if (comp < 0) {
				s[0] = curr.value;
				if (curr.right != null)
					curr = curr.right;
				else
					return s;
			} else
				return null;

		}
	}


	@Override
	public void add(String word) {
		tree.insert(word.trim());
	}


	@Override
	public BinaryTreeNode getRoot() {
		return tree.top;
	}


	@Override
	public int getCount() {
		return count;
	}


	public ArrayList<String> preOrder() {
		return tree.saveTreePreOrder(getRoot());
	}

}
