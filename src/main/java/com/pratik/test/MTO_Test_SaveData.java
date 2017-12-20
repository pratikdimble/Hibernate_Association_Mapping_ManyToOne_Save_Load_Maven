package com.pratik.test;

import com.pratik.dao.MTO_DAO;
import com.pratik.dao.MTO_DAOFactory;
import com.pratik.utility.HibernateUtil;

public class MTO_Test_SaveData {
	public static void main(String[] args) {
		MTO_DAO dao=null;
		//get DAO
		dao=MTO_DAOFactory.getInstance();
		//save objs
		dao.SaveDataUsingParents();

		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

/*
SQL> select * from Employee_MTO;

EID ENAME                 ESAL     DEPTID
---------- --------------- ---------- ----------
  1 Pratik               50000       1003
  2 Rohit                60000       1003
  3 Shubham              30000       1004
  4 Bipin                20000       1004

SQL> select * from dept_mto;

DEPTID DEPTNAME
---------- ---------------
1003 Developer
1004 Testing

SQL>
*/