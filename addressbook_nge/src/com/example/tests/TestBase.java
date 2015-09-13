package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i<5; i++){
			GroupData group = new GroupData()
			.withGroupname(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		} 
	}
	
	@DataProvider
	public Iterator<Object[]>randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
				for (int i = 0; i < 5; i++){
			ContactData contactObject = new ContactData()
			.withFirstname(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withHomephone(generateRandomString())
			.withMobilephone(generateRandomString())
			.withWorkphone(generateRandomString())
			.withMail1(generateRandomString())
			.withMail2(generateRandomString())
			//.withBday(generateRandomString())//
			//.withBmonth(generateRandomString())//
			//.withByear(generateRandomString())//
			.withGroupfield(generateRandomString())
			.withOptionaladdress(generateRandomString())
			.withOptionalhomephone(generateRandomString());
			
			list.add(new Object[]{contactObject});
		}
		return list.iterator();
	}
	public String generateRandomString1(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
			} else {
				return "test" + rnd.nextInt();
			}
	}

}
