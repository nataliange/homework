package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NewContactCreation extends TestBase {


  @org.testng.annotations.Test
  public void addNewNotEmptyContact() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contactObject = new ContactData();
    contactObject.firstname = "Max";
    contactObject.lastname = "Braun";
    contactObject.address = "Test street";
    contactObject.homephone = "12345";
    contactObject.mobilephone = "54321";
    contactObject.workphone = "11111";
    contactObject.mail1 = "max.braun@gmail.com";
    contactObject.mail2 = "braun@gmail.com";
    contactObject.bday = "1";
    contactObject.bmonth = "January";
    contactObject.byear = "1970";
    contactObject.groupfield = "group1";
    contactObject.optionaladdress = "secondary address";
    contactObject.optionalhomephone = "112";
	app.getContactHelper().fillContactEntry(contactObject);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

  @org.testng.annotations.Test
  public void addNewEmptyContact() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contactObject = new ContactData("", "", "", "", "", "", "", "",  "-", "-", "", "", "", "");
	app.getContactHelper().fillContactEntry(contactObject);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  

}
