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
				
				//GUI�� ���� frontPanel �� �Էµ� ����
				int money;
				money = in.inInteger();
				p.acceptMoney(money);
				//GUI�� ���� ���� 
				System.out.println(p.getMoney() + "�� �־����ϴ�");
				//�ּұݾ� �̸��� ���, �ƹ��� ���� �������� �ʴ´�
				while (c.checkMoney(p.getMoney()) != true) {
					money = in.inInteger();
					p.acceptMoney(money);
					System.out.println(p.getMoney() + "�� �־����ϴ�");
				}		
				
				//GUI���� Ŀ�� ��ư���� �Էµ� ����
		
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
