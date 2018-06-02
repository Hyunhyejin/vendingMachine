import java.util.Scanner;

import MakingSystem.BlakCoffee;
import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
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
		
				c.check(new BlakCoffee());	
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
