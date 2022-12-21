package example.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //THis indiacates that Movie is not ordinary class it is Entity Class
@Table(name = "movie_master")//This it to map ENtity class to table
public class Movie {
	@Id //Applied  at field level of field movieId to treat as Identity
	@Column(name = "movie_Id")
	private String movieId;
	@Column(name = "movie_title")
	private String title;
	@Column(name = "movie_genre")
	private String genre;
	@Column(name = "movie_year")
	private int year;
	

	@Override
	public int hashCode() {
		return Objects.hash(genre, movieId, title, year);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(movieId, other.movieId)
				&& Objects.equals(title, other.title) && year == other.year;
	}


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", year=" + year + "]";
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Movie(String movieId, String title, String genre, int year) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
	}


	public Movie() {
		// TODO Auto-generated constructor stub
	}

}
