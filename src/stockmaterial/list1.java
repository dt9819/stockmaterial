package stockmaterial;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class list1  extends JFrame 
{
	 JButton b1,b2;
	 JLabel l1;
	 JRadioButton jb[]=new JRadioButton[3];
	 ButtonGroup bg;
	 Container c;
     list1()
     {
    	 c=getContentPane();
		 c.setBackground(Color.yellow);
		 c.setLayout(null);
		 l1=new JLabel("CHOOSE YOUR OPERATION");
		 l1.setFont(new Font("Serif", Font.BOLD, 25));
		 l1.setForeground(Color.black);
		 bg=new ButtonGroup();
			for(int i=0;i<3;i++)
			{
				jb[i]=new JRadioButton();
				jb[i].setBackground(Color.CYAN);
				
				add(jb[i]);
				bg.add(jb[i]);
			}
			
			b1=new JButton("OK");
			b1.setBackground(Color.black);
			b1.setForeground(Color.red);
			l1.setBounds(110,30,400,20);
			
			b1.setBounds(170,230,80,30);
			
			jb[0].setBounds(150,80,200,20);
			jb[0].setText("ADD RAW MATERIAL");
			jb[1].setBounds(150,130,200,20);
			jb[1].setText("CREATE PRODUCT");
			jb[2].setBounds(150,180,200,20);
			jb[2].setText("SAW RAW MATERIAL");
			
			add(l1);
			add(b1);
			setBounds(400,200,300,300);
			setVisible(true);
			setSize(550,350);
			setTitle("STOCK MATERIAL");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!jb[0].isSelected()&&!jb[1].isSelected()&&!jb[2].isSelected())
				{
					JOptionPane.showMessageDialog(null,"Please select the option");	
				}
				if(jb[0].isSelected())
				{  list1.this.dispose();
				    new Adata();
				}
				if(jb[1].isSelected())
				{  list1.this.dispose();
				    new Pdata();
				}
				if(jb[2].isSelected())
				{  list1.this.dispose();
				    new Sdata();
				}
				
			}
		});	
	
     }
    
	
	
}
