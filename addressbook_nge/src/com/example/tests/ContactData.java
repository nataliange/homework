package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String mail1;
	private String mail2;
	private String bday;
	private String bmonth;
	private String byear;
	private String groupfield;
	private String optionaladdress;
	private String optionalhomephone;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getMail1() {
		return mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getGroupfield() {
		return groupfield;
	}

	public String getOptionaladdress() {
		return optionaladdress;
	}

	public String getOptionalhomephone() {
		return optionalhomephone;
	}

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

	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withMail1(String mail1) {
		this.mail1 = mail1;
		return this;
	}

	public ContactData withMail2(String mail2) {
		this.mail2 = mail2;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withGroupfield(String groupfield) {
		this.groupfield = groupfield;
		return this;
	}

	public ContactData withOptionaladdress(String optionaladdress) {
		this.optionaladdress = optionaladdress;
		return this;
	}

	public ContactData withOptionalhomephone(String optionalhomephone) {
		this.optionalhomephone = optionalhomephone;
		return this;
	}
	
	
}