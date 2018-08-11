package com.sunbeaminfo.pizza.assignment.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunbeaminfo.pizza.assignment.entities.Customer;
import com.sunbeaminfo.pizza.assignment.entities.ItemPrice;
import com.sunbeaminfo.pizza.assignment.entities.Order;
import com.sunbeaminfo.pizza.assignment.entities.OrderDetails;
import com.sunbeaminfo.pizza.assignment.util.HbUtil;

/***
 * Insert given order along with order details.
 * Fetch orders (in descending order of time) of given status i.e. Pending or Dispatched 
 * Fetch order of given id.
 */
public class OrderDao {

	/***
	 * Description : Insert given order along with order details.
	 * @param j 
	 * @param i 
	 * @return
	 */
	public boolean insertOrderAndOrderDetails(OrderDetails orderDetails) {
		Session session = HbUtil.getSession();
		session.merge(orderDetails);
		return true;
	}
	
	/***
	 * Description : Fetch orders (in descending order of time) of given status i.e. Pending or Dispatched
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> fetchOrdersByStatus(String status){
		List<Order> lstOrder;
		Session session = HbUtil.getSession();
		Query<Order> query = session.createQuery("from Order o where o.status=:p_Status");
		query.setParameter("p_Status", status);
		lstOrder = query.getResultList();
		return lstOrder;
	}
	
	/***
	 * Description : Fetch order of given id.
	 * @param id
	 * @return
	 */
	public Order fetchOrder(int id) {
		Session session = HbUtil.getSession();
		return session.get(Order.class, id);
	}

	public Customer fetchCustomer(int customerid) {
		Session session = HbUtil.getSession();
		return session.get(Customer.class, customerid);
	}

	public void insertOrderAndOrderDetails(Order order, ItemPrice price) {
		OrderDetails orderDetails = new OrderDetails(0, order, price);
		System.out.println("Inserting details of order along with its price == ");
		insertOrderAndOrderDetails(orderDetails);
	}
}