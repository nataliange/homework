package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import utils.SortedListOf;

import com.example.fw.ContactHelper;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
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
