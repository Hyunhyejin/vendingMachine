package Util;

import java.util.Scanner;

public class DummyInput {
	
	Scanner sc;
		
	public DummyInput(){
		sc = new Scanner(System.in);
	}
		
	public int inInteger() {
		int inInt = sc.nextInt();
		sc.nextLine();
		return inInt; 
	}
		
	public String inString() {
		String inString = sc.nextLine();
		return inString;
	}
		
	
}
