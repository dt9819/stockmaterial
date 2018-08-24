package stockmaterial;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

public class Pdata extends JFrame 
{
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	 JRadioButton jb[]=new JRadioButton[3];
	 ButtonGroup bg;
	 Container c;
	 List<Float> a;
	Pdata()
	{
		 c=getContentPane();
		 c.setBackground(Color.BLUE);
		 c.setLayout(null);
		bg=new ButtonGroup();
		for(int i=0;i<3;i++)
		{
			jb[i]=new JRadioButton();
			jb[i].setBackground(Color.green);
			
			add(jb[i]);
			bg.add(jb[i]);
		}
		l2=new JLabel("QUANTITY");
		 l2.setFont(new Font("Serif", Font.BOLD, 18));
		l2.setBounds(120,210,100,30);
		l2.setForeground(Color.BLACK);
		t1=new JTextField();
		t1.setBounds(240,210,100,30);
		t1.setForeground(Color.RED);
		b1=new JButton("OK");
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.red);
		b1.setBounds(170,250,80,30);
		b2=new JButton("BACK");
		b2.setBounds(10,10,70,30);

		b2.setBackground(Color.black);
		b2.setForeground(Color.red);
		 l1=new JLabel("CHOOSE YOUR PRODUCT");
		 l1.setForeground(Color.RED);
		 l1.setFont(new Font("Serif", Font.BOLD, 25));
		l1.setBounds(110,30,400,20);
		jb[0].setBounds(150,80,200,20);
		jb[0].setText("PRODUCT 1");
		jb[1].setBounds(150,130,200,20);
		jb[1].setText("PRODUCT 2");
		jb[2].setBounds(150,180,200,20);
		jb[2].setText("PRODUCT 3");
		setBounds(400,200,300,300);
		setVisible(true);
		setSize(550,350);
		setTitle("STOCK MATERIAL");
		add(l1);
		add(l2);
		add(t1);
		add(b1);
		add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Pdata.this.dispose();
				new list1();
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a=new ArrayList();
			Connection c=ConnectionProvider.getCon();	
			try{
				
			PreparedStatement p=c.prepareStatement("select * from raw");
			ResultSet rs=p.executeQuery();
			
			while(rs.next())
			{
				a.add(rs.getFloat(1));
			}
			if(!jb[0].isSelected()&&!jb[1].isSelected()&&!jb[2].isSelected())
			{
				JOptionPane.showMessageDialog(null,"Please select the option");	
			}
			if(jb[0].isSelected())
			{

				float j=0;
				
				try{
					j=Float.parseFloat(t1.getText());
					}catch(Exception g)
					{
						JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
					}
				
				float r1=.2f*j;
				float r2=.3f*j;
				float r3= .5f*j;
				float f1=a.get(0);
				float f2=a.get(1);
				float f3=a.get(2);
				if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
				{
					JOptionPane.showMessageDialog(null,"product 1 is formed");
   
					 p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW1");
					p.setFloat(1, f1-r1);
					p.executeUpdate();
                p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW2");
					p.setFloat(1, f2-r2);
					p.executeUpdate();
                  p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW3");
					p.setFloat(1, f3-r2);
					p.executeUpdate();
				}
				else
				{
					if(r1>(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
							{
						JOptionPane.showMessageDialog(null,"Raw material 1,2,3 are not sufficient to form product 1");
							}
					if(r1>(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 1,2 are not sufficient to form product 1");
					}
					if(r1>(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 1,3 are not sufficient to form product 1");
					}
					if(r1<=(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 2,3 are not sufficient to form product 1");
					}
					if(r1>(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 1 is not sufficient to form product 1");
					}
					if(r1<=(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 2  is not sufficient to form product 1");
					}
					if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 3 is not sufficient to form product 1");
					}
					}
			
			}
			if(jb[1].isSelected())
			{ int k=0;
				
				float j=0;
				
				try{
					j=Float.parseFloat(t1.getText());
					}catch(Exception g)
					{
						JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
					}
				
				
				float r1=.3f*j;
				float r2=.2f*j;
				float r3= .5f*j;
				float f1=a.get(0);
				float f2=a.get(1);
				float f3=a.get(2);
			
				if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
				{
					JOptionPane.showMessageDialog(null,"product 2 is formed");

					 p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW1");
					p.setFloat(1, f1-r1);
					p.executeUpdate();
                p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW2");
					p.setFloat(1, f2-r2);
					p.executeUpdate();
                  p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW3");
					p.setFloat(1, f3-r2);
					p.executeUpdate();
				}
				else
				{
					if(r1>(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 1,2,3 are not sufficient to form product 2");
					}
			if(r1>(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1,2 are not sufficient to form product 2");
			}
			if(r1>(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1,3 are not sufficient to form product 2");
			}
			if(r1<=(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 2,3 are not sufficient to form product 2");
			}
			if(r1>(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1 is not sufficient to form product 2");
			}
			if(r1<=(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 2  is not sufficient to form product 2");
			}
			if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 3 is not sufficient to form product 2");
			}
			
				}
			
				
			}
			if(jb[2].isSelected())
			{ int k=0;
			float j=0;
				try{
				j=Float.parseFloat(t1.getText());
				}catch(Exception g)
				{
					JOptionPane.showMessageDialog(null,"write the quantity in coorect format");
				}
				float r1=.5f*j;
				float r2=.2f*j;
				float r3= .3f*j;
				float f1=a.get(0);
				float f2=a.get(1);
				float f3=a.get(2);
				if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
				{
					JOptionPane.showMessageDialog(null,"product 3 is formed");

					 p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW1");
					p.setFloat(1, f1-r1);
					p.executeUpdate();
                p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW2");
					p.setFloat(1, f2-r2);
					p.executeUpdate();
                  p=c.prepareStatement("update raw set quantity=? where type=?");
					
					
					p.setString(2, "RAW3");
					p.setFloat(1, f3-r2);
					p.executeUpdate();
				}
				else
				{
					if(r1>(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
					{
				JOptionPane.showMessageDialog(null,"Raw material 1,2,3 are not sufficient to form product 3");
					}
			if(r1>(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1,2 are not sufficient to form product 3");
			}
			if(r1>(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1,3 are not sufficient to form product 3");
			}
			if(r1<=(a.get(0))&&r2>(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 2,3 are not sufficient to form product 3");
			}
			if(r1>(a.get(0))&&r2<=(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 1 is not sufficient to form product 3");
			}
			if(r1<=(a.get(0))&&r2>(a.get(1))&&r3<=(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 2  is not sufficient to form product 3");
			}
			if(r1<=(a.get(0))&&r2<=(a.get(1))&&r3>(a.get(2)))
			{
		JOptionPane.showMessageDialog(null,"Raw material 3 is not sufficient to form product 3");
			}
				}
			
				
			}
			}
			catch(Exception q)
			{
				System.out.println(q);
			}
			}});
}

}
