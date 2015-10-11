package com.example.tests;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.SortedListOf;

import com.example.fw.GroupHelper;


import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreation extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	

@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  
    //save old state
	  SortedListOf<GroupData> oldList = app.getModel().getGroups();
    
    //actions
	app.getGroupHelper().createGroup(group);
 
    //save new state
	SortedListOf<GroupData> newList = app.getModel().getGroups();
    //compare states (size)
    //assertEquals(newList.size(), oldList.size() +1);
	
    //compare contents
	assertThat(newList, equalTo(oldList.withAdded(group)));
    
	//compare model to implementation
	if (wantToCheck()) {
	if ("yes".equals(app.getProperty("check.db"))) {
		assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	}
	if ("yes".equals(app.getProperty("check.ui"))) {
		assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
	}
	}
  }

}
