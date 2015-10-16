package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;




import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "groupsFromFile")//randomValidGroupGenerator
	public void modifySomeGroup(GroupData group) {
		
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().modifyGroup(index, group);
		
		//save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    
	    //compare contents
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    }
}
