package singlylinkedlist;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;

public class BasicSinglyLinkedList implements SinglyLinkedList {

	private Node head;
	private Node last;
	private int count = 0;

	@Override
	public Node getFirst() {
		return head;
	}


	@Override
	public Node getLast() {
		return last;
	}


	@Override
	public int size() {
		return count;
	}


	@Override
	public boolean isEmpty() {
		if (head == null & last == null)
			return true;
		else {
			return false;
		}
	}


	@Override
	public void clear() {
		Node backup = null;
		while (head.next != null) {
			backup = head.next;
			head = null;
			head = backup;
		}

	}


	@Override
	public Node insert(Node cursor, String value) {
		var newNode = new Node(value);
		if (cursor == null) { // if cursor is null, insert at front
			newNode.next = head;
			head = newNode;
		} else { // otherwise insert after cursor
			newNode.next = cursor.next;
			cursor.next = newNode;
		}
		if (newNode.next == null) { // if new node is last node
			// update reference for last node
			last = newNode.next;
			last = newNode;
		}
		count++;
		return newNode;

	}


	@Override
	public Node append(String value) {
		getLast();
		insert(last, value);
		return last;
	}


	@Override
	public void remove(Node cursor) {

		if (cursor == null) {
			return; // deleting from empty list

		}
		Node prev = null;
		Node temp = head;
		if (temp == cursor) {
			head = temp.next;
			temp.next = null;
			count--;
			return;
		}

		while (temp != null) {
			if (temp == cursor) {
				prev.next = temp.next;
				count--;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}


	@Override
	public Node find(Node start, String key) {
		Node curr = head;
		if (start != null) {
			while (curr != null && !curr.value.equals(start.value)) {
				curr = curr.next;
			}
		}
		if (curr != null) {
			while (curr != null && !curr.value.equals(key)) {
				curr = curr.next;
			}
		}
		return curr;
	}


	@Override
	public String toCsvString() {
		var str = new StringBuilder();
		Node cursor = head;
		while (cursor != null) {
			if (str.length() != 0)
				str.append(",");
			str.append(cursor);
			cursor = cursor.next;

		}
		return str.toString();

	}


	@Override
	public ArrayList<String> toList() {
		ArrayList<String> list = new ArrayList<>();
		Node curr = head;
		while (curr != null) {
			list.add(curr.value);
			curr = curr.next;

		}
		return list;

	}


	@Override
	public void loadFile(String filename) throws IOException {
		Scanner sc = new Scanner(new File(filename));
		while (sc.hasNextLine()) {
			String loadfiles = sc.nextLine().trim();
			append(loadfiles);
		}

	}


	@Override
	public void saveFile(String filename) throws IOException {
		ArrayList<String> str = new ArrayList<>();
		Node curr = head;
		while (curr != null) {
			str.add(curr.value);
			curr = curr.next;
		}
		writeFileAsLines(filename, str);

	}

}
