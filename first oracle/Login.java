import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Login extends JFrame implements ActionListener
{ 
JLabel l1,l2;
JTextField t1,t2,t3,t4;
JButton b1,b2;
JLabel l=new JLabel();
 
Login()
{
setTitle("Login Form For Health Officer");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(1500,1500);
l1=new JLabel("Username");
l2=new JLabel("Password");
t1=new JTextField();
t2=new JPasswordField();
t3=new JTextField();
t4=new JTextField();
b1=new JButton("Login");
b2=new JButton("Register");
setLayout(null);
l1.setBounds(40,70,150,20);
t1.setBounds(120,70,200,20);

l2.setBounds(40,120,150,20);
t2.setBounds(120,120,200,20);

t3.setBounds(180,220,100,20);
t3.setBounds(180,320,100,20);
b1.setBounds(40,170,150,20);
b2.setBounds(200,170,150,20);

l.setBounds(400,170,300,20);
add(l1);add(t1);
add(l2);add(t2);
add(b1);add(t3);
add(b2);
add(l);
b1.addActionListener(this);
b2.addActionListener(this);
t3.setEditable(false);  
setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
	try{
	if (e.getSource() == b1)  
	{
	int a=0;
	String s1=t1.getText();
	String s2=t2.getText();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	a++;
	Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DB","123");
        Statement st= c.createStatement();
	ResultSet rs=  st.executeQuery("select id,password from login where id='"+s1+"' and password='"+s2+"'");
	if (rs.next())
{
System.out.println(rs.getString(1)+" "+rs.getString(2));
}
	if(a!=0)
	{
	System.out.println("Login Successful");
	l.setText("Login Successful");
	}
	else
	{
	l.setText("Login Failed");
	}
	}
    }catch(Exception er){}
}
public static void main(String args[])
{
new Login();
}
}