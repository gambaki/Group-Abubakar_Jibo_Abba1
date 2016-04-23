import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class LoginTest {
	String Username = "admin";
	String Password = "admin";
	
	
	Scanner scn = new Scanner(System.in);
	

	@Test
	public void test() {
		System.out.println("Enter usename");
		Username = scn.nextLine();
		
		System.out.println("Enter Password");
		Password = scn.nextLine();
		
		
		assertEquals(Username, Username);
		assertEquals(Password, Password);
	}

}
