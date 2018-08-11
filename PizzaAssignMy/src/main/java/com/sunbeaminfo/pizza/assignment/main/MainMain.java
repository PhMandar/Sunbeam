package com.sunbeaminfo.pizza.assignment.main;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.sunbeaminfo.pizza.assignment.daos.LoginDao;
import com.sunbeaminfo.pizza.assignment.daos.MenuDao;
import com.sunbeaminfo.pizza.assignment.daos.OrderDao;
import com.sunbeaminfo.pizza.assignment.entities.Customer;
import com.sunbeaminfo.pizza.assignment.entities.Item;
import com.sunbeaminfo.pizza.assignment.entities.ItemPrice;
import com.sunbeaminfo.pizza.assignment.entities.Order;
import com.sunbeaminfo.pizza.assignment.util.HbUtil;

public class MainMain {

	public static void main(String[] args) {
		try {
			HbUtil.beginTransaction();
			MenuDao menuDao = new MenuDao();
			OrderDao orderDao = new OrderDao();
			LoginDao loginDao = new LoginDao();
			
			// 1. Print items and there prices:
			// getItemAndItemPrices(menuDao); 
			
			// 2. Insert Customer and there orders
			// insertCustomerAlongWithOrders(loginDao);
			
			// 3. Fetch order and related customer
			// fetchOrderAndAssociatedCuster(orderDao);
			
			// 4. Insert given order along with order details.
			// insertOrderAndOrderDetails(orderDao, menuDao);
			
			fetchOrdersByStatus(orderDao);
			
			// 5. Find all available types
			// getTypes(menuDao);
			// getSubCategories(menuDao);
			// getItemPriceById(menuDao);
			// getItemsByTypeAndCategory(menuDao);
			
			
			HbUtil.commitTransaction();	
		} catch( Exception ex ) {
			ex.printStackTrace();
			HbUtil.rollbackTransaction();
		} finally {
			HbUtil.shutdown();
		}
	}
	
	private static void fetchOrdersByStatus(OrderDao orderDao) {
		List<Order> lstOrders = orderDao.fetchOrdersByStatus("Pending");
		lstOrders.stream().forEach(System.out::println);
		
	}

	private static void getItemsByTypeAndCategory(MenuDao menuDao) {
		menuDao.fetchItems("Veg", "Veg Treat").stream().forEach(System.out::println);
	}

	private static void getItemPriceById(MenuDao menuDao) {
		System.out.println(menuDao.fetchItemPrice(2));
	}

	private static void getSubCategories(MenuDao menuDao) {
		System.out.println("\n ******************************************");
		System.out.println("\n Sub categories ");
		List<String> lstTypes = menuDao.fetchSubCategories();
		lstTypes.stream().forEach(System.out :: println);
		System.out.println("\n ******************************************");
	}

	private static void getTypes(MenuDao menuDao) {
		System.out.println("\n ******************************************");
		System.out.println("\n Types ");
		List<String> lstTypes = menuDao.fetchTypes();
		lstTypes.stream().forEach(System.out :: println);
		System.out.println("\n ******************************************");
	}

	private static void insertOrderAndOrderDetails(OrderDao orderDao, MenuDao menuDao) {
		System.out.println("\n ******************************************");
		Order order = orderDao.fetchOrder(1);
		ItemPrice price = menuDao.fetchItemPrice(1);
		
		System.out.println("Order found : \n ******************************************\n" + order + "\n ******************************************" );
		System.out.println("Price found : \n ******************************************\n" + price + "\n ******************************************" );
		
		orderDao.insertOrderAndOrderDetails(order, price);
		
		System.out.println("Order details added successfully");
		System.out.println("\n ******************************************");
	}

	private static void fetchOrderAndAssociatedCuster(OrderDao orderDao) {
		System.out.println("\n ******************************************");
		Order order = orderDao.fetchOrder(1);
		System.out.println("Order with id " + 1 + " is as : \n" + order);
		System.out.println("Customer found with orderId = \n" + orderDao.fetchCustomer(order.getCust().getId()));
		System.out.println("\n ******************************************");
	}

	private static void insertCustomerAlongWithOrders(LoginDao loginDao) {
		System.out.println("Inserting customer and his order ");
		Customer cust = new Customer(5, "advait", "advait", "9850310562", "Keshav Nagar, Pune", "advait@foodpanda.com");
		System.out.println("Customer created as " + cust);
		Order ord1 = new Order(1, cust, new Date(), "Pending");
		Order ord2 = new Order(2, cust, new Date(), "Ordered");
		Order ord3 = new Order(3, cust, new Date(), "Dispatched");
		System.out.println("Orders are created");
		cust.getOrderList().addAll(Arrays.asList(ord1, ord2, ord3));
		loginDao.insertCustomer(cust);
		
		// Following is working only to fetch the customer -- not working for order list
		Customer custByEmail = loginDao.getCustomerByEmail("advait@foodpanda.com");
		System.out.println("Fetched Customer = " + custByEmail);
		System.out.println("Size of order list = " + custByEmail.getOrderList().size());
		for (Order order : custByEmail.getOrderList()) {
			System.out.println(order);
		}
	}

	// Print items and there prices:
	private static void getItemAndItemPrices(MenuDao menuDao) {
		System.out.println("\n ******************************************");
		int itemId = 1;
		
		System.out.println("\n Finding item with item id " + itemId);
		Item item = menuDao.fetchItem(itemId);
		System.out.println("Item found is : -- \n" + item);
		
		System.out.println("Item prices are : ");
		for (ItemPrice itemPrice : item.getPriceList()) {
			System.out.println(itemPrice);
		}
		System.out.println("\n ******************************************");
	}
}


/*
 * Pizza Assignment:
	class Item {
		// ...
		@OneToMany(mappedBy="item")
		private List<ItemPrice> priceList;
	}
	
	class ItemPrice {
		// ...
		@ManyToOne
		@JoinColumn(name="ITEMID")
		private Item item;
	}		
		
	class Customer {
		// ...
		@OneToMany(mappedBy="customer")
		private List<Order> orderList;
	}
	
	class Order {
		// ...
		@ManyToOne
		@JoinColumn(name="CUSTOMERID")
		private Customer customer;
		
		@OneToMany(mappedBy="order")
		private List<OrderDetail> detailList;
	}	
	
	class OrderDetail {
		// ...
		@ManyToOne
		@JoinColumn(name="ORDERID")
		private Order order;
		
		@ManyToOne
		@JoinColumn(name="PRICEID")
		private ItemPrice itemPrice;
	}
 * 
 * */
