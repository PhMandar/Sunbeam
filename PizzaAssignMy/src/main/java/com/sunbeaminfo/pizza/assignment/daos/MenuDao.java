package com.sunbeaminfo.pizza.assignment.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sunbeaminfo.pizza.assignment.entities.Item;
import com.sunbeaminfo.pizza.assignment.entities.ItemPrice;
import com.sunbeaminfo.pizza.assignment.util.HbUtil;

/***
 * Fetch Types i.e. Veg & NonVeg
 * Fetch Sub-Categories (see requirements)
 * Fetch Items (Pizzas) of given Type & Sub-Categories (see requirements)
 * Fetch Item of given Id
 * Fetch ItemPrice of given Id
 */
public class MenuDao {

	/**
	 * Description : Fetch Types i.e. Veg & NonVeg
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> fetchTypes(){
		List<String> lstTypes = new ArrayList<String>();
		Session session = HbUtil.getSession();
		String strQry = "select distinct i.type from Item i"; /* Here Item is class name not the db table*/
		Query qry = session.createQuery(strQry);
		lstTypes = qry.getResultList();
		return lstTypes;
	}
	
	/***
	 * Description : Fetch Sub-Categories (see requirements)
	 * @return
	 */
	public List<String> fetchSubCategories(){
		List<String> lstTypes = new ArrayList<String>();
		Session session = HbUtil.getSession();
		String strQry = "select distinct i.category from Item i"; /* Here Item is class name not the db table*/
		Query qry = session.createQuery(strQry);
		lstTypes = qry.getResultList();
		return lstTypes;
	}
	
	/***
	 * Description : Fetch Items (Pizzas) of given Type & Sub-Categories (see requirements)
	 */
	public List<Item> fetchItems(String itemType, String subCat){
		Session session = HbUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Item> lstItem = session.createQuery("from Item i where i.category=:p_category and i.type = :p_type")
					.setParameter("p_category", subCat)
					.setParameter("p_type", itemType)
					.list();
		
		return lstItem;
	}
	
	/***
	 * Description : Fetch Item of given Id
	 * @param itemId
	 * @return
	 */
	public Item fetchItem(int itemId) {
		Session session = HbUtil.getSession();
		return session.get(Item.class, itemId);
	}
	
	/***
	 * Description : Fetch ItemPrice of given Id
	 * @param itemId
	 * @return
	 */
	public ItemPrice fetchItemPrice(int itemId) {
		Session session = HbUtil.getSession();
		@SuppressWarnings("unchecked")
		List<ItemPrice> lstItemPrice = session.createQuery("from ItemPrice ip where ip.itemId=:p_itemId")
					.setParameter("p_itemId", itemId)
					.list();
		
		if(lstItemPrice.size() > 0)
			return lstItemPrice.get(0);
		else
			return null;
	}
}
