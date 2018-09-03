package com.simpleprogrammer;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

public class GetAllData {

	public static void main(String[] args) {
		Session session = HibernateUtilities.getSessionFactory().openSession();
	    session.beginTransaction();

//	    // Check database version
//	    String sql = "select version()";
//
//	    String result = (String) session.createNativeQuery(sql).getSingleResult();
//	    System.out.println(result);
	    
	    CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();

		for (Employee employee : employeeList) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getEmpName());
		}  
		
	    

	    session.getTransaction().commit();
	    System.out.println("printed....");
	    session.close();

	    
	    
	    HibernateUtilities.shutdown();

	}

}
