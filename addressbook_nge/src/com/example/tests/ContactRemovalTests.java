package com.example.tests;

import static org.testng.Assert.assertEquals;



import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import utils.ListOf;
import utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {

		//save old state
		SortedListOf<ContactData> oldList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		//actions
		//app.getContactHelper().deleteContact(index);
		app.getContactHelper().deleteContactById(oldList.get(index).getId());

		
		  //save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
	    //compare states
		//+++
		//Collections.sort(oldList);
		//Collections.sort(newList);
		
		assertThat(newList, equalTo(oldList.without(index)));
		
	}
}
