package example.entity;

import java.util.Objects;

public class MovieTitleAndyear {
	
	private String title;
	private int year;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(title, year);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieTitleAndyear other = (MovieTitleAndyear) obj;
		return Objects.equals(title, other.title) && year == other.year;
	}



	@Override
	public String toString() {
		return "MovieTitleAndyear [title=" + title + ", year=" + year + "]";
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public MovieTitleAndyear(String title, int year) {
		super();
		this.title = title;
		this.year = year;
	}



	public MovieTitleAndyear() {
		
	}

}
