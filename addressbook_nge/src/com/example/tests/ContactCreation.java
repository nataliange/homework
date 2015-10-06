package com.example.tests;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;

import utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;


public class ContactCreation extends TestBase { 
	
	@DataProvider
	public Iterator<Object[]>contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contactObjects.xml"))).iterator();
	}

	
@org.testng.annotations.Test (dataProvider = "contactsFromFile")
  public void contactCreationWithValidData(ContactData contactObject) throws Exception {
	
	//save old state
	 SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	//actions
	app.getContactHelper().createContact(contactObject);
	
	
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	
    //compare states
	assertThat(newList, equalTo(oldList.withAdded(contactObject)));

  }

}
