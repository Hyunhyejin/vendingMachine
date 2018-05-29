import java.util.Scanner;
//�� ��ȯ�� �����޼����� frontPanel�� ���������
//������ �ν��ϴ� �� controller
//��� Ȯ�� �޼ҵ� ���� �� ����... ��� = �Ž���, ���뷮 ��Ÿ ����̶�...
//Test

class FrontPanel {
	private int usermoney = 0;
	//�� �ޱ�
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	//��ư ������
	//GUI���� ��ư Ŭ������ ���� ����
	public void getButtonPressed() {
		//GUI���� ���� ����
		System.out.println("��ư�� �����ϴ�");
	}
	
	//GUI ���� ����
	//������ �ܵ� �����ֱ�
	public void giveChange(int price) {
		int change = usermoney - price;
		System.out.println("�ܵ� " + change + "�� �����帳�ϴ�." );		
	}
	
	//GUI ���� ����
	//������ ��ǰ �ֱ�
	public void giveProduct(String product) {
		System.out.println(product + "�� �ϼ��Ǿ����ϴ�. �߰ſ�Ƿ� �������ּ���.");
	}
	
	//making system�� �߰��Ǹ� ���� ����
	//���� �޼���
	//�ٸ� ������ ������ ��, frontPanel ���� �����ִ� �뵵
	//error �޼ҵ�� ����
	public void refundMoney() {
		//GUI�� ���� ����
		System.out.println("�̷��� ������ �����Ͽ����ϴ�.");
		System.out.println("���� ��ȯ�մϴ�.");
		System.exit(0);
	}
	
}

class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"AĿ��", "BĿ��", "CĿ��"};
	//check �޼ҵ忡�� ���� ������ Ŀ�ǿ� ���� Ȯ���� ����
	private String name;
	private int price;
	//stack manager �� ���� ��� ������Ʈ �� ����
	int information[][] = { {2,1000}, {4, 2000}, {5, 3000}};
	
	//���� ���� �޼ҵ�
	public int getPrice() {
		return price;
	}
	
	//���� �̸� �޼ҵ�
	public String getName() {
		return name;
	}


	//���Ǳ⿡ ���� �ִ� �ݾ� �Է�
	public void setTotalMoney(int TotalMoney) {
		this.TotalMoney = TotalMoney;
	}	

	//���Ǳ⿡ ���� �ִ� �ݾ�
	public int getTotalMoney() {
		return TotalMoney;
	}
	
	//���� Ȯ�� 
	public void check(String p) {
		for (int i = 0; i < product.length; i++) {
			if (p == product[i]) {
				name = product[i];
				price = information[i][1];
				break;
			}				
		}
	}

	//�ּұݾ� Ȯ�� �޼ҵ�
	public boolean checkMoney(int money) {
		//��������
		//frontPanel ��ư�� ���� ������ �ȴ�.
		if (money >= information[0][1]) {
			System.out.println("Ȯ�εǾ����ϴ�. ��ư�� ���� ���ɴϴ�.");
			FrontPanel p = new FrontPanel();
			p.getButtonPressed();
			
			return true;
		}
		return false; 
	}

	//�ܵ� Ȯ��
	public void checkChange(int userMoney) {
		if (userMoney - price > TotalMoney) {
			//GUI�� ���� ����
			System.out.println("�ܵ��� �����մϴ�");
			FrontPanel p = new FrontPanel();
			p.refundMoney();
		}
		else
			//���� ����
			System.out.println("Ȯ�εǾ����ϴ�. �ܵ��� �����ֽ��ϴ�.");
	}
	
	//��� Ȯ�� �޼ҵ�
	public void checkProduct() {
		//��� �ʹ� ���Ĺ���...
		for (int i = 0; i < product.length; i++) {
			if (product[i] == name) {
				if (information[i][0] < 1) {
					System.out.println("��� �����մϴ�.");
					FrontPanel p = new FrontPanel();
					p.refundMoney();
				}
				else
					//GUI�� �����ָ� ��
					System.out.println("��� �����ֽ��ϴ�.");
			}
		}
	}
	//�߰� ����
	//making system ��ü�� �����ͼ�, �̰� ���� ���� ��츦 ��Ƽ� 
	//������ ���ٰ� �˷��ָ� �ȴ�
	public boolean error() {
		return false;
	}
	
	
}

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