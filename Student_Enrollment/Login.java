
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
Container frame = getContentPane();	
//connection
Connection cn;
Statement st;
PreparedStatement ps;

//labels
JLabel lblUsername = new JLabel();
JLabel lblPassword = new JLabel();

//txtField
JTextField txtUsername = new JTextField();
JPasswordField txtPassword = new JPasswordField();

//buttons
JButton btnLogin = new JButton();
JButton btnRegister = new JButton();
	 
	
	
	public static void main (String args[]){
				
	Login pane = new Login();
	pane.setSize(393, 250);
	pane.setTitle("Login");
	pane.setResizable(false);
	pane.setVisible(true);
	pane.setLocation(500,300);
		
	}

    public Login() {
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
    	lblUsername.setIcon(new ImageIcon("USERNAME.png"));
		lblUsername.setBounds(69, 47, 80, 14);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.add(lblUsername);
		
		lblPassword.setIcon(new ImageIcon("PASSWORD.png"));
		lblPassword.setBounds(69, 89, 80, 14);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.add(lblPassword);
		
		//textfields
		txtUsername.setBounds(177, 47, 124, 20);
		txtUsername.setColumns(10);
		frame.add(txtUsername);
		
		txtPassword.setColumns(10);
		txtPassword.setBounds(177, 89, 124, 20);
		frame.add(txtPassword);
		
		//buttons
	
		btnLogin.setIcon(new ImageIcon("LOGIN BUTTON.png"));
		btnLogin.setBounds(69, 148, 89, 23);
		frame.add(btnLogin);
		btnLogin.addActionListener(this);
		
	
		btnRegister.setIcon(new ImageIcon("REGISTER BUTTON.png"));
		btnRegister.setBounds(209, 148, 89, 23);
		frame.add(btnRegister);
		btnRegister.addActionListener(this);
		
		
		//background
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-22, 11, 534, 261);
		lblNewLabel.setIcon(new ImageIcon("Bckgrnd.png"));
		frame.add(lblNewLabel);
		
    		
    	
    }
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
	
		if(source==btnLogin){
			try{
				String str1=txtUsername.getText();
				String str2=txtPassword.getText();
				if((str1.length()==0 || str2.length()==0)){
    					JOptionPane.showMessageDialog(null,"Connot be Process","WARNING",JOptionPane.WARNING_MESSAGE);
    				}
    				else{
				st=cn.createStatement();
				String strUser="";
				String strPass="";
				
				ResultSet rs=st.executeQuery("SELECT * FROM Login WHERE Username='"+str1+"'");
				while(rs.next()){
					strUser=rs.getString(1);
					strPass=rs.getString(2);
				}
				

				
				st.close();
			
				if(strUser.equals(str1)){
					if(strPass.equals(str2)){
						
					
    					
						JOptionPane.showMessageDialog(null,"Welcome "+txtUsername.getText(),"Welcome",JOptionPane.INFORMATION_MESSAGE);
						
						main_menu pane = new main_menu();
	
						pane.setSize( 565, 220);
						pane.setTitle("Main Menu");
						pane.setResizable(false);
						pane.setVisible(true);
						pane.setLocation(400,250);
						dispose();
						
					
					}else{
						JOptionPane.showMessageDialog(null,"Username found but the password is incorrect!","Security Pass",JOptionPane.WARNING_MESSAGE);
						txtPassword.requestFocus(true);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Username is incorrect!","Security Pass",JOptionPane.WARNING_MESSAGE);
					txtUsername.requestFocus(true);
				}
    				}	
			}catch(SQLException w){
			}
		}
		
		if(source==btnRegister){
			
			Register pane = new Register();
				pane.setSize(370,400);
				pane.setVisible(true);
				pane.setTitle("Register Account");
				pane.setResizable(false);
				pane.setLocation(400,250);
				dispose();
		}
    
    }
    
    
}