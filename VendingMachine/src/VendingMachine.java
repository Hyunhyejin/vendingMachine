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
