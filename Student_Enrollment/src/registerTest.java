import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class registerTest {
	String Username = "admin";
	String Password = "admin";
	String name = "nura";
	String secondname = "jibo";
	String address = "CYBERJAYA";
	
	
	
	
	Scanner scn = new Scanner(System.in);
	
	@Test
	public void test() {
		System.out.println("Enter usename");
		Username = scn.nextLine();
		
		System.out.println("Enter Password");
		Password = scn.nextLine();
		
		System.out.println("Enter Name");
		name = scn.nextLine();
		
		System.out.println("Enter Secondname");
		secondname = scn.nextLine();
		
		System.out.println("Enter Address");
		address = scn.nextLine();
		
		assertEquals(Username, Username);
		assertEquals(Password, Password);
		assertEquals(name, name);
		assertEquals(secondname, secondname);
		assertEquals(address, address);
	}

}
