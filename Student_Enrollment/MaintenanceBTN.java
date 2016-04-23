import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MaintenanceBTN extends JFrame implements ActionListener{
Container frame = getContentPane();
//connection
Connection cn;
Statement st;
PreparedStatement ps;



//labels
JLabel lblMaintenance = new JLabel();

//buttons
JButton btnSections = new JButton();
JButton btnUserSettings = new JButton();
JButton btnBack = new JButton("");


	public static void main(String args[]){
	MaintenanceBTN pane = new MaintenanceBTN();
	pane.setLocation(400,250);
	pane.setSize(245, 270);
	pane.setTitle("Maintenance");
	pane.setResizable(false);
	pane.setVisible(true);
		
	}

    public MaintenanceBTN() {
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
		lblMaintenance.setIcon(new ImageIcon("TXTMAIN.png"));
		lblMaintenance.setBounds(34, 11, 174, 40);
		lblMaintenance.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(lblMaintenance);
		
		
		//buttons
	
		btnSections.setIcon(new ImageIcon("SECTION.png"));
		btnSections.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnSections.setBounds(28, 62, 180, 46);
		frame.add(btnSections);
		btnSections.addActionListener(this);
		
		
		btnUserSettings.setIcon(new ImageIcon("USERSET.png"));
		btnUserSettings.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnUserSettings.setBounds(28, 122, 180, 46);
		frame.add(btnUserSettings);
		btnUserSettings.addActionListener(this);
		
		btnBack.setIcon(new ImageIcon("BILLBACK.png"));
		btnBack.setBounds(68,180,100,43);
		frame.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Background.png"));
		lblNewLabel.setBounds(0, 0, 238, 247);
		frame.add(lblNewLabel);
    	
    }
    
    public void actionPerformed(ActionEvent e){
	Object source=e.getSource();
		if(source==btnSections){
			SectionsBTN pane = new SectionsBTN();
	
			pane.setSize(440, 280);
			pane.setTitle("Sections");
			pane.setResizable(false);
			pane.setVisible(true);
			pane.setLocation(400,250);
			dispose();
		}
		if(source==btnBack){
			main_menu pane = new main_menu();
			pane.setLocation(400,250);
			pane.setSize( 565, 220);
			pane.setTitle("Main Menu");
			pane.setResizable(false);
			pane.setVisible(true);
			dispose();
		}
		if(source==btnUserSettings){
				UserSettings pane = new UserSettings();
	
			pane.setLocation(228, 341);
			pane.setSize( 228, 341);
			pane.setTitle("User Settings");
			pane.setResizable(false);
			pane.setVisible(true);	
				dispose();
		}
		
	
    
    }
    
}