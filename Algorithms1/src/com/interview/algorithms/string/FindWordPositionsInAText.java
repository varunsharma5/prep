package com.interview.algorithms.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * http://www.ardendertat.com/2011/12/20/programming-interview-questions-23-find
 * -word-positions-in-text/
 * 
 * @author ajitkoti
 *
 */
public class FindWordPositionsInAText {
	private static Trie trie = new Trie();

	public static void readAndIndex() {
		// Read word from a file and insert into trie
		File file = new File("/home/ajitkoti/Downloads/sample.txt");
		try {
			FileInputStream fip = new FileInputStream(file);
			BufferedReader fileBuffer = new BufferedReader(
					new InputStreamReader(fip));
			String line = fileBuffer.readLine();
			long poistion = getFilePos(fip);

			String[] words = line.split("");
			for (String word : words) {
				trie.insert(word, poistion);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static long getFilePos(FileInputStream fip) throws IOException {
		return fip.getChannel().position();
	}

	public static void main(String[] args) {
		readAndIndex();
	}

}

class Trie {
	private TrieNode root;
	private List<Long> wordPositions;

	public Trie() {
		root = new TrieNode((char) 0);
	}

	// Method to insert a new word to Trie
	public void insert(String word, long position) {

		// Find length of the given word
		int length = word.length();
		TrieNode crawl = root;

		// Traverse through all characters of given word
		for (int level = 0; level < length; level++) {
			HashMap<Character, TrieNode> child = crawl.getChildren();
			char ch = word.charAt(level);

			// If there is already a child for current character of given word
			if (child.containsKey(ch))
				crawl = child.get(ch);
			else // Else create a child
			{
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl = temp;
			}
		}

		// Set bIsEnd true for last character
		crawl.setIsEnd(true);

		wordPositions.add(position);
	}

	public List<Long> getWordPositions() {
		return wordPositions;
	}

	public void setWordPositions(List<Long> wordPositions) {
		this.wordPositions = wordPositions;
	}

	public void adddWordPositions(Long wordPositions) {
		this.wordPositions.add(wordPositions);
	}

}

class TrieNode {
	public int occurrence;
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean bIsEnd;

	public TrieNode(char ch) {
		value = ch;
		children = new HashMap<Character, TrieNode>();
		bIsEnd = false;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public char getValue() {
		return value;
	}

	public void setIsEnd(boolean val) {
		bIsEnd = val;
	}

	public boolean isEnd() {
		return bIsEnd;
	}

	public static Comparator<TrieNode> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

}