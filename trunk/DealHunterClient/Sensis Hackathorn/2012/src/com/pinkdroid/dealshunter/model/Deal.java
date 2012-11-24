package com.pinkdroid.dealshunter.model;

import java.util.Date;

public class Deal {
	int dealId;
	Business businessInfo;

	Date startTime;
	Date endTime;
	double distance;
	int categoryId;
	UserFeedback feedback;
	int ratingStatus;
	String imageUrl;
	String discountDescription;

	public Deal(int dealId, Business businessInfo, Date startTime, Date endTime, int categoryId, UserFeedback feedback, int ratingStatus, String imageUrl, String discountDescription) {
		super();
		this.dealId = dealId;
		this.businessInfo = businessInfo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.categoryId = categoryId;
		this.feedback = feedback;
		this.ratingStatus = ratingStatus;
		this.imageUrl = imageUrl;
		this.discountDescription = discountDescription;
	}

	public Deal(int dealId, Business businessInfo, Date startTime, Date endTime, double distance, int categoryId, UserFeedback feedback, int ratingStatus, String imageUrl,
			String discountDescription) {
		super();
		this.dealId = dealId;
		this.businessInfo = businessInfo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.distance = distance;
		this.categoryId = categoryId;
		this.feedback = feedback;
		this.ratingStatus = ratingStatus;
		this.imageUrl = imageUrl;
		this.discountDescription = discountDescription;
	}

	public Business getBusinessInfo() {
		return businessInfo;
	}

	public void setBusinessInfo(Business businessInfo) {
		this.businessInfo = businessInfo;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}	

	public int getRatingStatus() {
		return ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		this.ratingStatus = ratingStatus;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	public UserFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(UserFeedback feedback) {
		this.feedback = feedback;
	}

	public static class UserFeedback {
		private int thumbUpNo = 0;
		private int thumbDownNo = 0;
		public UserFeedback(int thumbUpNo, int thumbDownNo) {
			super();
			this.thumbUpNo = thumbUpNo;
			this.thumbDownNo = thumbDownNo;
		}

		public int getThumbUpNo() {
			return thumbUpNo;
		}

		public void setThumbUpNo(int thumbUpNo) {
			this.thumbUpNo = thumbUpNo;
		}

		public int getThumbDownNo() {
			return thumbDownNo;
		}

		public void setThumbDownNo(int thumbDownNo) {
			this.thumbDownNo = thumbDownNo;
		}
		public int getScore(){
			return thumbUpNo - thumbDownNo;
		}
	}

}
