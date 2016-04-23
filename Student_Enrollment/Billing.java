import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Billing extends JFrame implements ActionListener{
Container frame = getContentPane();	
//connection
Connection cn;
Statement st;
PreparedStatement ps;

static int bal2;


//buttons
		JButton btnSearch = new JButton();
		JButton btnPay = new JButton();
		JButton btnBack = new JButton();
		JButton btnUpdate = new JButton();
		
//labels
		JLabel lblStudentId = new JLabel();
		JLabel lblFname = new JLabel();
		JLabel lblMname = new JLabel();
		JLabel lblLname = new JLabel();
		JLabel lblBillingInformation = new JLabel();
		JLabel lblBalance = new JLabel();
		JLabel lblPayment = new JLabel();
		JLabel lblChange = new JLabel();
		
//txtFields
		JTextField txtID = new JTextField();
		JTextField 	txtFname = new JTextField();
		JTextField 	txtMname = new JTextField();
		JTextField 	txtLname = new JTextField();
		JTextField 	txtBalance = new JTextField();
		JTextField 	txtPayment = new JTextField();
		JTextField 	txtChange = new JTextField();
	
	
	public static void main(String args[]){
	Billing pane = new Billing();
	
	pane.setSize(465,265 );
	pane.setTitle("Billing Form");
	pane.setResizable(false);
	pane.setVisible(true);
	}
	

    public Billing() {
    	frame.setLayout(null);
    		txtID.setEnabled(false);
    		txtFname.setEnabled(false);
			txtMname.setEnabled(false);
			txtLname.setEnabled(false);
			txtChange.setEnabled(false);
			txtBalance.setEnabled(false);
    	
    	
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
    	lblStudentId.setIcon(new ImageIcon("STUDENT ID.png"));
		lblStudentId.setBounds(12, 22, 98, 14);
		frame.add(lblStudentId);
		
		lblFname.setBounds(0, 66, 98, 14);
		frame.add(lblFname);
		lblFname.setIcon(new ImageIcon("FIRST NAME.png"));
		
		lblMname.setBounds(0, 119, 116, 14);
		frame.add(lblMname);
		lblMname.setIcon(new ImageIcon("MIDDLE NAME.png"));
		
		lblLname.setBounds(0, 165, 98, 14);
		frame.add(lblLname);
		lblLname.setIcon(new ImageIcon("LAST NAME.png"));
		
		
		lblBillingInformation.setIcon(new ImageIcon("BILLING INFOO.png"));
		lblBillingInformation.setBounds(166, 66, 200, 14);
		frame.add(lblBillingInformation);
		
		lblBalance.setIcon(new ImageIcon("BALANCE.png"));
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(136, 97, 150, 14);
		frame.add(lblBalance);
		
		lblPayment.setIcon(new ImageIcon("PAYMENT.png"));
		lblPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayment.setBounds(136, 140, 152, 14);
		frame.add(lblPayment);
		
		lblChange.setIcon(new ImageIcon("CHANGE.png"));
		lblChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChange.setBounds(118, 188, 170, 14);
		frame.add(lblChange);
		//txtFields
		
		txtID.setColumns(10);
		txtID.setBounds(113, 16, 132, 20);
		frame.add(txtID);
		
		
		txtFname.setColumns(10);
		txtFname.setBounds(10, 83, 86, 20);
		frame.add(txtFname);
		
	
		txtMname.setColumns(10);
		txtMname.setBounds(10, 134, 86, 20);
		frame.add(txtMname);
		
		
		txtLname.setColumns(10);
		txtLname.setBounds(10, 182, 86, 20);
		frame.add(txtLname);
		
	
		txtBalance.setBounds(223, 91, 101, 20);
		txtBalance.setColumns(10);
		frame.add(txtBalance);
		
	
		txtPayment.setColumns(10);
		txtPayment.setBounds(223, 134, 101, 20);
		frame.add(txtPayment);
		
	
		txtChange.setColumns(10);
		txtChange.setBounds(223, 182, 101, 20);
		frame.add(txtChange);
		btnSearch.setIcon(new ImageIcon("Search ID.png"));
		
		//buttons
		
	
		btnSearch.setBounds(345, 22, 107, 39);
		frame.add(btnSearch);
		btnSearch.addActionListener(this);
		btnPay.setIcon(new ImageIcon("PAY.png"));
		
		btnPay.setBounds(345, 75, 107, 39);
		frame.add(btnPay);
		btnPay.addActionListener(this);
		btnUpdate.setIcon(new ImageIcon("UPDATE.png"));
		
		btnUpdate.setBounds(345,123,107,39);
		frame.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		
		btnBack.setIcon(new ImageIcon("BILLBACK.png"));
		btnBack.setBounds(345, 171, 107, 39);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		
		//background
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("BILLINGBACK.png"));
		lblNewLabel.setBounds(0, 0, 462, 241);
		frame.add(lblNewLabel);
    	
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
		if(source==btnBack){
		TransactionBTN pane = new TransactionBTN();
	
		pane.setSize( 475, 260);
		pane.setTitle("Transactions");
		pane.setResizable(false);
		pane.setVisible(true);
		pane.setLocation(400,250);
		dispose();
		}
		
		if(source==btnSearch){
			try{
					String searchID ="";
					int tmp= 0;
					
					searchID = JOptionPane.showInputDialog(null,"Enter ID to search.","Student Information System",JOptionPane.QUESTION_MESSAGE);
					st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM Enrollment WHERE ID = '" + searchID + "'");
						
						while(rs.next()){
							txtID.setText(rs.getString(1));
							txtFname.setText(rs.getString(2));
							txtMname.setText(rs.getString(3));
							txtLname.setText(rs.getString(4));
							txtBalance.setText(rs.getString(12));
							
							tmp=1;								
						}
						
						if (tmp==0){
							JOptionPane.showMessageDialog(null,"No record found!!.","Student Information System",JOptionPane.INFORMATION_MESSAGE);	
						}
						
					st.close();
							
				
				
			}catch(SQLException s){
			JOptionPane.showMessageDialog(null,"Unable to search!.","Billing",JOptionPane.ERROR_MESSAGE);
			System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
			}
		}
		
		if(source == btnPay){
				try{
					String searchID =txtID.getText();
					String bal = txtBalance.getText();
					String payment = txtPayment.getText();
								
			//		searchID = JOptionPane.showInputDialog(null,"Enter ID to search.","Student Information System",JOptionPane.QUESTION_MESSAGE);
					st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM Enrollment WHERE ID = '" + searchID + "'");
					
					int bal1 = Integer.parseInt(bal);
					int pay1 = Integer.parseInt(payment);
					
					
			if((pay1>=3001)){
	    		JOptionPane.showMessageDialog(null, "Invalid!, Payment must be less than 3000", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
	    				}
				else{	
					bal2=bal1-pay1;
					
				if(bal2<0){
				JOptionPane.showMessageDialog(null, "Sorry!, Payment must be equal to your Balance", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
					}
					else{
					
					txtChange.setText("" +bal2);			
					st.close();
					}
				}}catch(SQLException s){
				JOptionPane.showMessageDialog(null,"Unable to search!.","Billing",JOptionPane.ERROR_MESSAGE);
				System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
				}
					if(bal2==0){
					try{
					
						PreparedStatement ps = cn.prepareStatement("DELETE * FROM Enrollment WHERE ID ='"+ txtID.getText() + "'");
						ps.executeUpdate();
						}catch(SQLException s){
					JOptionPane.showMessageDialog(null,"Unable to delete!.","Student Information System",JOptionPane.ERROR_MESSAGE);				
					}
    	 }
							
		}
		
		if(source==btnUpdate){
			try{
					st= cn.createStatement();		
					ps = cn.prepareStatement("UPDATE Enrollment SET ID = '" + txtID.getText() + "',Fname = '" + txtFname.getText() + "',Lname = '" + txtLname.getText() + "',Tuition = '" + txtChange.getText() +"'WHERE ID = '" + txtID.getText() + "'");
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"record has been successfully updated."," INFORMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);
					
				
					
					st.close();
				
				
				
			}catch(SQLException upD){
					System.out.print("SQL statement is not executed!");
			}
			
					txtID.setText("");
					txtFname.setText("");
					txtMname.setText("");
					txtLname.setText("");
					txtChange.setText("");
					txtBalance.setText("");
					txtPayment.setText("");
					
		}
		
		
		

    }
    
    
    
    
    
}