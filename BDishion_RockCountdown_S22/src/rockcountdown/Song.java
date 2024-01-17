package rockcountdown;

import static sbcc.Core.*;

public class Song {

	// private fields
	private int rank;
	private String title;
	private String artist;

	// getters and setters
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	// constructor with parameters
	public Song(int rank, String title, String artist) {
		this.rank = rank;
		this.title = title;
		this.artist = artist;
	}


	// one String constructor and assigning tokens
	public Song(String titles) {
		super();
		String[] parts = titles.split("\t");
		rank = parseInt(parts[0]);
		title = parts[1];
		artist = parts[2];
	}

}
