package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

public class NewContactCreation extends TestBase {


	
  @org.testng.annotations.Test (dataProvider = "randomValidContactGenerator")
  public void contactCreationWithValidData(ContactData contactObject) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	//actions
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
