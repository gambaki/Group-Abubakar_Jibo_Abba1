import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SectionsBTN extends JFrame implements ActionListener {
Container frame = getContentPane();
//connection	
Connection cn;
Statement st;
PreparedStatement ps;
//holder
JTextField holder = new JTextField();
String [] listSta = {"Select Level","1", "2", "3", "4", "5", "6"};


//labels
JLabel lblSections = new JLabel("");
JLabel lblGradelvl = new JLabel("");
JLabel lblSectionCB = new JLabel("");
JLabel lblSection = new JLabel("");


//combo box
JComboBox cbGradelvl = new JComboBox(listSta);
JComboBox cbSection = new JComboBox();

//buttons

JButton btnBack = new JButton();
JButton btnDelete = new JButton("");
//JButton btnUpdate = new JButton("Delete");
JButton btnAdd = new JButton("");

//txtField
JTextField txtSection = new JTextField();

	public static void main(String args[]){
	SectionsBTN pane = new SectionsBTN();
	
	pane.setSize(440, 280);
	pane.setTitle("Sections");
	pane.setResizable(false);
	pane.setVisible(true);
	}

    public SectionsBTN() {
    	frame.setLayout(null);
    	
    	 	//connect to database
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn = DriverManager.getConnection("jdbc:odbc:EnrollmentSYS");
		}catch(ClassNotFoundException e)  {
 			System.err.println("Failed to load driver");
 			e.printStackTrace();
 	
 		}catch(SQLException e){
 			System.err.println("Unable to connect");
 			e.printStackTrace();	
 		}
 		//eend for the connection
    	
    	
    	
    	
    	
    	
 	
 		//combo box
 		cbSection.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbSection.setBounds(180, 123, 100, 26);
		frame.add(cbSection);

		
		cbGradelvl.setFont(new Font("Tahoma", Font.BOLD, 15));
	//	cbGradelvl.setModel(new DefaultComboBoxModel(new String[] {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6"}));
		cbGradelvl.setBounds(180, 86, 100, 26);
		frame.add(cbGradelvl);

	
		cbGradelvl.addActionListener(new ActionListener(){
   		
    		public void actionPerformed(ActionEvent e){
    			
    			 int itemCount = cbSection.getItemCount();

    			for(int i=0;i<itemCount;i++){
    				
        		cbSection.removeItemAt(0);
        		
    			}
    		//	txtSection.setText(listSta[cbGradelvl.getSelectedIndex()]);
    			
    			try{ 
    								
			st= cn.createStatement();	
																											
					ResultSet rs=st.executeQuery("SELECT * FROM tbl_sec WHERE Grade = '" + listSta[cbGradelvl.getSelectedIndex()] + "'");
						
						while(rs.next()){
								cbSection.addItem(rs.getString(2));	
							}
						st.close();

	
			}catch(SQLException s){
			JOptionPane.showMessageDialog(null,"Unable to search!.","Student Information System",JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
			}
    			
    		}
    	});
    	
 	
 		
    	
    	
    	//labels
    	lblSections.setFont(new Font("Garamond", Font.BOLD, 22));
		lblSections.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(lblSections);
		lblGradelvl.setIcon(new ImageIcon("GRADELVL.png"));
		lblGradelvl.setBounds(65, 86, 99, 26);
		
		lblGradelvl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradelvl.setHorizontalAlignment(SwingConstants.TRAILING);
		frame.add(lblGradelvl);
		lblSection.setIcon(new ImageIcon("ADDSEC.png"));
		lblSection.setBounds(75, 161, 92, 26);
		
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setHorizontalAlignment(SwingConstants.TRAILING);
		frame.add(lblSection);
		lblSectionCB.setIcon(new ImageIcon("SECT.png"));
		lblSectionCB.setBounds(65, 124, 92, 26);
		
		
		lblSectionCB.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSectionCB.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.add(lblSectionCB);
		
		txtSection.setBounds(181, 166, 99, 21);
		txtSection.setColumns(10);
		frame.add(txtSection);
		
		
		btnAdd.setBounds(321, 86, 91, 23);
		btnAdd.setIcon(new ImageIcon("ADD.png"));
		frame.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnDelete.setBounds(321, 123, 91, 23);
		btnDelete.setIcon(new ImageIcon("STUDELETE.png"));
		frame.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnBack.setBounds(321, 164, 91, 23);
		btnBack.setIcon(new ImageIcon("STUBACK.png"));
		frame.add(btnBack);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("SECBACK.png"));
		lblNewLabel.setBounds(0, 0, 466, 262);
		
		frame.add(lblNewLabel);
		btnBack.addActionListener(this);
		
	
		
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
		
		if(source==btnBack){
			MaintenanceBTN pane = new MaintenanceBTN();
			pane.setLocation(400,250);
			pane.setSize(245, 270);
			pane.setTitle("Maintenance");
			pane.setResizable(false);
			pane.setVisible(true);
			dispose();
			
		}

		if (source == btnAdd){
			try{
			
				String addSec = txtSection.getText();
					
					if(!addSec.equals("")){
							st= cn.createStatement();
							ps=cn.prepareStatement("INSERT INTO tbl_sec" + " (Grade, Section) " + "VALUES(?,?)");
							ps.setString(1,listSta[cbGradelvl.getSelectedIndex()]);
							ps.setString(2,txtSection.getText());
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"New account has been successfully added.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
							txtSection.requestFocus(true);
							st.close();
							
					
					}
					else{
							JOptionPane.showMessageDialog(null,"No text entered!","Warning",JOptionPane.WARNING_MESSAGE);	
					}
			
			
			
			}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
			JOptionPane.showMessageDialog(null,"Unable to save!.","Student Information System",JOptionPane.ERROR_MESSAGE);}
		}//end btnAdd
		
		if(source==btnDelete){
			
			try{
			
				String delsec = txtSection.getText();
					
					if(!delsec.equals("")){
							st= cn.createStatement();
							ps=cn.prepareStatement("DELETE FROM tbl_sec WHERE Section = '" + delsec + "'");
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"record has been successfully deleted."," INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
							txtSection.requestFocus(true);
							st.close();
							
					
					}
					else{
							JOptionPane.showMessageDialog(null,"No text entered!","Warning",JOptionPane.WARNING_MESSAGE);	
					}	
			}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
			JOptionPane.showMessageDialog(null,"Unable to save!.","Student Information System",JOptionPane.ERROR_MESSAGE);}
		}			
/*				
		try{
				
				String	searchSec = JOptionPane.showInputDialog(null,"Enter Section to delete.","Delete Section",JOptionPane.QUESTION_MESSAGE);
			//st= cn.createStatement();
				ps = cn.prepareStatement("DELETE FROM tbl_sec WHERE Section = '" + searchSec + "'");
				ps.executeUpdate();
					
				
				JOptionPane.showMessageDialog(null,"record has been successfully deleted."," INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
				txtSection.requestFocus(true);
				st.close();

				
			}catch(SQLException s){
				JOptionPane.showMessageDialog(null,"Unable to delete!.","Student Information System",JOptionPane.ERROR_MESSAGE);
				}	
			/*
			
						ps = cn.prepareStatement("DELETE * FROM tbl_sec WHERE Section ='"+ txtSection.getText() + "'");
						
						
						}catch(SQLException s){
							System.out.print("SQL statement is not executed!");
						}
			
		}//end btnDelete*/
	
    }
    
}