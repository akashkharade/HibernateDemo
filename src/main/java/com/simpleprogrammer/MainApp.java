package com.simpleprogrammer;

import org.hibernate.Session;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtilities.getSessionFactory().openSession();
	    session.beginTransaction();

//	    // Check database version
//	    String sql = "select version()";
//
//	    String result = (String) session.createNativeQuery(sql).getSingleResult();
//	    System.out.println(result);
	    
	    Employee emp=new Employee();
	    emp.setEmpName("Akash");
	    emp.setEmpMobileNos("9404556860");
	    emp.setEmpAddress("Pen");
	    session.save(emp);
	    

	    session.getTransaction().commit();
	    System.out.println("inserted....");
	    session.close();

	    
	    
	    HibernateUtilities.shutdown();

	}

}
