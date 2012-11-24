package src.com.pinkdroid.dealhunter.model;

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
public class Address {
	
	String streetNumber;
	String streetName;
	String suburb;
	String state;
	String postCode;
	
	public Address() {
		super();
	}
	public Address(String streetNumber, String streetName, String suburb,
			String state, String postCode) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.suburb = suburb;
		this.state = state;
		this.postCode = postCode;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	

}
