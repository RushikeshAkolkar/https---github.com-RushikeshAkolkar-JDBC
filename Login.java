import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Login extends JFrame implements ActionListener
{

 
JLabel l1=new JLabel("Username");
JLabel l2=new JLabel("Password");
JTextField t1=new JTextField(20);
JPasswordField t2=new JPasswordField(20);
JButton b=new JButton("Login");
JLabel l=new JLabel();

 
Login()
{
setSize(300,300);



setLayout(new FlowLayout());

add(l1);add(t1);
add(l2);add(t2);
add(b);
add(l);
b.addActionListener(this);
setVisible(true);

}
public void actionPerformed(ActionEvent e)
{
String a=t1.getText();
String b=t2.getText();

try{  
String cs = "jdbc:mysql://localhost:3307/DB"; 
Connection con=DriverManager.getConnection(cs,"root","12345");
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from login");  
while(rs.next())  
{
String r1=rs.getString(2);
String r2=rs.getString(3);
if(r1.equals(a) & r2.equals(b))
{
l.setText("Login successful");
}
}
}catch(Exception ex){ System.out.println(ex.toString());} 
}  
public static void main(String args[])
{

Login f=new Login();
  
}
}