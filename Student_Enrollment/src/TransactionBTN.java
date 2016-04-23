import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TransactionBTN extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = -77359182510879464L;

Container frame = getContentPane();
//connection

//buttons
JButton btnStudentInfo = new JButton();
JButton btnEnrollment = new JButton();
JButton btnBilling = new JButton();
JButton btnLogout = new JButton();
JButton btnBack = new JButton();



	public static void main(String args[]){
	TransactionBTN pane = new TransactionBTN();
	pane.setLocation(400,200);
	pane.setSize( 475, 260);
	pane.setTitle("Transactions");
	pane.setResizable(false);
	pane.setVisible(true);
	}	

    public TransactionBTN() {
    	frame.setLayout(null);
    	
    	
    	
    
		btnStudentInfo.setIcon(new ImageIcon("STUDENT INFORMATION.png"));
		btnStudentInfo.setFont(new Font("Garamond", Font.BOLD, 17));
		btnStudentInfo.setBounds(20, 34, 180, 46);
		frame.add(btnStudentInfo);
		btnStudentInfo.addActionListener(this);
		
		btnEnrollment.setIcon(new ImageIcon("ENROLLMENT.png"));
		btnEnrollment.setFont(new Font("Garamond", Font.BOLD, 17));
		btnEnrollment.setBounds(20, 92, 180, 46);
		frame.add(btnEnrollment);
		btnEnrollment.addActionListener(this);
		
		
		btnBilling.setIcon(new ImageIcon("BILLINGT.png"));
		btnBilling.setFont(new Font("Garamond", Font.BOLD, 17));
		btnBilling.setBounds(20, 149, 180, 46);
		frame.add(btnBilling);
		btnBilling.addActionListener(this);
		
		

		btnLogout.setIcon(new ImageIcon("LOG OUT.png"));
		btnLogout.setBounds(336, 11, 102, 28);
		btnLogout.addActionListener(this);
		
		btnBack.setIcon(new ImageIcon("BACK.png"));
		btnBack.setBounds(336, 50, 102, 28);
		frame.add(btnBack);
    	btnBack.addActionListener(this);
    	
    	
    	//background
    	JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("TRANS BACK.png"));
		lblNewLabel.setBounds(0, 0, 467, 234);
		frame.add(lblNewLabel);
    }
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
	
		if(source==btnStudentInfo){
			Student_Information pane = new Student_Information();
	
			pane.setSize(565, 230);
			pane.setTitle("Student Information");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250); 
			dispose();
			
		}
		
		if(source==btnEnrollment){
			Enrollment pane = new Enrollment();
	
			pane.setSize(770, 230);
			pane.setTitle("Enrollment");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
			
		}
		
		if(source==btnBilling){
			Billing pane = new Billing();
	
			pane.setSize(465,265 );
			pane.setTitle("Billing Form");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
			
		}
		
		
		if(source==btnLogout){
			Login pane = new Login();
	
			pane.setSize(400, 300);
			pane.setTitle("Login");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
			
		}
		
		if(source==btnBack){
			main_menu pane = new main_menu();
	
			pane.setSize( 565, 220);
			pane.setTitle("Main Menu");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
			
		}
    }
    
    
    
}