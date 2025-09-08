package lms;

import java.util.Objects;

public class Book {
	private int id;
	private String title;
	private String author;
	private boolean available; // true = Available, false = Issued

	public Book(int id, String title, String author, boolean available) {
		// super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.available = available;
	}

	public int getId() {
		return id; }

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	// Keep CSV simple: replace commas to avoid breaking file format
	private static String sanitize(String s) {
		return s == null ? "" : s.replace(",", " ");
	}

	public String toCsv() {
		return id + "," + sanitize(title) + "," + sanitize(author) + "," + available;
	}

	@Override
	public String toString() {
		return String.format("%-6d | %-30s | %-20s | %-10s", id, title, author, available ? "Available" : "Issued");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;
		Book book = (Book) o;
		return id == book.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}



