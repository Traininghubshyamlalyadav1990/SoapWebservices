package jmrserveice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {        
	
	String result="";
	public String  getDetails(int empid)
	{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	 Connection con = null;
	try {
		con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","om");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 System.out.println("connected data base");
	    
	try
	{
	//stmt.execute("create table com (sno int,name varchar(90),age int)");
		System.out.println("connection is established");
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	try
	{
		
		
	PreparedStatement psmt=con.prepareStatement("select name from emp122 where id=id");
	//psmt.setInt(2,id);
	
	String query="select name from  emp120 where id='emid'";
	ResultSet rs=psmt.executeQuery();
	//String result="";
	while(rs.next())
	{
		
		result=rs.getString(1);
	}
	System.out.println(result);
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return "Not Record found";
	}
	
	
	return result;

}
	
	public ArrayList<String[]> getconnection(String id)throws ClassNotFoundException, SQLException
	{
				
		
		     System.out.println("collection jdbc");
			ArrayList ls=new ArrayList();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@192.168.1.92:1521:FCARB01","EODMS","eodms");
			 System.out.println("connected data base");
				Statement stmt=con.createStatement();
				String sql="select QRY_TEXT from EOD_QRY_EXEC_LOG where OPERATOR_ID	='"+id+"'";
				System.out.println("fetching value....");
				ResultSet rs=stmt.executeQuery(sql);
				
				System.out.println("resulsetmetadata");
				ResultSetMetaData rsmd=rs.getMetaData();
				int a=rsmd.getColumnCount();
				while(rs.next())
				{
					for(int i=1;i<=a;i++)
					{
						ls.add(rs.getString(i));
					}
				}
				
				return ls;
			
		}
	
	
	
	
	
	public static void main(String[] args) throws Exception, Exception {
		
		//Dao d=new Dao();
		//String r=d.getDetails(1);
		
		
		
		
		
		//ArrayList<String[]> a=new ArrayList();
		//a=d.getconnection(1);
		//int  d1=a.size();
		//System.out.println(a);
		//System.out.println(d1);
		//String b = null;
		//System.out.println("result");
		//for(int i=0;i<d1;i++)
		{
			
			//System.out.println(a.get(i));
			//b+=a.get(i);
		}
		//b=b;
		
	}
	
	
	
}
