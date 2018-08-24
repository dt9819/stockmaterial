package stockmaterial;


	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
	 
	public class registration extends JFrame implements ActionListener 
	  { 
	    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	    JTextField tf1, tf2, tf5, tf6, tf7;
	    JButton btn1, btn2,btn3;
	    JPasswordField p1, p2;
	    Container c;
	    Pattern pattern;
		Matcher matcher;
		

		static final String email="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	   long s10;
	    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	    registration()
	     {c=getContentPane();
	        setVisible(true);
	        setSize(700, 700);
	        setLayout(null);
	       
	        c.setBackground(Color.MAGENTA);
	       
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Registration Form for Employee ");
	 
	        l1 = new JLabel("Registration Form for Employee");
	        l1.setForeground(Color.blue);
	        l1.setFont(new Font("Serif", Font.BOLD, 40));
	 
	        l2 = new JLabel("NAME:");
	        l2.setFont(new Font("Serif", Font.BOLD, 20));
	        l3 = new JLabel("Email-ID:");
	        l3.setFont(new Font("Serif", Font.BOLD, 20));
	        l4 = new JLabel("Create Passowrd:");
	        l4.setFont(new Font("Serif", Font.BOLD, 20));
	        l5 = new JLabel("Confirm Password:");
	        l5.setFont(new Font("Serif", Font.BOLD, 20));
	        l6 = new JLabel("Country:");
	        l6.setFont(new Font("Serif", Font.BOLD, 20));
	        l7 = new JLabel("State:");
	        l7.setFont(new Font("Serif", Font.BOLD, 20));
	        l8 = new JLabel("Phone No:");
	        l8.setFont(new Font("Serif", Font.BOLD, 20));
	        tf1 = new JTextField();
	        tf2 = new JTextField();
	        p1 = new JPasswordField();
	        p2 = new JPasswordField();
	        tf5 = new JTextField();
	        tf6 = new JTextField();
	        tf7 = new JTextField();
	 
	        btn1 = new JButton("Submit");
	        btn2 = new JButton("Clear");
	 
	        btn1.addActionListener(this);
	        btn2.addActionListener(this);
	 
	        l1.setBounds(460, 25, 600, 50);
	        l2.setBounds(450, 100, 200, 30);
	        l3.setBounds(450, 150, 200, 30);
	        l4.setBounds(450, 200, 200, 30);
	        l5.setBounds(450, 250, 200, 30);
	        l6.setBounds(450, 300, 200, 30);
	        l7.setBounds(450, 350, 200, 30);
	        l8.setBounds(450, 400, 200, 30);
	        tf1.setBounds(720, 100, 300, 30);
	        tf1.setToolTipText("ENTER YOUR NAME");
	        tf1.setForeground(Color.red);
	        tf1.setFont(new Font("Serif", Font.BOLD, 20));
	        tf2.setBounds(720, 150, 300, 30);
	        tf2.setForeground(Color.red);
	        tf1.setFont(new Font("Serif", Font.BOLD, 20));
	        tf2.setToolTipText("ENTER YOUR EMAIL ID");
	        p1.setBounds(720, 200, 300, 30);
	        tf2.setFont(new Font("Serif", Font.BOLD, 20));
	        p1.setForeground(Color.red);
	        p1.setToolTipText("ENTER YOUR PASSWORD");
	        p2.setBounds(720, 250, 300, 30);
	        p1.setFont(new Font("Serif", Font.BOLD, 20));
	        p2.setForeground(Color.red);
	        p2.setToolTipText("ENTER YOUR PASSWORD");
	        tf5.setBounds(720, 300, 300, 30);
	        p2.setFont(new Font("Serif", Font.BOLD, 20));
	        tf5.setForeground(Color.red);
	        tf5.setToolTipText("ENTER YOUR COUNTRY");
	        tf6.setBounds(720, 350, 300, 30);
	        tf5.setFont(new Font("Serif", Font.BOLD, 20));
	        tf6.setForeground(Color.red);
	        tf6.setToolTipText("ENTER YOUR STATE");
	        tf6.setFont(new Font("Serif", Font.BOLD, 20));
	        tf7.setBounds(720, 400, 300, 30);
	        tf7.setForeground(Color.red);
	        tf7.setFont(new Font("Serif", Font.BOLD, 20));
	        tf7.setToolTipText("ENTER YOUR PHONE NUMBER");
	        btn1.setBounds(550, 480, 100, 30);
	        btn1.setBackground(Color.black);
	        btn1.setForeground(Color.red);
	        btn2.setBounds(800, 480, 100, 30);
	        btn2.setBackground(Color.black);
	        btn2.setForeground(Color.red);
	        btn3=new JButton("BACK");
	        btn3.setBounds(10, 10, 100, 30);
	        btn3.setBackground(Color.black);
	        btn3.setForeground(Color.red);
	 add(btn3);
	        add(l1);
	        add(l2);
	        add(tf1);
	        add(l3);
	        add(tf2);
	        add(l4);
	        add(p1);
	        add(l5);
	        add(p2);
	        add(l6);
	        add(tf5);
	        add(l7);
	        add(tf6);
	        add(l8);
	        add(tf7);
	        add(btn1);
	        add(btn2);
	        
	        setExtendedState(JFrame.MAXIMIZED_BOTH);
	        btn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					registration.this.dispose();
					new Home();
				}
			});
	    }
	 
	    public void actionPerformed(ActionEvent e) 
	     {
	        if (e.getSource() == btn1)
	         {
	        	boolean b=valid();
	        	
	       if(b)
	       	{
	    	   if(validt())
	    	   {
	            int x = 0;
	             s1 = tf1.getText();
	            s2 = tf2.getText();
	 
	             s3 = p1.getText();
	            s4 = p2.getText();
	             s8 = new String(s3);
	             s9 = new String(s4);
	 
	             s5 = tf5.getText();
	             s6 = tf6.getText();
	             s7 = tf7.getText();
	            
	            if (s8.equals(s9))
	           {
	                try
	               {
	                	Connection con=ConnectionProvider.getCon();
	                	/*PreparedStatement ps1=con.prepareStatement("CREATE TABLE sonal(NAME VARCHAR(20),email VARCHAR(40),pass1 VARCHAR(20),pass2 VARCHAR(20),country VARCHAR(20),state VARCHAR(20),phone varchar(10))");
ps1.executeUpdate();*/
	  		PreparedStatement ps=con.prepareStatement("insert into sonal values(?,?,?,?,?,?,?)");
	        ps.setString(1, s1);
	        ps.setString(2, s2);
	        ps.setString(3, s3);
	        ps.setString(4, s4);
	        ps.setString(5, s5);
	        ps.setString(6, s6);
	        ps.setString(7, s7);
                 ps.executeUpdate();     	          
	                    x++;
	                    if (x > 0) 
	                    {
	                    	
	                    	int x1=JOptionPane.showConfirmDialog(this,"WANT TO LOGIN NOW"," REGISTERED SUCESSFULLY" , JOptionPane.YES_NO_OPTION);		
	            			if(x1==JOptionPane.YES_OPTION)
	            				new Login1();
	            			setVisible(false);
	            			if(x1==JOptionPane.NO_OPTION)
	            				System.exit(0);
	                    }

	               }
	          catch (Exception ex) 
	                {
	                    System.out.println(ex);
	                }
	            }
	          else
	           {
	                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
	            } 
	        	}
	       
	        } 
	         }
	          else
	       {
	            tf1.setText("");
	            tf2.setText("");
	            p1.setText("");
	            p2.setText("");
	            tf5.setText("");
	            tf6.setText("");
	            tf7.setText("");
	        }
	    }

		public boolean valid() {
			
			if(tf1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(tf1,"Please write your name");	
			return false;
			}
			else if(tf2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your email id");	
			return false;
			}
			else if(!isValidEmail())
			{
				JOptionPane.showMessageDialog(null,"Please write your email id correctly","Error",JOptionPane.ERROR_MESSAGE);	
			return false;
			}
			else if(p1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your password");	
			
				
				return false;
			}
			else if(p2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your confirm password");	
			return false;
			}
			else if(tf5.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your country");	
			return false;
			}
			else if(tf6.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your state");	
			return false;
			}
			else if(tf7.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please write your phone number");	
			return false;
			}
			else if((tf7.getText().length())!=10)
			{
				JOptionPane.showMessageDialog(null,"write only your 10 digit number");	
			return false;
			}
			else 
			{
				return true;
			}
		} 

private boolean isValidEmail() {
	pattern=Pattern.compile(email);
	matcher=pattern.matcher(tf2.getText().toString());
	return matcher.matches();
}
private boolean validt()
{
	try{
    	ArrayList<Long> ar=new ArrayList();
    	s10=Long.parseLong(tf7.getText());
    	
    	return true;
    }
    catch(Exception e1)
    {
    	JOptionPane.showMessageDialog(tf7, "Please write correct number");
        return false;
    }
	
}

	}

	
	
	

