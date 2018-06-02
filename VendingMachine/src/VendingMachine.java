import java.util.Scanner;

import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
import Product.Coffee1;
import Util.DummyInput;

public class VendingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DummyInput in = new DummyInput();
		Controller c = new Controller();
		FrontPanel p = new FrontPanel();
		
		int i = in.inInteger();
		while(true) {
			i = in.inInteger();
			if(i==1) {
				
				//GUI로 인해 frontPanel 로 입력될 예정
				int money;
				money = in.inInteger();
				p.acceptMoney(money);
				//GUI로 수정 예정 
				System.out.println(p.getMoney() + "원 넣었습니다");
				//최소금액 미만일 경우, 아무런 일이 벌어지지 않는다
				while (c.checkMoney(p.getMoney()) != true) {
					money = in.inInteger();
					p.acceptMoney(money);
					System.out.println(p.getMoney() + "원 넣었습니다");
				}		
				
				//GUI에서 커피 버튼으로 입력될 예정
		
<<<<<<< HEAD
				c.check(new BlakCoffee());	
=======
				c.check(new Coffee1());
>>>>>>> cdc50b1c122ed5d2e6a5438a2cb9baa693ae1fa6
				c.checkChange(p.getMoney());
				
				p.giveChange(c.getPrice());
				p.giveProduct(c.getName());
				
				p.init();
			
			}else if(i== 10){
				break;
			}
		}

		
	}

}
