package jmrserveice;

import java.sql.SQLException;
import java.util.ArrayList;

public class CalSerice {
	
	String resp="";
	public String hello(String msg)
	{
		System.out.println("reponse is "+msg);
		return msg;
	}
	public String getID(String id)
	{
		  String emp=id;
		 Dao s=new Dao();
		
		
		ArrayList<String[]> a=new ArrayList();
		try {
			a=s.getconnection(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		int  d1=a.size();
		
		System.out.println("result");
		for(int i=0;i<d1;i++)
		{
			
			
			resp=a.get(i) +",";
			
			System.out.println( "respose od db is:" +a.get(i));
		}
		
		
		
		
		return resp;
	}
	
	
	

}
