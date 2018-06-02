package MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
import Product.Coffee1;
import Util.DummyInput;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DummyInput in = new DummyInput();
		MakingSystem mksys = new MakingSystem(new EndProductCallBack() {
			
			@Override
			public void endProductCallBack(Product product, String result) {
				// TODO Auto-generated method stub
				System.out.println("dhkstjdjdjj");

				System.out.println("dkdkdkdkdkdkdk");

			}
		});
		while(true) {
			int i = in.inInteger();
			if(i==1) {
				
				Coffee1 blakCoffee = new Coffee1();
				Product product = (Product) blakCoffee;
				mksys.startMakingSystem(product);
				
			}else if(i== 10){
				break;
			}
		}

		
		
		
	}

}
