package com.pratik.test;

import com.pratik.dao.MTO_DAO;
import com.pratik.dao.MTO_DAOFactory;
import com.pratik.utility.HibernateUtil;

public class MTO_Test_LoadData {
	public static void main(String[] args) {
		MTO_DAO dao=null;
		//get DAO
		dao=MTO_DAOFactory.getInstance();
		//save objs
		dao.loadDataUsingParent();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

/*
 Hibernate: 
    select
        employee0_.EID as EID1_1_,
        employee0_.ENAME as ENAME2_1_,
        employee0_.ESAL as ESAL3_1_,
        employee0_.deptId as deptId4_1_ 
    from
        Employee_MTO employee0_
Hibernate: 
    select
        department0_.DEPTID as DEPTID1_0_0_,
        department0_.DEPTNAME as DEPTNAME2_0_0_ 
    from
        DEPT_MTO department0_ 
    where
        department0_.DEPTID=?
Child---->Employee [eid=1, ename=Pratik, esal=50000.0, dept=Department [deptId=1003, deptName=Developer]]
Parent--->Department [deptId=1003, deptName=Developer]
Child---->Employee [eid=2, ename=Rohit, esal=60000.0, dept=Department [deptId=1003, deptName=Developer]]
Parent--->Department [deptId=1003, deptName=Developer]
Hibernate: 
    select
        department0_.DEPTID as DEPTID1_0_0_,
        department0_.DEPTNAME as DEPTNAME2_0_0_ 
    from
        DEPT_MTO department0_ 
    where
        department0_.DEPTID=?
Child---->Employee [eid=3, ename=Shubham, esal=30000.0, dept=Department [deptId=1004, deptName=Testing]]
Parent--->Department [deptId=1004, deptName=Testing]
Child---->Employee [eid=4, ename=Bipin, esal=20000.0, dept=Department [deptId=1004, deptName=Testing]]
Parent--->Department [deptId=1004, deptName=Testing]

*/