package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class MovieEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="director")
	private String director;
	
	@ManyToOne
	@JoinColumn(name="genre_id")
	private GenreEntity genre;
	
	@Column(name="description")
	private String description;

	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieEntity(String title, String director, GenreEntity genre, String description) {
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

	public GenreEntity getGenre() {
		return genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
