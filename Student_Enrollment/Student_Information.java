import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Student_Information extends JFrame implements ActionListener , ItemListener, ListSelectionListener{
Container frame = getContentPane();	
//connection
Connection cn;
Statement st;
PreparedStatement ps;


//labels
		JLabel lblStudentId = new JLabel();
		JLabel lblFname = new JLabel();				
		JLabel lblMname = new JLabel();
		JLabel lblLname = new JLabel();
		JLabel lblGender = new JLabel();
		JLabel lblAge = new JLabel();
		JLabel lblBirthday = new JLabel();
		JLabel lblAddress = new JLabel();
//birthday labels
		JLabel lblMonth = new JLabel();
		JLabel lblDay = new JLabel();
		JLabel lblYear = new JLabel();
		
//txtFields
		JTextField 	txtID = new JTextField();
		JTextField 	txtFname = new JTextField();
		JTextField 	txtMname = new JTextField();
		JTextField 	txtLname = new JTextField();
		JTextField txtGender = new JTextField();
		JTextField txtAge = new JTextField();
		JTextField txtAddress = new JTextField();
	//birthday textfields
	JTextField 	txtBmon = new JTextField();
	JTextField 	txtBday = new JTextField();
	JTextField 	txtByear = new JTextField();

//buttons
		JButton btnSearchID = new JButton();
		JButton btnSave = new JButton();
		JButton btnBack = new JButton();
		JButton btnUpdate = new JButton();
		JButton btnDelete = new JButton();
		
//radio button
	 ButtonGroup buttonGroup = new ButtonGroup();
	 JRadioButton rdbtnMale = new JRadioButton("Male");
	 JRadioButton rdbtnFemale = new JRadioButton("Female");

	public static void main (String args[]){
	Student_Information pane = new Student_Information();
	
	pane.setSize(565, 230);
	pane.setTitle("Student Information");
	pane.setResizable(false);
	pane.setVisible(true);
	}

    public Student_Information() {
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
    	
    	//labels
    	lblStudentId.setIcon(new ImageIcon("STUDENT ID.png"));
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentId.setBounds(-11, 25, 183, 14);
		frame.add(lblStudentId);
		
		lblFname.setIcon(new ImageIcon("FIRST NAME.png"));
		lblFname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFname.setBounds(-24, 50, 196, 14);
		frame.add(lblFname);
		
		
		lblMname.setIcon(new ImageIcon("MIDDLE NAME.png"));
		lblMname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMname.setBounds(10, 75, 150, 14);
		frame.add(lblMname);
		
		
		lblLname.setIcon(new ImageIcon("LAST NAME.png"));
		lblLname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLname.setBounds(10, 100, 168, 14);
		frame.add(lblLname);
		
		
		
		lblGender.setIcon(new ImageIcon("GENDER.png"));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(298, 96, 83, 14);
		frame.add(lblGender);
		
		lblBirthday.setIcon(new ImageIcon("BIRTHDAY.png"));
		
		
	//	lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
	//	lblAge.setBounds(91, 191, 83, 14);
	//	frame.add(lblAge);
		
	
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setBounds(288, 46, 83, 14);
		frame.add(lblBirthday);
		lblAddress.setIcon(new ImageIcon("ADDRESS.png"));
		
		
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(288, 71, 83, 14);
		frame.add(lblAddress);
		
		//birthday labels and text fields
		//labels brithday
		lblMonth.setIcon(new ImageIcon("MONTH.png"));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(321, 25, 115, 14);
		frame.add(lblMonth);
		lblDay.setIcon(new ImageIcon("DAY.png"));
		
		
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(365, 25, 115, 14);
		frame.add(lblDay);
		lblYear.setIcon(new ImageIcon("YEAR.png"));
		
		
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(416, 25, 110, 14);
		frame.add(lblYear);
		
		
		txtBmon.setBounds(381, 43, 41, 20);
		txtBmon.setColumns(10);
		frame.add(txtBmon);
	
	
		txtBday.setColumns(10);
		txtBday.setBounds(434, 43, 41, 20);
		frame.add(txtBday);
		
	
		txtByear.setColumns(10);
		txtByear.setBounds(485, 43, 41, 20);
		frame.add(txtByear);
		
		
		//textFields
    	
		txtID.setBounds(127, 22, 83, 20);
		txtID.setColumns(10);
		frame.add(txtID);
	
	
		txtFname.setColumns(10);
		txtFname.setBounds(127, 47, 145, 20);
		frame.add(txtFname);
		
	
		txtMname.setColumns(10);
		txtMname.setBounds(127, 72, 145, 20);
		frame.add(txtMname);
		
	
		txtLname.setColumns(10);
		txtLname.setBounds(127, 97, 145, 20);
		frame.add(txtLname);
		
//gender text box	
	//	txtGender.setColumns(10);
	//	txtGender.setBounds(184, 163, 145, 20);
	//	frame.add(txtGender);
		
	
//txtAge.setColumns(10);
//		txtAge.setBounds(184, 188, 145, 20);
//		frame.add(txtAge);
		
	
		txtAddress.setColumns(10);
		txtAddress.setBounds(381, 68, 145, 20);
		frame.add(txtAddress);
		
		//buttons
		/*	try{
	
 String searchID = "1";
	
			st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM Student_Information WHERE ID = '" + searchID + "'");
						
						while(rs.next()){
							txtID.setText(rs.getString(1));
							txtFname.setText(rs.getString(2));
							txtMname.setText(rs.getString(3));
							txtLname.setText(rs.getString(4));
							
							txtGender.setText(rs.getString(5));
								String gen=txtGender.getText();
								if(gen.equals("male")){
									rdbtnMale.setSelected(true);
								}
								else{
									rdbtnFemale.setSelected(true);
								}
							
							txtAddress.setText(rs.getString(6));
							txtBmon.setText(rs.getString(7));
							txtBday.setText(rs.getString(8));
							txtByear.setText(rs.getString(9));
							
	
							}
						st.close();
	
	
	
	
			}catch(SQLException s){
			JOptionPane.showMessageDialog(null,"Unable to search!.","Student Information System",JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
			}
	*/
		btnSearchID.setIcon(new ImageIcon("STUSEARCH.png"));
	
		btnSearchID.setBounds(24, 136, 89, 23);
		frame.add(btnSearchID);
		btnSearchID.addActionListener(this);
		btnSave.setIcon(new ImageIcon("STUSAVE.png"));
		
	
		btnSave.setBounds(127, 136, 89, 23);
		frame.add(btnSave);
		btnSave.addActionListener(this);
		btnBack.setIcon(new ImageIcon("STUBACK.png"));
	
		btnBack.setBounds(424, 136, 89, 23);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		btnUpdate.setIcon(new ImageIcon("STUUPDATE.png"));
		
		
		btnUpdate.setBounds(226, 136, 89, 23);
		frame.add(btnUpdate);
		btnUpdate.addActionListener(this);
		btnDelete.setIcon(new ImageIcon("STUDELETE.png"));
		
	
		btnDelete.setBounds(325, 136, 89, 23);
		frame.add(btnDelete);
		btnDelete.addActionListener(this);
		
	//radio button
	
	
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setForeground(Color.BLUE);
		rdbtnMale.setFont(new Font("Myriad Hebrew", Font.BOLD, 12));
		rdbtnMale.setBounds(381, 91, 55, 23);
		frame.add(rdbtnMale);
		rdbtnMale.addItemListener(this);
		
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Myriad Hebrew", Font.BOLD, 12));
		rdbtnFemale.setForeground(new Color(255, 102, 204));
		rdbtnFemale.setBounds(433, 91, 80, 23);
		frame.add(rdbtnFemale);
		rdbtnFemale.addItemListener(this);
		rdbtnMale.setSelected(true);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("MAIN BACK.png"));
		lblNewLabel.setBounds(-21, 0, 619, 195);
		getContentPane().add(lblNewLabel);
    	
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
	
		if(source == btnSave){
			
		
			try{
					
						String ID		=txtID.getText();
						String fname	=txtFname.getText();
						String mname	=txtMname.getText();
						String lname	=txtLname.getText();
						String gender	=txtGender.getText();
						String address	=txtAddress.getText();
						String bmon		=txtBmon.getText();
    					String bday		=txtBday.getText();
    					String byear	=txtByear.getText();
						
				if((ID.length()==0 || fname.length()==0 || mname.length()==0 || lname.length()==0 ||address.length()==0)|| bmon.length()==0 || bday.length()==0 || byear.length()==0 ){			
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    				}		
				else if(!ID.equals("") || !fname.equals("") || !mname.equals("") || !lname.equals("") || !gender.equals("") || !address.equals("")|| !bmon.equals("") || !bday.equals("") || !byear.equals("")  ){			
					st= cn.createStatement();
					
					ps=cn.prepareStatement("INSERT INTO Student_Information" + " (ID, Fname, Mname, Lname, Gender, Address, Bmonth, Bday, Byear )" + " VALUES(?,?,?,?,?,?,?,?,?)");
    				
    				ps.setString(1,txtID.getText());
    				ps.setString(2,txtFname.getText());
    				ps.setString(3,txtMname.getText());
					ps.setString(4,txtLname.getText());
					ps.setString(5,txtGender.getText());
					ps.setString(6,txtAddress.getText());
					ps.setString(7,txtBmon.getText());
					ps.setString(8,txtBday.getText());
					ps.setString(9,txtByear.getText());
    				
    				ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"New account has been successfully added.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
					txtID.requestFocus(true);
					st.close();
    				
				}
			
					else{
							JOptionPane.showMessageDialog(null,"Please Fill Up The Empty Fields","Warning",JOptionPane.WARNING_MESSAGE);	
					}
			//end try
			}catch(SQLException sqlEx){
					sqlEx.printStackTrace();
					JOptionPane.showMessageDialog(null,"Unable to save!.","Student Information System",JOptionPane.ERROR_MESSAGE);}	
			txtID.setText("");
			txtFname.setText("");
			txtMname.setText("");
			txtLname.setText("");
			txtGender.setText("");
			txtAge.setText("");
			txtAddress.setText("");
			txtBmon.setText("");
			txtBday.setText("");
			txtByear.setText("");
				
			
				
		}//end of save
		
		if(source==btnSearchID){
			try{
					String searchID ="";
					int tmp=0;
					
					searchID = JOptionPane.showInputDialog(null,"Enter ID to search.","Student Information System",JOptionPane.QUESTION_MESSAGE);
					st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM Student_Information WHERE ID = '" + searchID + "'");
						
						while(rs.next()){
							txtID.setText(rs.getString(1));
							txtFname.setText(rs.getString(2));
							txtMname.setText(rs.getString(3));
							txtLname.setText(rs.getString(4));
							
							txtGender.setText(rs.getString(5));
								String gen=txtGender.getText();
								if(gen.equals("male")){
									rdbtnMale.setSelected(true);
								}
								else{
									rdbtnFemale.setSelected(true);
								}
							
							txtAddress.setText(rs.getString(6));
							txtBmon.setText(rs.getString(7));
							txtBday.setText(rs.getString(8));
							txtByear.setText(rs.getString(9));
							
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
			
		}//end of search ID
		
		if(source==btnUpdate){
			
			try{
				String ID		=txtID.getText();
				String fname	=txtFname.getText();
				String mname	=txtMname.getText();
				String lname	=txtLname.getText();
				String gender	=txtGender.getText();
				String address	=txtAddress.getText();
				String bmon		=txtBmon.getText();
    			String bday		=txtBday.getText();
    			String byear	=txtByear.getText();
    			
    		if(!ID.equals("") || !fname.equals("") || !mname.equals("") || !lname.equals("") || !gender.equals("") || !address.equals("")|| !bmon.equals("") || !bday.equals("") || !byear.equals("")  ){			
    		st= cn.createStatement();
    		PreparedStatement ps = cn.prepareStatement
				("UPDATE Student_Information SET Fname = '" + txtFname.getText() + 
				"',Mname = '" + txtMname.getText() + 
				"',Lname = '" + txtLname.getText()+ 
				"',Gender= '" +txtGender.getText() +  
				"',Address = '" + txtAddress.getText() +
				"',Bmonth = '" + txtBmon.getText() +
				"',Bday = '" + txtBday.getText() +
				"',Byear = '" + txtByear.getText() +
				"'WHERE ID = '" + txtID.getText()+ "'");
    		ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Account has been successfully updated.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
			txtID.requestFocus(true);
			st.close();
			
    		}
			}catch (SQLException y){
			JOptionPane.showMessageDialog(null,"Unable to update!.","Student Information System",JOptionPane.ERROR_MESSAGE);
			}
			txtID.setText("");
			txtFname.setText("");
			txtMname.setText("");
			txtLname.setText("");
			txtGender.setText("");
			txtAge.setText("");
			txtAddress.setText("");
			txtBmon.setText("");
			txtBday.setText("");
			txtByear.setText("");	
		}//end of  btn update
		
		if(source==btnDelete){
			
			txtID.setText("");
			txtFname.setText("");
			txtMname.setText("");
			txtLname.setText("");
			txtGender.setText("");
			txtAge.setText("");
			txtAddress.setText("");
			txtBmon.setText("");
			txtBday.setText("");
			txtByear.setText("");
			
			
			if(!txtID.getText().equalsIgnoreCase("")){
    	 	
    	 		try{
						PreparedStatement ps = cn.prepareStatement("DELETE FROM Student_Information WHERE ID ='"+ txtID.getText() + "'");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Account has been successfully deleted.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
						st.close();
					}catch(SQLException s){
					JOptionPane.showMessageDialog(null,"Unable to delete!.","Student Information System",JOptionPane.ERROR_MESSAGE);
					
			}
    	 }
		}//end of btn delete
		if(source==btnBack){
			TransactionBTN pane = new TransactionBTN();
	
			pane.setSize( 475, 260);
			pane.setTitle("Transactions");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
			
		}
    
    }
    
    
    
    
    
    //Item Event Listener
	public void itemStateChanged(ItemEvent i){
    		
    		if(i.getSource().equals(rdbtnFemale)){
    			txtGender.setText("female");
    		}
    		
    		if(i.getSource().equals(rdbtnMale)){
    			txtGender.setText("male");
    		}
    
    }
    public void valueChanged(ListSelectionEvent l){
			
	}
    
    
}