package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	
	public ApplicationManager()	{
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    //navigationHelper = new NavigationHelper(this);
	    //groupHelper = new GroupHelper(this);
	    //contactHelper = new ContactHelper(this);
	    
	}
	
	public void stop() {
		driver.quit();
		
	}
//lazy initialization
	public NavigationHelper getNavigationHelper() {
		if (navigationHelper==null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper==null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper==null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}



}
