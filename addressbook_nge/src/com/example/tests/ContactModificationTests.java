package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		//save old state
		
		List<ContactData> oldList = app.getContactHelper().getContacts();
		//actions
		app.getContactHelper().initContactModification(0);
		ContactData contactObject = new ContactData();
		contactObject.lastname = "new lastname";
		app.getContactHelper().fillContactEntry(contactObject);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();
		
		  //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare states
	    oldList.remove(0);
	    oldList.add(contactObject);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
