package MakingSystem;


import Parents.Product;
import Util.DummyInput;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DummyInput in = new DummyInput();
		MakingSystem mksys = new MakingSystem();
		while(true) {
			int i = in.inInteger();
			if(i==1) {
				
				BlakCoffee blakCoffee = new BlakCoffee();
				Product product = (Product) blakCoffee;
				mksys.startMakingSystem(product);
				
			}else if(i== 10){
				break;
			}
		}

		
		
		
	}

}
