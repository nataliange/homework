package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ListOf;
import utils.SortedListOf;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
cachedContacts = new SortedListOf<ContactData>();

		manager.navigateTo().mainPage();
		int index = 0;
		List<WebElement> cells = driver.findElements(By.xpath("//tr[@name='entry'][" + (index  + 1)	+ "]/td[3]"));
		for (WebElement cell : cells) {
			String tag = cell.getTagName();
			String lastname = tag.substring("<td>".length(), tag.length() - "</td>".length());
			cachedContacts.add(new ContactData().withLastname(lastname));
		}
	}
	
	
/*		private void rebuildCache() {
cachedContacts = new SortedListOf<ContactData>();

		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String lastname = title.substring("Select (".length(), title.length());
			cachedContacts.add(new ContactData().withLastname(lastname));
		}
	}*/
	
	

	public ContactHelper createContact(ContactData contactObject, boolean CREATION) {
		manager.navigateTo().mainPage();
	    initContactCreation();
		fillContactEntry(contactObject, CREATION);
	    submitContactCreation();
	    returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contactObject,
			boolean MODIFICATION) {
		initContactModification(index);
		fillContactEntry(contactObject, MODIFICATION);
		updateContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {

		initContactModification(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();
		return this;
		
	}

	//-------------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactEntry(ContactData contactObject,
			boolean formType) {
		type(By.name("firstname"), contactObject.getFirstname());
		type(By.name("lastname"), contactObject.getLastname());
		type(By.name("address"), contactObject.getAddress());
		type(By.name("home"), contactObject.getHomephone());
		type(By.name("mobile"), contactObject.getMobilephone());
		type(By.name("work"), contactObject.getWorkphone());
		type(By.name("email"), contactObject.getMail1());
		type(By.name("email2"), contactObject.getMail2());
		selectByText(By.name("bday"), contactObject.getBday());
		selectByText(By.name("bmonth"), contactObject.getBmonth());
		type(By.name("byear"), contactObject.getByear());
				if (formType == CREATION) {
			// selectByText(By.name("new_group"), contactObject.groupfield);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error(
						"Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contactObject.getOptionaladdress());
		type(By.name("phone2"), contactObject.getOptionalhomephone());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("//tr[@name='entry'][" + (index + 1)
				+ "]/td/a/img[@title='Edit']"));
		return this;
	}



	public ContactHelper updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;

	}


	public ContactHelper submitContactDeletion() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}
}
