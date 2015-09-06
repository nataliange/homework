package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactEntry(ContactData contactObject) {
		type(By.name("firstname"), contactObject.firstname);
		type(By.name("lastname"), contactObject.lastname);
		type(By.name("address"), contactObject.address);
		type(By.name("home"), contactObject.homephone);
		type(By.name("mobile"), contactObject.mobilephone);
		type(By.name("work"), contactObject.workphone);
		type(By.name("email"), contactObject.mail1);
		type(By.name("email2"), contactObject.mail2);
		selectByText(By.name("bday"), contactObject.bday);
		selectByText(By.name("bmonth"), contactObject.bmonth);
		type(By.name("byear"), contactObject.byear);
		// selectByText(By.name("new_group"), contactObject.groupfield);
		type(By.name("address2"), contactObject.optionaladdress);
		type(By.name("phone2"), contactObject.optionalhomephone);

	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	// //////////////////////////////////////////////
	public void initContactModification(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		// click(By.xpath("//img[@title='Edit[]'][" + index + "]"));
		click(By.xpath("//img[starts-with(@title, 'Edit')]"));
	}

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));

	}

	public void updateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));

	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contactObjects = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contactObject = new ContactData();
			String title = checkbox.getAttribute("title");
			contactObject.lastname = title.substring("Select (".length(), title.length() - ")".length());
			//contactObject.lastname = title.substring(title.indexOf("Select (Max" + 1, title.indexOf(")")));
			

			contactObjects.add(contactObject);
		}
		return contactObjects;
	}

}
