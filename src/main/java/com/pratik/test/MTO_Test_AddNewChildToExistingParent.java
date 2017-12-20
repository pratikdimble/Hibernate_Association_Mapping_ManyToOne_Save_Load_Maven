package com.pratik.test;

import com.pratik.dao.MTO_DAO;
import com.pratik.dao.MTO_DAOFactory;
import com.pratik.utility.HibernateUtil;

public class MTO_Test_AddNewChildToExistingParent {
	public static void main(String[] args) {
		MTO_DAO dao=null;
		//get DAO
		dao=MTO_DAOFactory.getInstance();
		//save objs
		dao.addingNewChildToExistingParent();

		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
/*
  Hibernate: 
    select
        department0_.DEPTID as DEPTID1_0_0_,
        department0_.DEPTNAME as DEPTNAME2_0_0_ 
    from
        DEPT_MTO department0_ 
    where
        department0_.DEPTID=?
Hibernate: 
    select
        max(EID) 
    from
        Employee_MTO
Hibernate: 
    insert 
    into
        Employee_MTO
        (ENAME, ESAL, deptId, EID) 
    values
        (?, ?, ?, ?)
new Employee is added to existing Department: 7
 */
