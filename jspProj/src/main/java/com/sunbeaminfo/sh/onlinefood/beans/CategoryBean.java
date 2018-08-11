package com.sunbeaminfo.sh.onlinefood.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;

public class CategoryBean {
	private List<String> categoryList;
	public CategoryBean() {
		this.categoryList = new ArrayList<>();
	}
	
	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public void execute() {
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			categoryList = dao.getCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
