package stockmaterial;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Sdata extends JFrame{
	 JRadioButton jb[]=new JRadioButton[3];
	 ButtonGroup bg;
	 JLabel l1,l2;
	 List<Float> l;
	 Container c;
	 int i;
	 JButton b1,b2;
	 Sdata()
	 { 
		 c=getContentPane();
	     c.setBackground(Color.MAGENTA);
	     c.setLayout(null);
		 l1=new JLabel();
		 l1.setBounds(150,250,270,20);
		 l1.setForeground(Color.CYAN);
		 l1.setFont(new Font("Serif",Font.BOLD,20));
		 l2=new JLabel("RAW MATERIAL STOCK");
		 l2.setBounds(100,30,370,20);
		 l2.setFont(new Font("Serif",Font.BOLD,25));
		 l2.setForeground(Color.YELLOW);
		 add(l2);

			b2=new JButton("BACK");
			b2.setBounds(10,10,70,30);

			b2.setBackground(Color.black);
			b2.setForeground(Color.red);
		 bg=new ButtonGroup();
			for(int i=0;i<3;i++)
			{
				jb[i]=new JRadioButton();
				jb[i].setBackground(Color.lightGray);
				
				add(jb[i]);
				bg.add(jb[i]);
			}
			jb[0].setBounds(150,80,200,20);
			jb[0].setText("RAW MATERIAL 1");
			jb[1].setBounds(150,130,200,20);
			jb[1].setText("RAW MATERIAL 2");
			jb[2].setBounds(150,180,200,20);
			jb[2].setText("RAW MATERIAL 3");
			b1=new JButton("OK");
			b1.setBounds(150,220,100,20);
			 b1.setBackground(Color.black);
		        b1.setForeground(Color.red);
			add(l1);
			add(b1);
			setBounds(400,200,300,300);
			setVisible(true);
			setSize(550,350);
			setTitle("STOCK MATERIAL");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!jb[0].isSelected()&&!jb[1].isSelected()&&!jb[2].isSelected())
				{
					JOptionPane.showMessageDialog(null,"Please select the option");	
				}
				if(jb[0].isSelected())
				{
					
					
					try {
						l = Sdata.raws();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					float i= l.get(0);
					String o=String.valueOf(i);
					l1.setText("Raw material 1 :"+o);
				}
				if(jb[1].isSelected())
				{
					
					
					try {
						l = Sdata.raws();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				float i= l.get(1);
					String o=String.valueOf(i);
					l1.setText("Raw material 2 :"+o);
				}
				if(jb[2].isSelected())
				{
					
					
					try {
						l = Sdata.raws();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				float i= l.get(2);
					String o=String.valueOf(i);
					l1.setText("Raw material 3 :"+o);
				}
			}
		});
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Sdata.this.dispose();
				new list1();
			}
		});
		
	 }
	public static List<Float> raws() throws Exception
	 { 
		 Connection c=ConnectionProvider.getCon();
		 PreparedStatement ps=c.prepareStatement("select * from raw");
		 ResultSet rs=ps.executeQuery();
		 ArrayList<Float> a=new ArrayList();
		 while(rs.next())
		 {
		    a.add(rs.getFloat(1));
		 }
		return a;
	 }
	 
}
