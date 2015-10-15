package com.example.fw;

import java.util.List;

import com.example.tests.GroupData;

import utils.SortedListOf;

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	
	
	//public SortedListOf<GroupData> getGroups() {
		//return groups;
	//}
	
	public SortedListOf<GroupData> getGroups() {
			return groups = new SortedListOf<GroupData>(groups);
		}
	
	public void setGroups(List<GroupData> listGroups) {
		this.groups = new SortedListOf<GroupData>(listGroups);
		
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}



}
