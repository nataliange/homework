package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length<3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2]; 
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		
		List<ContactData> contactObjects = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contactObjects, file);
			} else if ("xml".equals(format)) {
				saveContactsToXmlFile(contactObjects, file);
			} else {
				System.out.println("Unknown format " + format);
				return;
			}
	}

	private static void saveContactsToXmlFile(List<ContactData> contactObjects, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contactObject", ContactData.class);
		String xml = xstream.toXML(contactObjects);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contactObject", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contactObjects,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contactObject : contactObjects) {
			writer.write(contactObject.getLastname() + "," + contactObject.getFirstname() + ",!" + "\n");
		}
		writer.close();
		
	}
	
	  public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		  List<ContactData> list = new ArrayList<ContactData>();
		  FileReader reader = new FileReader(file);
		  BufferedReader bufferedReader = new BufferedReader(reader);
		  String line = bufferedReader.readLine();
		  while (line != null) {
			String[] part = line.split(",");
			ContactData contactObject = new ContactData()
			.withAddress(part[0])
			.withBday(part[1])
			.withBmonth(part[2])
			.withByear(part[3])
			.withFirstname(part[4])
			.withGroupfield(part[5])
			.withHomephone(part[6])
			.withLastname(part[7])
			.withMail1(part[8])
			.withMail2(part[9])
			.withMobilephone(part[10])
			.withOptionaladdress(part[11])
			.withOptionalhomephone(part[12])
			.withWorkphone(part[13]);
			
			list.add(contactObject);
			  line = bufferedReader.readLine();
		}
		  bufferedReader.close();
		  return list;
		}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
	ContactData contactObject = new ContactData()
	.withFirstname(generateRandomString1())
	.withLastname(generateRandomString1())
	.withAddress(generateRandomString1())
	.withHomephone(generateRandomString1())
	.withMobilephone(generateRandomString1())
	.withWorkphone(generateRandomString1())
	.withMail1(generateRandomString1())
	.withMail2(generateRandomString1())
	//.withBday(generateRandomString())//
	//.withBmonth(generateRandomString())//
	//.withByear(generateRandomString())//
	.withGroupfield(generateRandomString1())
	.withOptionaladdress(generateRandomString1())
	.withOptionalhomephone(generateRandomString1());
	
	list.add(contactObject);
}
return list;
	}
	
	public static String generateRandomString1(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
			} else {
				return "test" + rnd.nextInt();
			}
	}

}
