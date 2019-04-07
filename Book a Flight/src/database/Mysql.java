package database;

import java.sql.*;
import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Mysql 
{

	public static void main (String arguments[])
	{
		ZoneId zone = ZoneId.systemDefault();
		Clock time = Clock.tickMillis(zone);
		long begin = time.millis();
		
		Connection con = null;
		Statement state = null;
		
		String kota[] = {"jakarta", " surabaya", "medan", "bandung", "makassar", "semarang", "palembang", "batam", "pekanbaru", "malang", "bogor", "kuala lumpur", 
							"washington", "solo", "tokyo", "paris", "beijing", "shanghai", "delhi", "istanbul", "new york", "london"};
				
		int min;
		int max;
		int max2;
		int sta = 0;
		int randk1;
		int randk2;
		int bol;
		int tick;
		double pric;
		int z;
		LocalDate dep;
		LocalDate ret;
		int hour1;
		int minute1;
		int sec = 0;
		int hour2;
		int minute2;
		String setu;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "mysql", "sorry");
			state = con.createStatement();
			
			for(long x=0; x<30000; x++)
			{
				min = 0;
				max = kota.length;
				randk1 = ThreadLocalRandom.current().nextInt(min, max);
				randk2 = ThreadLocalRandom.current().nextInt(min, max);
				
				bol = ThreadLocalRandom.current().nextInt(0, 2);
				tick = ThreadLocalRandom.current().nextInt(0, 500);
				pric = ThreadLocalRandom.current().nextInt(100, 2000);
				
				max = 180;
				max2 = 30;
				z = ThreadLocalRandom.current().nextInt(min+1, max);			
				dep = LocalDate.now().plus(Period.ofDays(  new Random().nextInt(z) ) );
				
				if(bol==0) ret = null;
				else ret = dep.plus(Period.ofDays( new Random().nextInt(max2)+1));
				
				max = 24;
				max2 = 6;
				hour1 = new Random().nextInt(max);
				minute1 = new Random().nextInt(max2)*10;
				
				if(bol==1) 
				{
					ret = dep.plus(Period.ofDays( new Random().nextInt(max2)+1));
					hour2 = new Random().nextInt(max);
					minute2 = new Random().nextInt(max2*10);
					setu = ret+" "+hour2+":"+minute2+":"+sec;
				
					sta = state.executeUpdate("insert into flight(origin, destination, departingdate, returns, returndate, tickets, price, depdate, retdate)\r\n" + 
						"VALUES('"+kota[randk1]+"', '"+kota[randk2]+"', '"+dep+" "+hour1+":"+minute1+":"+"0"+"', "+bol+", '"+setu+"', "+tick+", "+pric+", '"+dep+"', '"+ret+"');");
				}
				
				else sta = state.executeUpdate("insert into flight(origin, destination, departingdate, returns, tickets, price, depdate)\r\n" + 
						"VALUES('"+kota[randk1]+"', '"+kota[randk2]+"', '"+dep+" "+hour1+":"+minute1+":"+"0"+"', "+bol+", "+tick+", "+pric+", '"+dep+"');");
				
			}
			System.out.println("done, return "+sta);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			long end = time.millis();
			System.out.println(end-begin);
		}
	}

}
