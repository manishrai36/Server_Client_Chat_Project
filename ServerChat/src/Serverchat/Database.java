package Serverchat;
import java.sql.*;
//import java.io.*;

public class Database {

	public static void main(String[] args) throws Exception
	{
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Manish11");
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from student"); 
		
		while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2));  
		st.close();
		con.close();
	}
	catch(Exception e){ System.out.println(e);}  
	  
	
	
	}

}
