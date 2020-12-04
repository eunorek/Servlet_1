package com.choa.util;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector dbc = new DBConnector();
		try {
			dbc.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
