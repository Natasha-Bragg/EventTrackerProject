package com.skilldistillery.newparent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Baby {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String age;
	
	@Column(name = "last_feed")
	private String lastFeed;
	
	@Column(name = "time_slept")
	private String timeSlept;
	
	@Column(name = "number_of_naps")
	private String numberOfNaps;
	
	@Column(name = "number_of_diaper_changes")
	private String numberOfDiaperChanges;


	public Baby() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	

	public String getLastFeed() {
		return lastFeed;
	}

	public void setLastFeed(String lastFeed) {
		this.lastFeed = lastFeed;
	}

	public String getTimeSlept() {
		return timeSlept;
	}

	public void setTimeSlept(String timeSlept) {
		this.timeSlept = timeSlept;
	}

	public String getNumberOfNaps() {
		return numberOfNaps;
	}

	public void setNumberOfNaps(String numberOfNaps) {
		this.numberOfNaps = numberOfNaps;
	}

	public String getNumberOfDiaperChanges() {
		return numberOfDiaperChanges;
	}

	public void setNumberOfDiaperChanges(String numberOfDiaperChanges) {
		this.numberOfDiaperChanges = numberOfDiaperChanges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baby other = (Baby) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Baby [id=").append(id).append(", name=").append(name).append(", age=").append(age)
				.append(", lastFeed=").append(lastFeed).append(", timeSlept=").append(timeSlept)
				.append(", numberOfNaps=").append(numberOfNaps).append(", numberOfDiaperChanges=")
				.append(numberOfDiaperChanges).append("]");
		return builder.toString();
	}


	
	

}
