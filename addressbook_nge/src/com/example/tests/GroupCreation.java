package com.example.tests;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.SortedListOf;

import com.example.fw.GroupHelper;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreation extends TestBase {
	
	
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  
    //save old state
	  SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
	app.getGroupHelper().createGroup(group);
 
    //save new state
	SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    //compare states (size)
    //assertEquals(newList.size(), oldList.size() +1);
	
    //compare contents
	assertThat(newList, equalTo(oldList.withAdded(group)));
    
  }

}
