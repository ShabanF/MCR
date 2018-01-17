package mcr.model;

public class Movie {
	
	private int id;
	
	private String title;
	
	private String director;
	
	private Genre genre;
	
	private String description;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String director, Genre genre, String description) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.description = description;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
