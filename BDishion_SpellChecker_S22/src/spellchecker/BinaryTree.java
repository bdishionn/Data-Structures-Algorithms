package spellchecker;

import java.util.*;

public class BinaryTree {

	public BinaryTreeNode top, cur;

	public BinaryTree() {
		super();
		top = null;
	}


	public void insert(String word) {
		word = word.trim();
		if (top == null)
			top = new BinaryTreeNode(word);

		cur = top;

		while (true) {
			int comp = cur.value.compareToIgnoreCase(word);
			if (comp > 0) {
				if (cur.left == null) {
					cur.left = new BinaryTreeNode(word);
					break;
				} else
					cur = cur.left;
			} else if (comp < 0) {
				if (cur.right == null) {
					cur.right = new BinaryTreeNode(word);
					break;
				} else
					cur = cur.right;

			} else
				break;
		}

	}


	public ArrayList<String> saveTreePreOrder(BinaryTreeNode node) {
		var preOrder = new ArrayList<String>();
		if (node != null) {

			preOrder.add(node.value);
			preOrder.addAll(saveTreePreOrder(node.left));
			preOrder.addAll(saveTreePreOrder(node.right));
			return preOrder;

		}
		return preOrder;
	}

}
