package quizmanagementsystem.model;

import java.util.LinkedList;

public class Quiz {
	private int id;
	private String title;
	
	public Quiz() {
		super();
	}

	public Quiz(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String i) {
		this.title = i;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + "]";
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	private LinkedList<Question> questions =
	        new LinkedList<>();
	
	
}
