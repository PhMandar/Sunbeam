package com.sunbeaminfo.sh.onlinefood.beans;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.entities.Item;

public class ItemBean {
	private int id;
	private Item item;
	public ItemBean() {
		this.id = 0;
		this.item = new Item();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void findItem() {
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			item = dao.getItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
