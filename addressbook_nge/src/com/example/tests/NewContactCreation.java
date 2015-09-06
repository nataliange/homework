package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class NewContactCreation extends TestBase {


  @org.testng.annotations.Test
  public void addNewNotEmptyContact() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	//actions
    app.getContactHelper().initContactCreation();
    ContactData contactObject = new ContactData();
    contactObject.firstname = "Max";
    contactObject.lastname = "Braun";
    contactObject.address = "Test street";
    contactObject.homephone = "12345";
    contactObject.mobilephone = "54321";
    contactObject.workphone = "11111";
    contactObject.mail1 = "max.braun@gmail.com";
    contactObject.mail2 = "braun@gmail.com";
    contactObject.bday = "1";
    contactObject.bmonth = "January";
    contactObject.byear = "1970";
    contactObject.groupfield = "group1";
    contactObject.optionaladdress = "secondary address";
    contactObject.optionalhomephone = "112";
	app.getContactHelper().fillContactEntry(contactObject);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    //assertEquals(newList.size(), oldList.size() + 1);
    oldList.add(contactObject);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

  
  
  @org.testng.annotations.Test
  public void addNewEmptyContact() throws Exception {
	app.getNavigationHelper().openMainPage();
	//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		//actions
	ContactData contactObject = new ContactData("", "", "", "", "", "", "", "",  "-", "-", "", "", "", "");
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactEntry(contactObject);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
  //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    oldList.add(contactObject);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  

}
