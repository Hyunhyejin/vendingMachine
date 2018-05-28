package MakingSystem;
import java.util.Scanner;

public class DummyInput {
	
	Scanner sc;
		
	DummyInput(){
		sc = new Scanner(System.in);
	}
		
	int inInteger() {
		int inInt = sc.nextInt();
		sc.nextLine();
		return inInt; 
	}
		
	String inString() {
		String inString = sc.nextLine();
		return inString;
	}
		
	
}
