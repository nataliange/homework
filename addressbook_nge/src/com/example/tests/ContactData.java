package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String mail1;
	public String mail2;
	public String bday;
	public String bmonth;
	public String byear;
	public String groupfield;
	public String optionaladdress;
	public String optionalhomephone;

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String mail1, String mail2, String bday, String bmonth,
			String byear, String groupfield, String optionaladdress, String optionalhomephone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.groupfield = groupfield;
		this.optionaladdress = optionaladdress;
		this.optionalhomephone = optionalhomephone;
	}
}