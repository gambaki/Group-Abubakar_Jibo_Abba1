//NOt to be used

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Enrollment extends JFrame implements ActionListener , ItemListener, ListSelectionListener{
Container frame = getContentPane();	
//connection
Connection cn;
Statement st;
PreparedStatement ps;
//holder
JTextField holder = new JTextField();
String [] listSta = {"Select Level","1", "2", "3", "4", "5", "6"};


//combo box
JComboBox cbGradelvl = new JComboBox(listSta);
JComboBox cbSection = new JComboBox();



//labels
		JLabel lblStudentId = new JLabel("");
		JLabel lblFname = new JLabel("");				
		JLabel lblMname = new JLabel("");
		JLabel lblLname = new JLabel("");
		JLabel lblGender = new JLabel("");
		JLabel lblAge = new JLabel("");
		JLabel lblBirthday = new JLabel("");
		JLabel lblAddress = new JLabel("");
		JLabel lblSection = new JLabel("");
		JLabel lblGrade = new JLabel("");
		JLabel lblTuition = new JLabel("");
		
//birthday labels
		JLabel lblMonth = new JLabel("");
		JLabel lblDay = new JLabel("");
		JLabel lblYear = new JLabel("");
		
//txtFields
		JTextField 	txtID = new JTextField();
		JTextField 	txtFname = new JTextField();
		JTextField 	txtMname = new JTextField();
		JTextField 	txtLname = new JTextField();
		JTextField txtGender = new JTextField();
		JTextField txtAge = new JTextField();
		JTextField txtAddress = new JTextField();
		JTextField txtTuition = new JTextField();
	//birthday textfields
		JTextField 	txtBmon = new JTextField();
		JTextField 	txtBday = new JTextField();
		JTextField 	txtByear = new JTextField();

//buttons
		JButton btnSearchID = new JButton("");
		JButton btnEnroll = new JButton("");
		JButton btnBack = new JButton("");
	//	JButton btnUpdate = new JButton("Update");
	//	JButton btnDelete = new JButton("Delete");
		
//radio button
	 ButtonGroup buttonGroup = new ButtonGroup();
	 JRadioButton rdbtnMale = new JRadioButton("Male");
	 JRadioButton rdbtnFemale = new JRadioButton("Female");

	public static void main (String args[]){
	Enrollment pane = new Enrollment();
	
	pane.setSize(770, 230);
	pane.setTitle("Enroll");
	pane.setResizable(false);
	pane.setVisible(true);
	}

    public Enrollment() {
    	frame.setLayout(null);
    	
    	//set disabled
    	txtID.setEnabled(false);
    	txtFname.setEnabled(false);
    	txtMname.setEnabled(false);
    	txtLname.setEnabled(false);
    	txtGender.setEnabled(false);
    	txtAge.setEnabled(false);
    	txtAddress.setEnabled(false);
    	txtBmon.setEnabled(false);
    	txtByear.setEnabled(false);
    	
    	
    	
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
    
		lblStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentId.setBounds(29, 27, 150, 14);
		frame.add(lblStudentId);
		lblStudentId.setIcon(new ImageIcon("STUDENT ID.png"));
		
		lblFname.setIcon(new ImageIcon("FIRST NAME.png"));
		lblFname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFname.setBounds(3, 55, 176, 14);
		frame.add(lblFname);
		
		lblMname.setIcon(new ImageIcon("MIDDLE NAME.png"));
		lblMname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMname.setBounds(13, 83, 152, 14);
		frame.add(lblMname);
		
		lblLname.setIcon(new ImageIcon("LAST NAME.png"));
		lblLname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLname.setBounds(29, 111, 150, 14);
		frame.add(lblLname);
		
		
		lblGender.setIcon(new ImageIcon("GENDER.png"));
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(39, 150, 83, 14);
		frame.add(lblGender);
		
		
		lblBirthday.setIcon(new ImageIcon("BDAY.png"));
		lblBirthday.setBounds(322,44,83,14);
		frame.add(lblBirthday);
		
			lblMonth.setIcon(new ImageIcon("MONTH.png"));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(340, 25, 115, 14);
		frame.add(lblMonth);
		lblDay.setIcon(new ImageIcon("DAY.png"));
		
		
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(385, 25, 115, 14);
		frame.add(lblDay);
		lblYear.setIcon(new ImageIcon("YEAR.png"));
		
		
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(436, 25, 110, 14);
		frame.add(lblYear);
		
		lblAddress.setIcon(new ImageIcon("ADDRESS.png"));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(310, 71, 83, 14);
		frame.add(lblAddress);
		
		//textFields
		txtBmon.setBounds(403, 44, 41, 20);
		txtBmon.setColumns(10);
		frame.add(txtBmon);
		txtBmon.setEnabled(false);
	
	
		txtBday.setColumns(10);
		txtBday.setBounds(456, 44, 41, 20);
		frame.add(txtBday);
		txtBday.setEnabled(false);
	
		txtByear.setColumns(10);
		txtByear.setBounds(507, 44, 41, 20);
		frame.add(txtByear);
		txtByear.setEnabled(false);
		
		//textFields
    	
		txtID.setBounds(133, 24, 145, 20);
		txtID.setColumns(10);
		frame.add(txtID);
		txtID.setEnabled(false);
	
	
		txtFname.setColumns(10);
		txtFname.setBounds(133, 52, 145, 20);
		frame.add(txtFname);
		txtFname.setEnabled(false);
	
		txtMname.setColumns(10);
		txtMname.setBounds(133, 80, 145, 20);
		frame.add(txtMname);
		txtMname.setEnabled(false);
		
	
		txtLname.setColumns(10);
		txtLname.setBounds(133, 108, 145, 20);
		frame.add(txtLname);
		txtLname.setEnabled(false);
		
//gender text box	
	//	txtGender.setColumns(10);
	//	txtGender.setBounds(184, 163, 145, 20);
	//	frame.add(txtGender);
		
	
//txtAge.setColumns(10);
//		txtAge.setBounds(184, 188, 145, 20);
//		frame.add(txtAge);
		
	
		txtAddress.setColumns(10);
		txtAddress.setBounds(403, 69, 145, 20);
		frame.add(txtAddress);
		txtAddress.setEnabled(false);
		
		txtTuition.setHorizontalAlignment(SwingConstants.CENTER);
		txtTuition.setBounds(404, 167, 89, 23);
		frame.add(txtTuition);
		txtTuition.setEnabled(false);
	
		//buttons

		btnSearchID.setIcon(new ImageIcon("STUSEARCH.png"));
				btnSearchID.setBounds(633, 36, 89, 23);
		frame.add(btnSearchID);
		btnSearchID.addActionListener(this);
		btnEnroll.setIcon(new ImageIcon("ENROLL.png"));
		
	
		btnEnroll.setBounds(633, 92, 89, 23);
		frame.add(btnEnroll);
		btnEnroll.addActionListener(this);
		btnEnroll.setEnabled(false);
		btnBack.setIcon(new ImageIcon("STUBACK.png"));
	
		btnBack.setBounds(633, 146, 89, 23);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		
		
	//	btnUpdate.setBounds(197, 395, 89, 23);
	//	frame.add(btnUpdate);
	//	btnUpdate.addActionListener(this);
		
	
	//	btnDelete.setBounds(197, 430, 89, 23);
	//	frame.add(btnDelete);
	//	btnDelete.addActionListener(this);
		
	//radio button

		buttonGroup.add(rdbtnMale);
		rdbtnMale.setForeground(Color.BLUE);
		rdbtnMale.setFont(new Font("Myriad Hebrew", Font.BOLD, 11));
		rdbtnMale.setBounds(128, 146, 55, 23);
		frame.add(rdbtnMale);
	//	rdbtnMale.addItemListener(this);
		rdbtnMale.setEnabled(false);
		
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setForeground(new Color(255, 102, 153));
		rdbtnFemale.setFont(new Font("Myriad Hebrew", Font.BOLD, 11));
		rdbtnFemale.setBounds(180, 146, 80, 23);
		frame.add(rdbtnFemale);
		rdbtnFemale.setEnabled(false);
	//	rdbtnFemale.addItemListener(this);
	//	rdbtnMale.setSelected(true);
		
	//combo box
		cbSection.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbSection.setBounds(404, 129, 100, 26);
		frame.add(cbSection);

		
		cbGradelvl.setFont(new Font("Tahoma", Font.BOLD, 12));
	//	cbGradelvl.setModel(new DefaultComboBoxModel(new String[] {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6"}));
		cbGradelvl.setBounds(404, 94, 100, 26);
		frame.add(cbGradelvl);
		cbGradelvl.setSelectedIndex(0);
		
			cbGradelvl.addActionListener(new ActionListener(){
   		
    		public void actionPerformed(ActionEvent e){
    			
    			 int itemCount = cbSection.getItemCount();

    			for(int i=0;i<itemCount;i++){
    				
        		cbSection.removeItemAt(0);
        		
    			}
    		//	txtSection.setText(listSta[cbGradelvl.getSelectedIndex()]);
    			
    			try{ 
    					btnEnroll.setEnabled(true);
    								
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("ENROLLBACK.png"));
		lblNewLabel.setBounds(0, 0, 761, 216);
		getContentPane().add(lblNewLabel);
    	
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
	
		if(source == btnEnroll){
		
		
		
			try{
					
				
				
					/*	String ID		=txtID.getText();
						String fname	=txtFname.getText();
						String mname	=txtMname.getText();
						String lname	=txtLname.getText();
						String gender	=txtGender.getText();
						String address	=txtAddress.getText();
						String bmon		=txtBmon.getText();
    					String bday		=txtBday.getText();
    					String byear	=txtByear.getText();*/
    					String grade	=listSta[cbGradelvl.getSelectedIndex()];
    					String section	=cbSection.getSelectedItem().toString();
					
				/*if((ID.length()==0 || fname.length()==0 || mname.length()==0 || lname.length()==0 ||address.length()==0)|| bmon.length()==0 || bday.length()==0 || byear.length()==0 ){			
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    				}*/
    					
				//else if(!ID.equals("") || !fname.equals("") || !mname.equals("") || !lname.equals("") || !gender.equals("") || !address.equals("")|| !bmon.equals("") || !bday.equals("") || !byear.equals("")  ){			
					st= cn.createStatement();
					
					ps=cn.prepareStatement("INSERT INTO Enrollment" + " (ID, Fname, Mname, Lname, Gender, Bmonth, Bday, Byear, Address, Grade, Section,Tuition )" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
    				
    				ps.setString(1,txtID.getText());
    				ps.setString(2,txtFname.getText());
    				ps.setString(3,txtMname.getText());
					ps.setString(4,txtLname.getText());
					ps.setString(5,txtGender.getText());
					ps.setString(6,txtBmon.getText());
					ps.setString(7,txtBday.getText());
					ps.setString(8,txtByear.getText());
    				ps.setString(9,txtAddress.getText());
    				ps.setString(10,listSta[cbGradelvl.getSelectedIndex()]);
    				ps.setString(11,cbSection.getSelectedItem().toString());
    				ps.setString(12,txtTuition.getText());
    				
    				
    				ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Student Successfully Enrolled.","Enrollment Form",JOptionPane.INFORMATION_MESSAGE);
					txtID.requestFocus(true);
					st.close();
    				
				//}
				/*if (listSta[cbGradelvl.getSelectedIndex()].equals("Select Level")){
    						JOptionPane.showMessageDialog(null,"Please select Grade Level","WARNING",JOptionPane.WARNING_MESSAGE);
    				
    				}	
			
					else{
							JOptionPane.showMessageDialog(null,"Please Fill Up The Empty Fields","Warning",JOptionPane.WARNING_MESSAGE);	
					}
			//end try*/
					
			
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
					int tmp= 0;
					
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
							txtTuition.setText("3000");
						
				
							}
						st.close();
						if (tmp==0){
							JOptionPane.showMessageDialog(null,"No record found!!.","Student Information System",JOptionPane.INFORMATION_MESSAGE);	
						}
			
			
			}catch(SQLException s){
			JOptionPane.showMessageDialog(null,"Unable to search!.","Student Information System",JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
			}
			
		}//end of search ID
		/*
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
				("UPDATE Enrollment SET Fname = '" + txtFname.getText() + 
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
		}//end of  btn update 
		
		if(source==btnDelete){
			if(!txtID.getText().equalsIgnoreCase("")){
    	 	
    	 		try{
						PreparedStatement ps = cn.prepareStatement("DELETE FROM Enrollment WHERE ID ='"+ txtID.getText() + "'");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Account has been successfully deleted.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
						st.close();
					}catch(SQLException s){
					JOptionPane.showMessageDialog(null,"Unable to delete!.","Student Information System",JOptionPane.ERROR_MESSAGE);
					
			}
    	 }
		}//end of btn delete */
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