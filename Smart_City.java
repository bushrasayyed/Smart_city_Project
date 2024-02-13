
//Topic:SMART CITY PROJECT
//************************************
//Concepts Use:->Core Java , MYSQL and JDBC
//************************************
package Mini_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.*;

@FunctionalInterface
interface GreetUs  //Creating functional interface for Greeting
{
	String msg(String message);
}
class hotel_booking  //for booking and allotting room no.
{
	public void book()
	{ 
	    Random rn=new Random();
		 System.out.println("Your Room number is =>"+rn.nextInt(1,200));
		 System.out.println("Pay the bill while checking out.... \n Enjoy your day!!!");
		
	}
}
class Questions
{
	 public static final String RESET = "\033[0m";
	public static final String WHITE_BRIGHT = "\033[1;97m"; 
	public static final String CYAN_BRIGHT = "\033[1;96m";
	public static final String GREEN_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[1;93m";
    
    public void ask()
    {
    	
    	System.out.println(CYAN_BRIGHT+"Q1.What makes  Pune a Smart City?"+RESET);
    	System.out.println(WHITE_BRIGHT+"Ans->Education Hub:–Crowned with the title of being the "+GREEN_BRIGHT+" Oxford of the East,"
    			+ " the city has more than 9 deemed universities and 400 colleges "
    			+ "affiliated to the Pune University, offering courses across various streams."
    			+ " Almost 45% of foreign students who come to study in India choose Pune as their"
    			+ " education city."+RESET);
    	System.out.println(CYAN_BRIGHT+"Q2.What is Pune famous for?"+RESET);
    	System.out.println(YELLOW_BRIGHT+"Ans-> Pune exemplifies an indigenous Marathi culture and ethos,"
    			+ " in which education, arts and crafts, and theatres are given due prominence. "
    			+ "It is the birthplace of the poet-saint Tukaram (in Dehu) and Jnaneshvara (in Alandi),"
    			+ " the author of the well-known commentary 'Jnaneshwari',on the “Bhagavad Gita”."+RESET);
    	System.out.println(CYAN_BRIGHT+"Q3.What kind of city is Pune?"+RESET);
    	System.out.println(WHITE_BRIGHT+"Ans-> Pune is the second-largest city in the state of Maharashtra"
    			+ " after Mumbai, and is an important city in terms of its economic and industrial"
    			+ " growth. Once the centre of power for the Maratha Empire, "
    			+ "Pune's rich historical past has made it the cultural capital of Maharashtra."+RESET);
    	System.out.println(CYAN_BRIGHT+"Q4.What is the nickname of Pune?"+RESET);
    	System.out.println(GREEN_BRIGHT+"Ans->Queen of Deccan"
    			+ "Pune – Queen of Deccan or Oxford of the East"
    			+ "So, it was given the name of Queen of Deccan. "
    			+ "Pune is called as the Oxford of the East due to having the more number of"
    			+ " educational institutes and centers than any other place in India."+RESET);
    	System.out.println(CYAN_BRIGHT+"Q5.Why is Pune so awesome?"+RESET);
    	System.out.println(WHITE_BRIGHT+"Ans->Pune is a unique city. "
    			+ "It has a rich cultural heritage that is rooted in traditional Maharashtrian culture "
    			+ "while having a cosmopolitan edge fuelled by its thriving IT industry. "
    			+ "Life In Pune, India is touted to be one of the best ones in the country with "
    			+ "its great people, weather, and reasonable cost of living."+RESET);
    	
    }
}
public class Smart_City {
	  public static final String ANSI_RESET = "\u001B[0m";
	  public static final String RED = "\033[1;91m";     // RED
	  public static final String GREEN = "\033[1;32m";   // GREEN
	  public static final String YELLOW = "\033[1;33m";  // YELLOW
	  public static final String BLUE = "\033[1;94m";    // BLUE
	  public static final String PURPLE = "\033[1;96m";  // PURPLE
	  public static final String CYAN = "\033[1;36m";    // CYAN

	public static void main(String[] args) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");//Loading the Driver
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bushra","root","Bushra@2001");
			Statement stmt=con.createStatement();
		    int s;
		Scanner sc=new Scanner(System.in);
		GreetUs ni=(message)->(message);  //Lambda function for Greeting
		System.out.println(ni.msg(PURPLE+"\t\t\t-----WELCOME TO PUNE CITY-----\n"+ANSI_RESET));
		System.out.println(GREEN+"\t\t Pune-"+BLUE+"The City With An Attitude.\n"+ANSI_RESET);
		do 
		{
		System.out.println(RED+"\t*** PICK A SERVICE ***\n"+YELLOW+" 1.Hotel Bookings \n\n 2.Tourist Places\n\n 3.Shopping Spots \n\n 4.FAQ \n\n 5.Exit"+ANSI_RESET);
		 s=sc.nextInt();
		
			switch(s)
			{
			case 1:
				System.out.println(PURPLE+"\t\tBelow is the list of Best Hotels in Pune"+ANSI_RESET);
				ResultSet rs1=stmt.executeQuery("select * from Hotels");
				System.out.println(YELLOW+"H_Id | Name                       |Area              | Price/day       |Contact "+ANSI_RESET);
				while(rs1.next())
				   {
					   System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+"              | "+rs1.getString(3)+"           | "+rs1.getString(4)+ "         |"+rs1.getString(5));
				   }
				System.out.println(RED+"Enter Hotel_id of the Hotel  you want to book-"+ANSI_RESET);
				int hid=sc.nextInt();
				System.out.println(GREEN+"\t\t--Hotel Details--"+ANSI_RESET);
				ResultSet rs2=stmt.executeQuery("select * from hotels where hotel_id="+hid+";");
				while(rs2.next())
				   {
					   System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+"     | "+rs2.getString(3)+"       | "+rs2.getString(4)+ " |     "+rs2.getString(5));
				   }
				
				hotel_booking hb=new hotel_booking();
				hb.book();
				break;
			case 2: 
				System.out.println(PURPLE+"\t\tBelow is the list of Best Tourist Places in Pune"+ANSI_RESET);
				ResultSet rs3=stmt.executeQuery("select * from visit");
				System.out.println(YELLOW+"v_id| Place_name              |Location"+ANSI_RESET);
				while(rs3.next())
				   {
					   System.out.println(rs3.getString(1)+"   | "+rs3.getString(2)+"           | "+rs3.getString(3));
				   }
				System.out.println(GREEN+"Help Us by listing new Tourist Place.\n"+CYAN+"Yes(1)|No(0)"+ANSI_RESET);
				int ans=sc.nextInt();
				if(ans==1)
				{
					System.out.println(YELLOW+"Enter v_id"+ANSI_RESET);
					int id=sc.nextInt();
					System.out.println(YELLOW+"Enter place Name"+ANSI_RESET);
					String nm=sc.next();
					System.out.println(YELLOW+"Enter Location"+ANSI_RESET);
					String loc=sc.next();
					stmt.executeUpdate("insert into visit values("+id+",'"+nm+"','"+loc+"');");
					System.out.println(BLUE+"Inserted!!!\nThanks For your Listing"+ANSI_RESET);
					
				}
				else
				{
					System.out.println(CYAN+"\t\tEnjoy Your Day!!!"+ANSI_RESET);
				}
				
				break;
			case 3:
				System.out.println(PURPLE+"\t\tBelow is the list of Best Shopping Spots in Pune\n"+GREEN+"\t\t Discover the best for you!!!"+ANSI_RESET);
				ResultSet rs4=stmt.executeQuery("select * from shopping");
				System.out.println(YELLOW+"Sno| Market_Name           | Renowned_for                   |  Area"+ANSI_RESET);
				while(rs4.next())
				   {
					   System.out.println(rs4.getString(1)+"  | "+rs4.getString(2)+"        | "+rs4.getString(3)+"                       | "+rs4.getString(4));
				   } 
				System.out.println(BLUE+"Would You Like to Help Us  Improve  Our data ?\n "+CYAN+"If Yes Enter 1"+ANSI_RESET);
				int ans4=sc.nextInt();
				if(ans4==1)
				{
					System.out.println(YELLOW+"Enter Srno where you have to do Updation"+ANSI_RESET);
					int sno=sc.nextInt();
					System.out.println(GREEN+"Which field you have to update->\n1.Market_Name\n2.Renowned_for"+ANSI_RESET);
					int key=sc.nextInt();
					if(key==1)
					{
						System.out.println(YELLOW+"Enter Updated Market Place Name:-"+ANSI_RESET);
						String mpn=sc.next();
						stmt.executeUpdate("update shopping set Market_Name='"+mpn+"' where Srno="+sno+";");
						System.out.println(GREEN+"Updated !!! Thank you "+ANSI_RESET);
						
					}
					else if(key==2)
					{
						System.out.print(YELLOW+"Enter Renowed information:-"+ANSI_RESET);
						String rni=sc.next();
						stmt.executeUpdate("update shopping set Renowned_for='"+rni+"' where Srno="+sno+";");
						System.out.println(GREEN+"Updated !!! Thank you "+ANSI_RESET);
					}
					
					
				}
				else
				{
					System.out.println(CYAN+"\t\tEnjoy Your Day!!!"+ANSI_RESET);
				}
				
				break;
			case 4:
				System.out.println(GREEN+"\t\t---We Have got some Frequently Asked Questions here---"+ANSI_RESET);
				 Questions qq=new  Questions();
				 qq.ask();
				 System.out.println(CYAN+"Thanks for Visiting here\n"+GREEN+"\t\tPUNE-Clean city,Green City,Dream City!!!"+ANSI_RESET);
				
				 break;
			case 5:
				System.out.println(CYAN+"Thanks for Visiting here\n"+GREEN+"\t\tPUNE-Clean city,Green City,Dream City!!!"+ANSI_RESET);
				System.exit(0);
			}
		
		}
		while(s!=8);
		sc.close();
		}
       
		catch(Exception e)
		{
			 System.out.println(RED+"OOPS!!! Something went wrong\n Visit after sometime\n"+e);
		}
	}

}
