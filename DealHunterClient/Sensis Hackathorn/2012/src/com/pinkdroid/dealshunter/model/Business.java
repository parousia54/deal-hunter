package com.pinkdroid.dealshunter.model;

import java.util.ArrayList;

public class Business {
	int businessId;
	Address address;
	boolean isVerified;
	String businessName;
	String businessPhone;
	String businessWebsite;
	String logoUrl;

	public static ArrayList<Business> businesses = new ArrayList<Business>();

	static {
		businesses.add(new Business(1, new Address("0", "106", "Chapel St", "St Kilda", "Victoria", "3182"), true, "Parlour Hairdressing", "(03) 9593 6601", "1"));
		businesses.add(new Business(2, new Address("0", "314", "Bourke St", "Melbourne CBD", "Victoria", "3000"), false, "MYERS", "(03) 9593 6601", "2"));
		businesses.add(new Business(3, new Address("0", "45", "Collins St", "Melbourne CBD", "Victoria", "3000"), true, "DENDY Cinema", "(03) 9675 3345", "3"));
		businesses.add(new Business(4, new Address("0", "140", "Bourke St", "Melbourne CBD", "Victoria", "3000"), false, "Hoyts Cinema", "(03) 9663 3303", "4"));
		businesses.add(new Business(5, new Address("0", "106", "Lygon St", "Carlton", "Victoria", "3053"), true, "Mai Thai Vietnamese Restaurant", "(03) 9077 8935", "5"));
	}

	public Business(int businessId, Address address, boolean isVerified, String businessName, String businessPhone, String logoUrl) {
		super();
		this.businessId = businessId;
		this.address = address;
		this.isVerified = isVerified;
		this.businessName = businessName;
		this.businessPhone = businessPhone;
		this.logoUrl = logoUrl;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getBusinessWebsite() {
		return businessWebsite;
	}

	public void setBusinessWebsite(String businessWebsite) {
		this.businessWebsite = businessWebsite;
	}

	public static class Address {
		private String unitNumber;
		private String streetNumber;
		private String streetName;
		private String suburb;
		private String postCode;
		private String country;

		public Address(String unitNumber, String streetNumber, String streetName, String suburb, String postCode, String country) {
			super();
			this.unitNumber = unitNumber;
			this.streetNumber = streetNumber;
			this.streetName = streetName;
			this.suburb = suburb;
			this.postCode = postCode;
			this.country = country;
		}

		public String getUnitNumber() {
			return unitNumber;
		}

		public void setUnitNumber(String unitNumber) {
			this.unitNumber = unitNumber;
		}

		public String getStreetNumber() {
			return streetNumber;
		}

		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}

		public String getStreetName() {
			return streetName;
		}

		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}

		public String getSuburb() {
			return suburb;
		}

		public void setSuburb(String suburb) {
			this.suburb = suburb;
		}

		public String getPostCode() {
			return postCode;
		}

		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
	}
}
