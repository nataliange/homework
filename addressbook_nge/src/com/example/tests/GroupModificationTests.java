package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;



import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")//randomValidGroupGenerator
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
