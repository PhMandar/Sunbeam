package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.entities.Item;

public class CategoryItemsBean {
	private String category;
	private List<Item> itemList;
	public CategoryItemsBean() {
		this.category = "";
		this.itemList = new ArrayList();
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void execute() {
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			itemList = dao.getItems(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
