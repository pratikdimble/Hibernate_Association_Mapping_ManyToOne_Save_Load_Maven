package com.pratik.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.Department;
import com.pratik.domain.Employee;
import com.pratik.utility.HibernateUtil;

public class MTO_DAOImpl implements MTO_DAO {
 
	@Override
	public void SaveDataUsingParents() {
		Session ses=null;
		Department dept=null;
		Employee emp1=null,emp2=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 dept=new Department();
		 dept.setDeptName("Management");
		//child objs
		 emp1=new Employee();
		 	emp1.setEname("Ganesh");
		 	emp1.setEsal(30000f);
		 emp2=new Employee();
		 	emp2.setEname("Sandip");
		 	emp2.setEsal(20000f);

		//set childs to parent
			emp1.setDept(dept);emp2.setDept(dept);

		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		  int idval1=(Integer) ses.save(emp1);
		  int idval2=(Integer) ses.save(emp2);
		 tx.commit();
		 System.out.println("Objects are saved...."+idval1);
		 System.out.println("Objects are saved...."+idval2);
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}//method

	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<Department> list=null;
		List<Employee> emplist=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from Employee");
		//execute Query
		emplist=query.list();
		//process the Results
		for(Employee emp:emplist){
			System.out.println("Child---->"+emp);
			//get all childs of each parent
				Department dept=emp.getDept();
				System.out.println("Parent--->"+dept);
			/*for(PhoneNumber ph:childs){
				
			}//for
		*/
			}//for
	}//method
	
	
	@Override
	public void addingNewChildToExistingParent() {
		Session ses=null;
		Department dept=null;
		Employee emp=null;
		Transaction tx=null;
		//PhoneNumber ph3=null;
	   //get Session
		ses=HibernateUtil.getSession();
		//Load parent object(Existing)
		dept=ses.get(Department.class,1001);
		//child objs
		 	emp=new Employee();
		 	emp.setEname("Amit");
		 	emp.setEsal(60000f);
		 	//set to existing dept
		 emp.setDept(dept);

		try{
			tx=ses.beginTransaction();
			 int idval=(Integer)ses.save(emp);
			tx.commit();
			System.out.println("new Employee is added to existing Department: "+idval);
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	

	
}//class
