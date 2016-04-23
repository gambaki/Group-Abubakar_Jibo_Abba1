import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class main_menu extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = -8123555168684908113L;
Container frame = getContentPane();
//connection
Connection cn;
Statement st;
PreparedStatement ps;


//labels
JLabel lblMainMenu = new JLabel();

//buttons
JButton btnTransactions = new JButton();
JButton btnMaintenance = new JButton();
JButton btnLogout = new JButton();

	public static void main (String args[]){
	main_menu pane = new main_menu();
	pane.setLocation(400,250);
	pane.setSize( 565, 220);
	pane.setTitle("Main Menu");
	pane.setResizable(false);
	pane.setVisible(true);
	}
	
    public main_menu() {
    	frame.setLayout(null);
    	
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
    	lblMainMenu.setIcon(new ImageIcon("MAIN MENU.png"));
		lblMainMenu.setBounds(213, 11, 287, 55);
		lblMainMenu.setFont(new Font("Goudy Stout", Font.PLAIN, 25));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(lblMainMenu);
		
		//buttons
		
		btnTransactions.setIcon(new ImageIcon("TRANSACTIONS.png"));
		btnTransactions.setBounds(219, 90, 129, 40);
		frame.add(btnTransactions);
		btnTransactions.addActionListener(this);
		
		btnMaintenance.setIcon(new ImageIcon("MAINTENANCE.png"));
		btnMaintenance.setBounds(391, 90, 129, 40);
		frame.add(btnMaintenance);
		btnMaintenance.addActionListener(this);
		
	
		btnLogout.setIcon(new ImageIcon("LOG OUT.png"));
		btnLogout.setBounds(450, 158, 102, 28);
		frame.add(btnLogout);
		btnLogout.addActionListener(this);
		
		//background
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("MAIN BACK.png"));
		lblNewLabel_1.setBounds(0, 0, 562, 197);
		frame.add(lblNewLabel_1);
    	
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
    	if(source==btnTransactions){
    		
    		dispose();
    		
    	}
    	if(source==btnMaintenance){
    		MaintenanceBTN pane = new MaintenanceBTN();
	
			pane.setSize(245, 270);
			pane.setTitle("Maintenance");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
    	}
    	if(source==btnLogout){
    		Login pane = new Login();
	
			pane.setSize(400, 300);
			pane.setTitle("Student Information");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
    	}
    	if(source==btnTransactions){
    		TransactionBTN pane = new TransactionBTN();
	
			pane.setSize( 475, 260);
			pane.setTitle("Transactions");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,200);
			dispose();
    	}
    
    
    }
    
    
}