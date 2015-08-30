package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contactObject = new ContactData();
		contactObject.lastname = "new lastname";
		app.getContactHelper().fillContactEntry(contactObject);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();
	}

}
