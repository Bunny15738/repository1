package example.entity;

import java.util.Objects;

public class Course {
	private String courseId;
	private String name;
	private int duration;
	private int fees;
	
	@Override
	public int hashCode() {
		return Objects.hash(courseId, duration, fees, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId) && duration == other.duration && fees == other.fees
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", duration=" + duration + ", fees=" + fees + "]";
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Course(String courseId, String name, int duration, int fees) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}
	

}
