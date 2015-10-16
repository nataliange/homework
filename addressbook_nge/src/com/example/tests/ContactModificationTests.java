package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.SortedListOf;

import com.example.fw.ContactHelper;

import static com.example.fw.ContactHelper.MODIFICATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

public class ContactModificationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]>contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contactObjects.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void modifySomeContact(ContactData contactObject) {

		//save old state
		
		SortedListOf<ContactData> oldList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		//actions
		app.getContactHelper().modifyContact(index, contactObject);
		//+++
		contactObject.setId(oldList.get(index).getId());

		
		  //save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
	    //compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contactObject)));

	}

}
