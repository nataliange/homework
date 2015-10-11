package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;

import utils.SortedListOf;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends WebDriverHelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
/*	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;	
	}*/
	
	public SortedListOf<GroupData> getUiGroups() {
	SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withGroupname(groupname));
		}
		return groups;
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
	    initGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreatioin();
	    returnToGroupsPage();
	    //update model
	    manager.getModel().addGroup(group);
	    return this;
		
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
	    initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		//update model
	    manager.getModel().removeGroup(index).addGroup(group);
		return this;
		
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		//update model
	    manager.getModel().removeGroup(index);
		return this;	
	}


//---------------------------------------------------------------
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;

	}

	public GroupHelper submitGroupCreatioin() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}



	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
		
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
	}



}
