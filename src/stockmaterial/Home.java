package stockmaterial;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame 
{
	Container c;
	JButton b1,b2,b3;
	JLabel l1;
	
	Home()
	{   c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		b1=new JButton("REGISTRATION");
		b2=new JButton("LOGIN");
		b3=new JButton("SHOW RECORDS");
	    l1=new JLabel("WELCOME TO STOCK MANAGEMENT");
	    l1.setBounds(50,50,500,20);
	    l1.setFont(new Font("Serif",Font.BOLD, 25));
	    l1.setForeground(Color.red);
	   b1.setBounds(60,250,180,30);
	   b1.setFont(new Font("Serif",Font.BOLD , 15));
	   b1.setBackground(Color.BLACK);
	   b1.setForeground(Color.red);
	   b3.setBounds(180,350,170,30);
	   add(b3);
	   b3.setFont(new Font("Serif",Font.BOLD , 15));
	   b3.setBackground(Color.BLACK);
	   b3.setForeground(Color.red);
	   b2.setBounds(300,250,180,30);
	   b2.setFont(new Font("Serif",Font.BOLD , 15));
	   b2.setBackground(Color.BLACK);
	   b2.setForeground(Color.red);
      setBounds(400,100,300,300);
	  setVisible(true);
	  setSize(550,480);
	  setTitle("STOCK MATERIAL");
	  add(l1);
	  add(b1);
	  add(b2);
	  b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Home.this.dispose();
			new registration();
		}
	});
	  b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Home.this.dispose();
				new Login1();
			}
		});
	  b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Home.this.dispose();
			new login2();
		}
	});
	}
public static void main(String[] args) {
	new Home();
}
}
