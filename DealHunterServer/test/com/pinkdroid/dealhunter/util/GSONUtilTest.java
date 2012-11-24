package com.pinkdroid.dealhunter.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pinkdroid.dealhunter.model.Address;
import com.pinkdroid.dealhunter.model.User;


public class GSONUtilTest {

	
	@Test
	public void test() {
		
		User user = new User("testUser","testPassword",new Address("1/3","Test St", "Test Suburb","Test State","1234"),"12345678",true );
		System.out.println(GSONUtil.UsertoJSON(user));
		
		fail("Not yet implemented");
	}

}
