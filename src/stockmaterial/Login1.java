package stockmaterial;


import java.awt.*;


import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Login1 extends JFrame implements ActionListener
 {
  JLabel l1,l2,l3;
  JTextField t1;
  JPasswordField t2;
  JButton b1,b2,b3,btn3;
  Container c;
 public Login1()
 {
c=getContentPane();
c.setBackground(Color.orange);

c.setLayout(null);

l3=new JLabel("LOGIN FORM");
l1=new JLabel("EMAIL ID");
l2=new JLabel("PASSWORD ");
b1=new JButton("LOGIN");
b2=new JButton("EXIT");
t1=new JTextField(15);
t1.setToolTipText("Enter your email id");
t2=new JPasswordField(15);
t2.setToolTipText("Enter Password");
l1.setBounds(130,40,200,30);
l1.setFont(new Font("Serif", Font.BOLD, 22));
l3.setBounds(200,2,200,30);
l3.setForeground(Color.black);
l3.setFont(new Font("Serif", Font.BOLD, 22));
l2.setFont(new Font("Serif", Font.BOLD, 22));
l1.setForeground(Color.red);
l2.setForeground(Color.red);
l2.setBounds(130,80,200,30);
b1.setBounds(170,160,120,30);
b1.setForeground(Color.red);
b1.setFont(new Font("Serif", Font.BOLD, 15));
b1.setBackground(Color.black);
b2.setForeground(Color.red);
b2.setFont(new Font("Serif", Font.BOLD, 15));
b2.setBackground(Color.black);
b2.setBounds(350,160,120,30);
t1.setBounds(300,40,100,30);
t1.setForeground(Color.blue);
t2.setForeground(Color.blue);
t2.setBounds(300,80,100,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3=new JButton("click here for new user");
b3.setBounds(200, 200, 200, 30);
b3.setBackground(Color.black);
b3.setForeground(Color.blue);
add(b3);
btn3=new JButton("BACK");
btn3.setBounds(10, 10, 70, 20);
btn3.setBackground(Color.black);
btn3.setForeground(Color.red);
add(btn3);
btn3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Login1.this.dispose();
		new Home();
	}
});
 c.add(l1);
 c.add(l2);
 c.add(t1);
 c.add(t2);
 c.add(b1);
 c.add(b2);
 c.add(l3);
  setBounds(400,200,300,300);
setVisible(true);
setSize(550,280);
setTitle("STOCK MATERIAL");
b3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Login1.this.dispose();
		new registration();
	}
});
}

public void actionPerformed(ActionEvent ae)
{
	 String s1=t1.getText();
	  String s2=t2.getText();
		
if(ae.getSource()==b1)
{
try 
   {
   Connection con=ConnectionProvider.getCon();
	
	PreparedStatement ps=con.prepareStatement("select * from sonal where email=? and pass1=?");
	
	ps.setString(1,s1);
	
	
ps.setString(2,s2);

	
ResultSet rs=ps.executeQuery();	
boolean recordfound = rs.next();


 
 if((s1.equals("")) && (s2.equals("")))
  {
 JOptionPane.showMessageDialog(null,"Please Enter User Name/Password");
 return;
  }  
 
     if(recordfound)
     {
   	  this.dispose();
   	  new list1();

		
       
     }
     else
     {
      JOptionPane.showMessageDialog(null,"Invalid User Name/Password");
      t1.setText("");
      t2.setText("");

     }
   }catch(Exception e)   {}      

  }
   
 if(ae.getSource()==b2)
   {
     this.dispose();
   }	
  }   


 }


