import java.util.Scanner;
//�� ��ȯ�� �����޼����� frontPanel�� ���������
//������ �ν��ϴ� �� controller
//��� Ȯ�� �޼ҵ� ���� �� ����... ��� = �Ž���, ���뷮 ��Ÿ ����̶�...
//Test

public class vending {
	public static void main(String[] args) {
		Controller c = new Controller();
		FrontPanel p = new FrontPanel();
		Scanner sc = new Scanner(System.in);
		
		//GUI�� ���� frontPanel �� �Էµ� ����
		int money;
		money = sc.nextInt();
		p.acceptMoney(money);
		//GUI�� ���� ���� 
		System.out.println(p.getMoney() + "�� �־����ϴ�");
		//�ּұݾ� �̸��� ���, �ƹ��� ���� �������� �ʴ´�
		while (c.checkMoney(p.getMoney()) != true) {
			money = sc.nextInt();
			p.acceptMoney(money);
			System.out.println(p.getMoney() + "�� �־����ϴ�");
		}		
		
		//GUI���� Ŀ�� ��ư���� �Էµ� ����
		c.check("AĿ��");
		c.setTotalMoney(200);		
		c.checkChange(p.getMoney());
		c.checkProduct();
		
		p.giveChange(c.getPrice());
		p.giveProduct(c.getName());
	}
}