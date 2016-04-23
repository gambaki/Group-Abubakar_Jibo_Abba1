import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Register extends JFrame implements ActionListener {
Container frame = getContentPane();

Connection cn;
Statement st;
PreparedStatement ps;


//labels

JLabel lblUsername = new JLabel("Username :");
JLabel lblPassword = new JLabel("Password :");
JLabel lblFirstName = new JLabel("First Name :");
JLabel lblMiddleName = new JLabel("Middle Name: ");
JLabel lblLastName = new JLabel("Last Name :");
JLabel lblAddress = new JLabel("Address :");
JLabel lblBirthday = new JLabel("Birthday :");
JLabel lblMonth = new JLabel("Month");
JLabel lblDay = new JLabel("Day");
JLabel lblYear = new JLabel("Year");
JLabel lblGender = new JLabel("Gender :");

//combo box
String [] listGen = {"Male", "Female"};
JComboBox comboBox = new JComboBox(listGen);
JTextField HolderGender	= new JTextField();



//button
JButton btnConfirm = new JButton("");
JButton btnBack = new JButton("");	

//txtfields
	//  JFrame frmRegister;
	  JTextField txtUsername=new JTextField();;
	  JTextField txtFname=new JTextField();;
	  JTextField txtMname=new JTextField();;
	  JTextField txtLname=new JTextField();;
	  JTextField txtAddress=new JTextField();;
	  JTextField txtBmon=new JTextField();;
	  JTextField txtBday=new JTextField();;
	  JTextField txtByear=new JTextField();;
	  JPasswordField txtPassword=new JPasswordField();;
		
	
	public static void main(String args[]){
		Register pane = new Register();
		
		pane.setSize(360,360);
		pane.setTitle("Register Account");
		pane.setResizable(false);
		pane.setVisible(true);
	}
	
    public Register() {
    	frame.setLayout(null);
    	
    	try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn = DriverManager.getConnection("jdbc:odbc:EnrollmentSYS");
		}catch(ClassNotFoundException e)  {
 			System.err.println("Failed to load driver");
 			e.printStackTrace();
 		}
 		catch(SQLException e){
 			System.err.println("Unable to connect");
 			e.printStackTrace();
 		}  
    	
    	
    	
    	
    	JLabel lblUsername = new JLabel("");
		lblUsername.setIcon(new ImageIcon("USERR.png"));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(69, 36, 81, 14);
		frame.add(lblUsername);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon("PAASS.png"));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(69, 61, 81, 14);
		frame.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("");
		lblFirstName.setIcon(new ImageIcon("FIRST NAME.png"));
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(58, 86, 153, 14);
		frame.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("");
		lblMiddleName.setIcon(new ImageIcon("MIDDLE NAME.png"));
		lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddleName.setBounds(38, 111, 153, 14);
		frame.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("");
		lblLastName.setIcon(new ImageIcon("LAST NAME.png"));
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(48, 136, 163, 14);
		frame.add(lblLastName);
		
		JLabel lblAddress = new JLabel("");
		lblAddress.setIcon(new ImageIcon("ADDRESS.png"));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(79, 161, 71, 14);
		frame.add(lblAddress);
		
		JLabel lblBirthday = new JLabel("");
		lblBirthday.setIcon(new ImageIcon("BIRTHDAY.png"));
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setBounds(27, 207, 71, 14);
		frame.add(lblBirthday);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setIcon(new ImageIcon("MONTH.png"));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(70, 186, 89, 14);
		frame.add(lblMonth);
		
		JLabel lblDay = new JLabel("");
		lblDay.setIcon(new ImageIcon("DAY.png"));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(108, 186, 100, 14);
		frame.add(lblDay);
		
		JLabel lblYear = new JLabel("");
		lblYear.setIcon(new ImageIcon("YEAR.png"));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(169, 186, 103, 14);
		frame.add(lblYear);
		
		JLabel lblGender = new JLabel("");
		lblGender.setIcon(new ImageIcon("GENDER.png"));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(89, 244, 71, 14);
		frame.add(lblGender);
		
	//	txtUsername = new JTextField();
		txtUsername.setBounds(160, 33, 113, 20);
		frame.add(txtUsername);
		txtUsername.setColumns(10);
		
	//	txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 58, 113, 17);
		frame.add(txtPassword);
		
	//	txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(160, 83, 113, 20);
		frame.add(txtFname);
		
	//	txtMname = new JTextField();
		txtMname.setColumns(10);
		txtMname.setBounds(160, 108, 113, 20);
		frame.add(txtMname);
		
	//	txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(160, 133, 113, 20);
		frame.add(txtLname);
		
	//	txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(160, 158, 113, 20);
		frame.add(txtAddress);
		
	//	txtBmon = new JTextField();
		txtBmon.setBounds(108, 204, 51, 20);
		frame.add(txtBmon);
		txtBmon.setColumns(10);
		
	//	txtBday = new JTextField();
		txtBday.setColumns(10);
		txtBday.setBounds(170, 204, 51, 20);
		frame.add(txtBday);
		
	//	txtByear = new JTextField();
		txtByear.setColumns(10);
		txtByear.setBounds(233, 204, 51, 20);
		frame.add(txtByear);
		
		
		//combobox
	//	JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Myriad Hebrew", Font.PLAIN, 11));
		comboBox.setBounds(160, 240, 77, 20);
		frame.add(comboBox);
		comboBox.setSelectedIndex(0);
			comboBox.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			
    			HolderGender.setText(listGen[comboBox.getSelectedIndex()]);
    			
    		}
    	});

	
	//buttons	
	//	JButton btnConfirm = new JButton("");
		btnConfirm.setIcon(new ImageIcon("CONFIRM.png"));
		btnConfirm.setBounds(78, 279, 89, 23);
		frame.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
	//	JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("STUBACK.png"));
		btnBack.setBounds(181, 279, 89, 23);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("REGBACK.png"));
		lblNewLabel.setBounds(0, 0, 352, 343);
		frame.add(lblNewLabel);
    		
    		
    	
    }
     public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
	

	  
		if(source == btnConfirm){
			

			
			try{
					
						String user		=txtUsername.getText();
						String pass		=txtPassword.getText();
						String fname	=txtFname.getText();
						String mname	=txtMname.getText();
						String lname	=txtLname.getText();
						String address	=txtAddress.getText();
						String bmon		=txtBmon.getText();
    					String bday		=txtBday.getText();
    					String byear	=txtByear.getText();
    					String gen		=HolderGender.getText();
    				
						
				if((user.length()==0 || pass.length()==0|| fname.length()==0 || mname.length()==0 || lname.length()==0 ||address.length()==0)|| bmon.length()==0 || bday.length()==0 || byear.length()==0 ){			
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    				}		
				else if(!user.equals("") || !pass.equals("") || !fname.equals("") || !mname.equals("") || !lname.equals("") ||  !address.equals("")|| !bmon.equals("") || !bday.equals("") || !byear.equals("") || !gen.equals("")  ){			
					st= cn.createStatement();
					
					ps=cn.prepareStatement("INSERT INTO Login" + " (Username,Password, Fname, Mname, Lname, Address, Bmonth, Bday, Byear, Gender )" + " VALUES(?,?,?,?,?,?,?,?,?,?)");
    				
    				ps.setString(1,txtUsername.getText());
    				ps.setString(2,txtPassword.getText());
    				ps.setString(3,txtFname.getText());
    				ps.setString(4,txtMname.getText());
					ps.setString(5,txtLname.getText());
					ps.setString(6,txtAddress.getText());
					ps.setString(7,txtBmon.getText());
					ps.setString(8,txtBday.getText());
					ps.setString(9,txtByear.getText());
					ps.setString(10,HolderGender.getText());
					
    				
    				ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"New account has been successfully added.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
					txtUsername.requestFocus(true);
					st.close();
    				
				}
			
					else{
							JOptionPane.showMessageDialog(null,"Please Fill Up The Empty Fields","Warning",JOptionPane.WARNING_MESSAGE);	
					}
			//end try
			}catch(SQLException sqlEx){
					sqlEx.printStackTrace();
					JOptionPane.showMessageDialog(null,"Unable to save!.","Student Information System",JOptionPane.ERROR_MESSAGE);}	
						txtUsername.setText("");
    	txtPassword.setText("");
    	txtFname.setText("");
    	txtMname.setText("");
    	txtLname.setText("");
    	txtAddress.setText("");
    //	txtGender.setText("");
    	txtBmon.setText("");
    	txtBday.setText("");
    	txtByear.setText("");
				
		}//end of save
    
    if(source==btnBack){
		
			Login pane = new Login();
			pane.setSize(393, 250);
			pane.setTitle("Login");
			pane.setResizable(false);
			pane.setVisible(true);
			dispose();
			
		}
    
}
}
