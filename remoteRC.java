package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class remoteRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://login.salesforce.com/");
		selenium.start();
	}

	@Test
	public void testRemoteRC() throws Exception {
		selenium.open("https://login.salesforce.com/");
		selenium.type("id=username", "anushatagore@gmail.com");
		selenium.type("id=password", "Vikas@123");
		selenium.click("id=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Hotels");
		selenium.waitForPageToLoad("30000");
		selenium.click("//form[@id='hotlist']/table/tbody/tr/td[2]/input");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=Name", "BBQ");
		selenium.click("//td[@id='bottomButtonRow']/input");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=setupLink");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=userNavLabel");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
