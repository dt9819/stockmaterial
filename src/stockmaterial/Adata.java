package stockmaterial;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Adata extends JFrame 
{
	JLabel l1,l2;
	List<Integer> l;
	JTextField t1,t2;
	JButton b1,b2,b3;
	 JRadioButton jb[]=new JRadioButton[3];
	 ButtonGroup bg;
	 Container c;
	Adata()
	{
		 c=getContentPane();
		 c.setBackground(Color.green);
		 c.setLayout(null);
		bg=new ButtonGroup();
		for(int i=0;i<3;i++)
		{
			jb[i]=new JRadioButton();
			jb[i].setBackground(Color.lightGray);
			
			add(jb[i]);
			bg.add(jb[i]);
		}
		
		b2=new JButton("BACK");
		b2.setBounds(10,10,70,30);

		b2.setBackground(Color.black);
		b2.setForeground(Color.red);
		b1=new JButton("OK");
		b1.setBackground(Color.black);
		b1.setForeground(Color.red);
		b1.setBounds(170,250,80,30);
		b3=new JButton("SHOW DATA");
		b3.setBackground(Color.black);
		b3.setForeground(Color.red);
		b3.setBounds(290,250,110,30);
		add(b3);
		l2=new JLabel("QUANTITY");
		 l2.setFont(new Font("Serif", Font.BOLD, 18));
		l2.setBounds(120,210,100,30);
		l2.setForeground(Color.BLUE);
		t1=new JTextField();
		t1.setBounds(240,210,100,30);
		t1.setForeground(Color.RED);
		 l1=new JLabel("CHOOSE YOUR RAW MATERIAL");
		 l1.setForeground(Color.MAGENTA);
		 l1.setFont(new Font("Serif", Font.BOLD, 25));
		l1.setBounds(110,30,400,20);
		jb[0].setBounds(150,80,200,20);
		jb[0].setText("RAW MATERIAL 1");
		jb[1].setBounds(150,130,200,20);
		jb[1].setText("RAW MATERIAL 2");
		jb[2].setBounds(150,180,200,20);
		jb[2].setText("RAW MATERIAL 3");
		setBounds(400,200,300,300);
		setVisible(true);
		setSize(550,350);
		setTitle("STOCK MATERIAL");
		add(l1);
		add(t1);
		add(l2);
		add(b1);
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Adata.this.dispose();
				new list1();
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection c=ConnectionProvider.getCon();
				
				/*PreparedStatement ps=c.prepareStatement("create table raw(quantity integer(10),type varchar(10))");
				
				ps.executeUpdate();*/
				try
				{
				
			PreparedStatement p=c.prepareStatement("select * from raw");
					ResultSet rs=p.executeQuery();
					if(!jb[0].isSelected()&&!jb[1].isSelected()&&!jb[2].isSelected())
					{
						JOptionPane.showMessageDialog(null,"Please select the option");	
					}
				if(jb[0].isSelected())
				{ float k=0;
				float j=0;
					while(rs.next())
				{
					if(rs.getString(2).equals("RAW1"))
					{
						k=rs.getFloat(1);
					}
				}
					 p=c.prepareStatement("update raw set quantity=? where type=?");
					 try{
							j=Float.parseFloat(t1.getText());
							}catch(Exception g)
							{
								JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
							}
					
					p.setString(2, "RAW1");
					p.setFloat(1, j+k);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null,"SUCESSFULLY ADDED");
					
				}

				if(jb[1].isSelected())
				{
					float j=0;
					float k=0;
					
					while(rs.next())
					{
						if(rs.getString(2).equals("RAW2"))
						{
							k=rs.getFloat(1);
						}
					}
					p=c.prepareStatement("update raw set quantity=? where type=?");
					try{
						j=Float.parseFloat(t1.getText());
						}catch(Exception g)
						{
							JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
						}
					p.setString(2, "RAW2");
					p.setFloat(1, j+k);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null,"SUCESSFULLY ADDED");
				}

				if(jb[2].isSelected())
				{float k=0;
				float j=0;
					while(rs.next())
					{
						if(rs.getString(2).equals("RAW3"))
						{
							k=rs.getFloat(1);
						}
					}
					p=c.prepareStatement("update raw set quantity=? where type=?");
					try{
						j=Float.parseFloat(t1.getText());
						}catch(Exception g)
						{
							JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
						}
					p.setString(2, "RAW3");
					p.setFloat(1, j+k);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null,"SUCESSFULLY ADDED");
				}
				}catch(Exception e)
				{
					System.out.println("exception");
				}
			}});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Adata.this.dispose();
				new Sdata();
			}
		});
}
	
	
}