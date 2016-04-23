import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class UserSettings extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 5731788397013630356L;

Container frame = getContentPane();

//connection	
Connection cn;
Statement st;
PreparedStatement ps;

//labels
	JLabel lblUsername = new JLabel("Username: ");
	JLabel lblPassword = new JLabel("Password :");
	JLabel lblFname = new JLabel("First Name :");
	JLabel lblMname = new JLabel("Middle Name :");
	JLabel lblLname = new JLabel("Last Name :");
	JLabel lblAddress = new JLabel("Address :");
	JLabel lblGender = new JLabel("Gender :");
	JLabel lblBirthday = new JLabel("Birthday :");
	JLabel lblMonth = new JLabel("Month");
	JLabel lblDay = new JLabel("Day");
	JLabel lblYear = new JLabel("Year");
	
//text fields		
	JTextField txtUser = new JTextField();
	JTextField txtPass = new JTextField();
	JTextField txtFname = new JTextField();
	JTextField txtMname = new JTextField();
	JTextField txtLname = new JTextField();
	JTextField txtAddress = new JTextField();
	JTextField txtGender = new JTextField();
	JTextField txtBmon = new JTextField();
	JTextField txtBday = new JTextField();
	JTextField txtByear = new JTextField();
	
//buttons
	JButton btnSearch = new JButton("Search");	
	JButton btnUpdate = new JButton("Update");
	JButton btnDelete = new JButton("Delete");
	JButton btnBack = new JButton("Back");
	


	public static void main(String args[]){
	UserSettings pane = new UserSettings();
	
	pane.setLocation(228, 341);
	pane.setSize( 228, 341);
	pane.setTitle("User Settings");
	pane.setResizable(false);
	pane.setVisible(true);
	}
	
	
    public UserSettings() {
    	frame.setLayout(null);
    	
    	txtUser.setEnabled(false);
    	txtPass.setEnabled(false);
    	txtFname.setEnabled(false);
    	txtMname.setEnabled(false);
    	txtLname.setEnabled(false);
    	txtAddress.setEnabled(false);
    	txtGender.setEnabled(false);
    	txtBmon.setEnabled(false);
    	txtBday.setEnabled(false);
    	txtByear.setEnabled(false);
    	
    	//connect to database
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollmentsys","root","");
		}catch(ClassNotFoundException e)  {
 			System.err.println("Failed to load driver");
 			e.printStackTrace();
 	
 		}catch(SQLException e){
 			System.err.println("Unable to connect");
 			e.printStackTrace();	
 		}
 		//eend for the connection
    	
    	
    	
    	//labels
    
		lblUsername.setBounds(10, 11, 79, 14);
		frame.add(lblUsername);
		
		
		lblPassword.setBounds(10, 36, 79, 14);
		frame.add(lblPassword);
		
		
		lblFname.setBounds(10, 61, 79, 14);
		frame.add(lblFname);
		
	
		lblMname.setBounds(10, 86, 79, 14);
		frame.add(lblMname);
		
	
		lblLname.setBounds(10, 111, 79, 14);
		frame.add(lblLname);
		
	
		lblAddress.setBounds(10, 136, 79, 14);
		frame.add(lblAddress);
		
	
		lblGender.setBounds(10, 161, 79, 14);
		frame.add(lblGender);
		
	
		lblBirthday.setBounds(10, 211, 79, 14);
		frame.add(lblBirthday);
		
	
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(76, 186, 35, 14);
		frame.add(lblMonth);
		
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(121, 186, 35, 14);
		frame.add(lblDay);
		
	
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(166, 186, 35, 14);
		frame.add(lblYear);
    	
    	//textfields
    
		txtUser.setBounds(84, 11, 117, 20);
		frame.add(txtUser);
		txtUser.setColumns(10);
		
	
		txtPass.setColumns(10);
		txtPass.setBounds(84, 36, 117, 20);
		frame.add(txtPass);
		
		
		txtFname.setColumns(10);
		txtFname.setBounds(84, 61, 117, 20);
		frame.add(txtFname);
		
		
		txtMname.setColumns(10);
		txtMname.setBounds(84, 86, 117, 20);
		frame.add(txtMname);
		
	
		txtLname.setColumns(10);
		txtLname.setBounds(84, 111, 117, 20);
		frame.add(txtLname);
		
	
		txtAddress.setColumns(10);
		txtAddress.setBounds(84, 136, 117, 20);
		frame.add(txtAddress);
		
	
		txtGender.setColumns(10);
		txtGender.setBounds(84, 161, 117, 20);
		frame.add(txtGender);
		
	
		txtBmon.setBounds(76, 208, 35, 20);
		frame.add(txtBmon);
		txtBmon.setColumns(10);
		
		
		txtBday.setColumns(10);
		txtBday.setBounds(121, 208, 35, 20);
		frame.add(txtBday);
		
	
		txtByear.setColumns(10);
		txtByear.setBounds(166, 208, 35, 20);
		frame.add(txtByear);
    	
    	//buttons
    	
    
		btnSearch.setBounds(10, 245, 91, 23);
		frame.add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnUpdate.setBounds(121, 245, 91, 23);
		frame.add(btnUpdate);
		btnUpdate.addActionListener(this);
	
		btnDelete.setBounds(10, 279, 91, 23);
		frame.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnBack.setBounds(121, 279, 91, 23);
		frame.add(btnBack);
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
     	
     	if(source==btnUpdate){
     		
     		txtUser.setEnabled(false);
    	txtPass.setEnabled(false);
    	txtFname.setEnabled(false);
    	txtMname.setEnabled(false);
    	txtLname.setEnabled(false);
    	txtAddress.setEnabled(false);
    	txtGender.setEnabled(false);
    	txtBmon.setEnabled(false);
    	txtBday.setEnabled(false);
    	txtByear.setEnabled(false);
     		
     		
     		try{
				String user		=txtUser.getText();
				String pass		=txtPass.getText();
				String fname	=txtFname.getText();
				String mname	=txtMname.getText();
				String lname	=txtLname.getText();
				String gender	=txtGender.getText();
				String address	=txtAddress.getText();
				String bmon		=txtBmon.getText();
    			String bday		=txtBday.getText();
    			String byear	=txtByear.getText();
    			
    		if(!user.equals("") || !pass.equals("")|| !fname.equals("") || !mname.equals("") || !lname.equals("") || !gender.equals("") || !address.equals("")|| !bmon.equals("") || !bday.equals("") || !byear.equals("")  ){			
    		st= cn.createStatement();
    		PreparedStatement ps = cn.prepareStatement
				("UPDATE Login SET Password = '" + txtPass.getText() + 
				"',Fname = '" + txtFname.getText() + 
				"',Mname = '" + txtMname.getText() + 
				"',Lname = '" + txtLname.getText()+ 
				"',Gender= '" + txtGender.getText() +  
				"',Address = '" + txtAddress.getText() +
				"',Bmonth = '" + txtBmon.getText() +
				"',Bday = '" + txtBday.getText() +
				"',Byear = '" + txtByear.getText() +
				"'WHERE Username = '" + txtUser.getText()+ "'");
    		ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Account has been successfully updated.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
			txtUser.requestFocus(true);
			st.close();
			
    		}
			}catch (SQLException y){
			JOptionPane.showMessageDialog(null,"Unable to update!.","User Settings",JOptionPane.ERROR_MESSAGE);
			}	
		}//end of  btn update
     	
     	if(source==btnSearch){
     		
     	txtUser.setEnabled(true);
    	txtPass.setEnabled(true);
    	txtFname.setEnabled(true);
    	txtMname.setEnabled(true);
    	txtLname.setEnabled(true);
    	txtAddress.setEnabled(true);
    	txtGender.setEnabled(true);
    	txtBmon.setEnabled(true);
    	txtBday.setEnabled(true);
    	txtByear.setEnabled(true);
     		
     		
     		
     			try{
					String searchID ="";
					int tmp=0;
					
					searchID = JOptionPane.showInputDialog(null,"Enter Username to search.","User Settings",JOptionPane.QUESTION_MESSAGE);
					st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM Login WHERE Username = '" + searchID + "'");
						
						while(rs.next()){
							
							txtUser.setText(rs.getString(1));
							txtPass.setText(rs.getString(2));
							txtFname.setText(rs.getString(3));
							txtMname.setText(rs.getString(4));
							txtLname.setText(rs.getString(5));
							txtAddress.setText(rs.getString(6));
							txtBmon.setText(rs.getString(7));
							txtBday.setText(rs.getString(8));	
							txtByear.setText(rs.getString(9));
							txtGender.setText(rs.getString(10));
							
						/*
							txtFname.setText(rs.getString(3));
							txtMname.setText(rs.getString(4));
							txtLname.setText(rs.getString(5));
							txtAddress.setText(rs.getString(6));
							txtBmon.setText(rs.getString(7));
							txtBday.setText(rs.getString(8));
							txtByear.setText(rs.getString(9));
							txtGender.setText(rs.getString(10));
							*/
							tmp=1;
							
							}
							//tmp = 0;
						st.close();
						if (tmp==0){
							JOptionPane.showMessageDialog(null,"No record found!!.","Student Information System",JOptionPane.INFORMATION_MESSAGE);	
						}
			
			
			}catch(SQLException s){
			JOptionPane.showMessageDialog(null,"Unable to search!.","Student Information System",JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
			}
     		
     	}
     	
     	if(source==btnDelete){
     		
     		txtUser.setEnabled(false);
    	txtPass.setEnabled(false);
    	txtFname.setEnabled(false);
    	txtMname.setEnabled(false);
    	txtLname.setEnabled(false);
    	txtAddress.setEnabled(false);
    	txtGender.setEnabled(false);
    	txtBmon.setEnabled(false);
    	txtBmon.setEnabled(false);
    	txtByear.setEnabled(false);
     		
     			if(!txtUser.getText().equalsIgnoreCase("")){
    	 	
    	 		try{
						PreparedStatement ps = cn.prepareStatement("DELETE FROM Login WHERE Username ='"+ txtUser.getText() + "'");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Account has been successfully deleted.","User Settings",JOptionPane.INFORMATION_MESSAGE);
					//	disabled();
					//	clear();
						st.close();
					}catch(SQLException s){
					JOptionPane.showMessageDialog(null,"Unable to delete!.","User Settings",JOptionPane.ERROR_MESSAGE);
					}
     			}
			
     		
     		
     		
     	}
     	if(source==btnBack){
			MaintenanceBTN pane = new MaintenanceBTN();
			pane.setLocation(400,250);
			pane.setSize(245, 270);
			pane.setTitle("Maintenance");
			pane.setResizable(false);
			pane.setVisible(true);
			dispose();
     	}
     	
     	
     }
     	
     	
     	
}
    
    
