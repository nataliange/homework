package com.example.tests;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;

import utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

public class ContactCreation extends TestBase {

	
  @org.testng.annotations.Test (dataProvider = "randomValidContactGenerator")
  public void contactCreationWithValidData(ContactData contactObject) throws Exception {
	
	//save old state
	 SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	//actions
	app.getContactHelper().createContact(contactObject, CREATION);
	
	
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	
    //compare states
	assertThat(newList, equalTo(oldList.withAdded(contactObject)));

  }

}
