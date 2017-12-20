package com.pratik.dao;

public class MTO_DAOFactory {
	
	public static MTO_DAO getInstance(){
		return new MTO_DAOImpl();
	}

}
