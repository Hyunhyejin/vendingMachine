import java.util.*;

//WaterTank 
public class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"AĿ��", "BĿ��", "CĿ��"};
	//check �޼ҵ忡�� ���� ������ Ŀ�ǿ� ���� Ȯ���� ����
	private String name;
	private int price;
	//stack manager �� ���� ��� ������Ʈ �� ����
	int information[][] = { {3,1000}, {4, 2000}, {5, 3000}};


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
	public void checkMoney(int money) {
		if (money < information[0][1]/*�ּұݾ�*/) {
			//GUI�� ���� ����
			System.out.println("�׼��� �����մϴ�.");
			System.exit(0);
		}
		//��������
		//frontPanel ��ư�� ���� ������ �ȴ�.
		else {
			System.out.println("Ȯ�εǾ����ϴ�. ��ư�� ���� ���ɴϴ�.");
		}
	}

	//�ܵ� Ȯ��
	public void checkChange(int userMoney) {
		if (userMoney - price > TotalMoney) {
			//GUI�� ���� ����
			System.out.println("�ܵ��� �����մϴ�");
			System.exit(0);
		}
		else
			//���� ����
			System.out.println("Ȯ�εǾ����ϴ�. �ܵ��� �����ֽ��ϴ�.");
	}
	
	//��� Ȯ�� �޼ҵ�
	public void checkProduct() {
		for (int i = 0; i < product.length; i++) {
			if (product[i] == name) {
				if (information[i][0] < 1) {
					System.out.println("��� �����մϴ�");
					System.exit(0);
				}
				else
					//GUI�� �����ָ� ��
					System.out.println("��� �����ֽ��ϴ�");
			}
		}
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		Scanner sc = new Scanner(System.in);
		//GUI�� ���� frontPanel �� �Էµ� ����
		int money;
		money = sc.nextInt();
		System.out.println(money + "�� �־����ϴ�");
		c.checkMoney(money);

		c.check("AĿ��");
		c.setTotalMoney(200);		
		c.checkChange(money);
		c.checkProduct();
	}
}
