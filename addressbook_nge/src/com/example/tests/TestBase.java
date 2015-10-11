package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
	
	protected ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configfile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		checkCounter = 0;
	    checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	  }
	
	protected boolean wantToCheck() {
		checkCounter++;
		if (checkCounter > checkFrequency) {
			checkCounter = 0; 
			return true;
		} else {
			return false;
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}
/////////////////////////////////////////

	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contactObjects) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(ContactData contactObject : contactObjects) {
			list.add(new Object[] {contactObject});
		}
		return list;
	}


}
