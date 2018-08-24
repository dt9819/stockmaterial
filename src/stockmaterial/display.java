package stockmaterial;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class display extends JFrame implements ActionListener {
 
    JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1,b2,b3;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    Container c;
    static JTable table;
    String[] columnNames = {"NAME", "email", "pass", "country","state","phone"};
    String from;
 
    display() {

        try {
            con=ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery("select name from sonal");
            Vector v = new Vector();
            v.add("Click to select");
            
            while (rs.next()) {
                ids = rs.getString(1);
               
                v.add(ids);
            }
            
            c1 = new JComboBox(v);
            c1.setSelectedItem(0);

            c1.setBounds(230, 110, 150, 20);
        c1.setBackground(Color.CYAN);
       c1.setForeground(Color.black);
   
       add(c1);
        
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    	c=getContentPane();
 c.setBackground(Color.green);
        l0 = new JLabel("Fatching Employee Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 25));
        l1 = new JLabel("Select name");
        b1 = new JButton("submit");

        l0.setBounds(60, 30, 350, 40);
        l1.setBounds(60, 110, 150, 20);
        l1.setFont(new Font("Serif", Font.BOLD, 18));
        l1.setForeground(Color.black);
        b1.setBounds(150, 180, 100, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.red);

		b3=new JButton("BACK");
		b3.setBounds(5,5,70,20);

		b3.setBackground(Color.black);
		b3.setForeground(Color.red);
        add(l0);
        add(l1);
        add(b1);
        add(b3);
        b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				display.this.dispose();
				new Home();
			}
		});
        b1.addActionListener(this);
        setTitle("Fetching Employee Info From DataBase");
        setLayout(null);
        setVisible(true);
        setSize(480, 400);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
       
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
        	
        	  if((c1.getSelectedIndex()==0))
              {
               {
                   JOptionPane.showMessageDialog(null, "Please select first");
               }}
        	  else
        	  {this.dispose();
            showTableData();
        	  }
        }
 
    }
 
    public void showTableData() {
 
        frame1 = new JFrame("Database Search Result");
        //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.setBackground(Color.magenta);
        b2=new JButton("BACK");
        b2.setBounds(260, 200, 70, 20);
        b2.setBackground(Color.black);
        b2.setForeground(Color.red);
        frame1.add(b2);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame1.dispose();
				new display();
			}
		});
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnIdentifiers(columnNames);
       
   
        table = new JTable();
        table.setModel(model);
     
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setRowHeight(28);;
        table.setBackground(Color.MAGENTA);
        table.setSelectionBackground(Color.gray);
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Serif", Font.BOLD, 18));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        from = (String) c1.getSelectedItem();

        String name = "";
        String email = "";
        String pass = "";
        String country = "";
        String state="";
        long phone=0;
 
        try {
            pst = con.prepareStatement("select * from sonal where NAME='" + from + "'");
            ResultSet rs = pst.executeQuery();
            
            int i = 0;
            if (rs.next()) {
                name = rs.getString("name");
                email = rs.getString("email");
                pass = rs.getString("pass1");
                country = rs.getString("country");
                state=rs.getString("state");
                phone=rs.getLong("phone");
                model.addRow(new Object[]{name, email, pass, country,state,phone});
                i++;
            }
           if((c1.getSelectedIndex()!=0)&&i==0)
           {
            {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }}
         
           /* if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }*/
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(700, 350);
       
    }
 
}

