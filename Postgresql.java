import java.sql.*;  
class Postgresql{  
public static void main(String args[])
{  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/DB","root","12345");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from login");  
while(rs.next()) {
System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));  
}
con.close();  
}catch(Exception e){ System.out.println(e);}
}
}