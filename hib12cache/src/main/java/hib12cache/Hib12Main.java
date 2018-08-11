package hib12cache;

import java.util.List;

import org.hibernate.Session;

public class Hib12Main {

	public static void main(String[] args) {
		try{
			// firstLevelCacheWithGetAndLoad(session);
			
			// secondLevelCache : Without enabling property
			// secondLevelCacheWithoutSettingAttrInXML();
			
			// secondLevelCache : With enabling property
			// secondLevelCacheWithSettingAttrInXML();
			
			// Second level cache with enabling cache property but not enabling query cache
			secondLevelCacheWithPropertySetWithQueryCacheDisabled();
			
			// Second level cache with enabling cache property and enabling query cache
			// secondLevelCacheWithPropertySetWithQueryCacheEnabled();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			HbUtil.shutdown();
		}
	}

	/**
	 * Here transaction is getting closed at the time of catch, so two different hibernate queries getting fired :
	 * <property name="hibernate.cache.use_second_level_cache">true</property>
	 * <property name="hibernate.cache.use_query_cache">true</property>
	 * 
	 * Hibernate: select book0_.id as id1_0_, book0_.author as author2_0_, book0_.name as name3_0_, book0_.price as price4_0_, book0_.subject as subject5_0_ from Books book0_ where book0_.subject=?
	 */
	@SuppressWarnings("unchecked")
	private static void secondLevelCacheWithPropertySetWithQueryCacheEnabled() {
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						.setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						.setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Here transaction is getting closed at the time of catch, so two different hibernate queries getting fired :
	 * <property name="hibernate.cache.use_second_level_cache">true</property>
	 * <property name="hibernate.cache.use_query_cache">false</property>
	 * 
	 * Two queries are getting fired  
	 * Hibernate: select book0_.id as id1_0_, book0_.author as author2_0_, book0_.name as name3_0_, book0_.price as price4_0_, book0_.subject as subject5_0_ from Books book0_ where book0_.subject=?
	 * Hibernate: select book0_.id as id1_0_, book0_.author as author2_0_, book0_.name as name3_0_, book0_.price as price4_0_, book0_.subject as subject5_0_ from Books book0_ where book0_.subject=?
	 * 
	 * */
	@SuppressWarnings("unchecked")
	private static void secondLevelCacheWithPropertySetWithQueryCacheDisabled() {
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						// .setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						// .setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Here transaction is getting closed at the time of catch, so two different hibernate queries getting fired :
	 * <property name="hibernate.cache.use_second_level_cache">true</property> 
	 * 
	 * Hibernate: select book0_.id as id1_0_0_, book0_.author as author2_0_0_, book0_.name as name3_0_0_, book0_.price as price4_0_0_, book0_.subject as subject5_0_0_ from Books book0_ where book0_.id=?
	 */
	private static void secondLevelCacheWithSettingAttrInXML() {
		try(Session session = HbUtil.getSession()){
			Book b = session.get(Book.class, 11);
			System.out.println("Book details : \n" + b);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try(Session session = HbUtil.getSession()){
			Book b = session.get(Book.class, 11);
			System.out.println("Book details : \n" + b);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Here transaction is getting closed at the time of catch, so two different hibernate queries getting fired :
	 * <property name="hibernate.cache.use_second_level_cache">false</property> 
	 *  
	 * Hibernate: select book0_.id as id1_0_0_, book0_.author as author2_0_0_, book0_.name as name3_0_0_, book0_.price as price4_0_0_, book0_.subject as subject5_0_0_ from Books book0_ where book0_.id=?
	 * Hibernate: select book0_.id as id1_0_0_, book0_.author as author2_0_0_, book0_.name as name3_0_0_, book0_.price as price4_0_0_, book0_.subject as subject5_0_0_ from Books book0_ where book0_.id=?
	 */
	private static void secondLevelCacheWithoutSettingAttrInXML() {
		try(Session session = HbUtil.getSession()){
			Book b = session.get(Book.class, 11);
			System.out.println("Book details : \n" + b);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try(Session session = HbUtil.getSession()){
			Book b = session.get(Book.class, 11);
			System.out.println("Book details : \n" + b);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Difference between get() and load() : See the class which is getting used :
	 * in case of load the proxy pattern is getting used
	 * 
	 * For get() : Hibernate: select book0_.id as id1_0_0_, book0_.author as
	 * author2_0_0_, book0_.name as name3_0_0_, book0_.price as price4_0_0_,
	 * book0_.subject as subject5_0_0_ from Books book0_ where book0_.id=? Class
	 * which is getting used : hib12cache.Book
	 * 
	 * For load() : Hibernate: select book0_.id as id1_0_0_, book0_.author as
	 * author2_0_0_, book0_.name as name3_0_0_, book0_.price as price4_0_0_,
	 * book0_.subject as subject5_0_0_ from Books book0_ where book0_.id=? Class
	 * which is getting used : hib12cache.Book$HibernateProxy$m0dI9aaR
	 */
	private static void firstLevelCacheWithGetAndLoad(Session session) {
		session.beginTransaction();
		Book b = session.get(Book.class, 11);
		System.out.println("Book details : \n" + b);
		System.out.println("ID : " + b.getId());
		System.out.println("NAME : " + b.getName());
		System.out.println(b.getClass().getName());

		Book b1 = session.load(Book.class, 12);
		System.out.println("Book details : \n" + b1);
		System.out.println("ID : " + b1.getId());
		System.out.println("NAME : " + b1.getName());
		System.out.println(b1.getClass().getName());
	}
}