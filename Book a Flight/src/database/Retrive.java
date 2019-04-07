package database;
import java.sql.*;
import java.util.ArrayList;

public class Retrive 
{
	private static Connection con = null;
	private static Statement state = null;
	private static ResultSet set = null;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String database = "test";
	private static String user = "mysql";
	private static String password = "sorry";
	
	private static String sql = null;
	
	public static void bookFlight(String ID, String traveller, String tickets)
	{
		@SuppressWarnings("unused")
		int sta = 0;
		int ticketsres = Integer.parseInt(tickets) - Integer.parseInt(traveller);
		sql = "update flight set tickets="+ticketsres+" where ID="+Integer.parseInt(ID)+";";
		try 
		{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url+database, user, password);
			state = con.createStatement();
			sta = state.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> retriveFlightData(String origins, String destinations, String departingdates, String returndates) 
	{
		ArrayList<Integer>ID = new ArrayList<Integer>();
		ArrayList<String>origin = new ArrayList<String>();
		ArrayList<String>destination = new ArrayList<String>();
		ArrayList<String>departingdate = new ArrayList<String>();
		
		ArrayList<Boolean>returns = new ArrayList<Boolean>();
		ArrayList<String>returndate = new ArrayList<String>();
		ArrayList<Integer>tickets = new ArrayList<Integer>();
		ArrayList<Double>price = new ArrayList<Double>();
		
		//depart and return date filled
		if( (!returndates.equals("yyyy-mm-dd") || !returndates.equals("")) && (!departingdates.equals("yyyy-mm-dd") || !departingdates.equals("")) )
			sql = "select ID, origin, destination, departingdate, returns, returndate, tickets, price from flight where origin='"+origins+"' and destination='"+
			destinations+"' and depdate='"+departingdates+"' and retdate='"+returndates+"';";
		
		//depart filled, return empty
		if( (returndates.equals("yyyy-mm-dd") || returndates.equals("")) && (!departingdates.equals("yyyy-mm-dd") || !departingdates.equals("")) ) 
			sql = "select ID, origin, destination, departingdate, returns, returndate, tickets, price from flight where origin='"+origins+"' and destination='"+
			destinations+"' and depdate='"+departingdates+"';";
		
		//depart empty, return filled
		if( (!returndates.equals("yyyy-mm-dd") || !returndates.equals("")) && (departingdates.equals("yyyy-mm-dd") || departingdates.equals("")) )
			sql = "select ID, origin, destination, departingdate, returns, returndate, tickets, price from flight where origin='"+origins+"' and destination='"+
			destinations+"' and retdate='"+returndates+"';";
		
		//depart and return empty
		if( (returndates.equals("yyyy-mm-dd") || returndates.equals("")) && (departingdates.equals("yyyy-mm-dd") || departingdates.equals("")) )
			sql = "select ID, origin, destination, departingdate, returns, returndate, tickets, price from flight where origin='"+origins+"' and destination='"+
			destinations+"';";
		try 
		{
			
			Class.forName(driver);
			con = DriverManager.getConnection(url+database, user, password);
			state = con.createStatement();
			set = state.executeQuery(sql);
			
			while(set.next())
			{
				ID.add(set.getInt(1));
				origin.add(set.getString(2));
				destination.add(set.getString(3));
				departingdate.add(set.getString(4));
				
				returns.add(set.getBoolean(5));
				returndate.add(set.getString(6));
				tickets.add(set.getInt(7));
				price.add(set.getDouble(8));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<ArrayList>list = new ArrayList<ArrayList>();
		list.add(ID);
		list.add(origin);
		list.add(destination);
		list.add(departingdate);
		list.add(returns);
		list.add(returndate);
		list.add(tickets);
		list.add(price);
		
		return list;
	}

}
