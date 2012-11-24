package src.com.pinkdroid.dealhunter.model;

import java.io.File;
import java.util.Date;

public class Deal {
	String id;
	String dealTitle;
	String dealDescription;
	File dealImage;
	Date dealStartDate;
	Date dealEndDate;
	int dealScore; // similar to reddit upvote/downvote score
	String username;

	public Deal() {
		super();
	}

	public Deal(String id, String dealTitle, String dealDescription,
			File dealImage, Date dealStartDate, Date dealEndDate,
			int dealScore, String username) {
		super();
		this.id = id;
		this.dealTitle = dealTitle;
		this.dealDescription = dealDescription;
		this.dealImage = dealImage;
		this.dealStartDate = dealStartDate;
		this.dealEndDate = dealEndDate;
		this.dealScore = dealScore;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDealTitle() {
		return dealTitle;
	}

	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}

	public String getDealDescription() {
		return dealDescription;
	}

	public void setDealDescription(String dealDescription) {
		this.dealDescription = dealDescription;
	}

	public File getDealImage() {
		return dealImage;
	}

	public void setDealImage(File dealImage) {
		this.dealImage = dealImage;
	}

	public Date getDealStartDate() {
		return dealStartDate;
	}

	public void setDealStartDate(Date dealStartDate) {
		this.dealStartDate = dealStartDate;
	}

	public Date getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(Date dealEndDate) {
		this.dealEndDate = dealEndDate;
	}

	public int getDealScore() {
		return dealScore;
	}

	public void setDealScore(int dealScore) {
		this.dealScore = dealScore;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
