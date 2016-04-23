import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class LoginTest {
	String username = "user1";
	String Password = "admin12";
	
	String user, pass;
	Scanner scn = new Scanner(System.in);
	

	@Test
	public void test() {
		System.out.println("Enter usename");
		user = scn.nextLine();
		
		System.out.println("Enter Password");
		user = scn.nextLine();
		
		
		assertEquals(user, username);
		assertEquals(pass, Password);
	}

}
