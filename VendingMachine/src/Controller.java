import MakingSystem.BlakCoffee;
import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;

public class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"AĿ��", "BĿ��", "CĿ��"};
	//check �޼ҵ忡�� ���� ������ Ŀ�ǿ� ���� Ȯ���� ����
	private String name;
	private int price;
	//stack manager �� ���� ��� ������Ʈ �� ����
	int information[][] = { {2,1000}, {4, 2000}, {5, 3000}};
	MakingSystem makingsystem;
	
	public Controller() {
		makingsystem = new MakingSystem(new EndProductCallBack() {
			
			@Override
			public void endProductCallBack(Product product, String result) {
				// TODO Auto-generated method stub
				System.out.println("�ϼ���پƾƤ���");
			}
		});	
	}
	
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
		if (userMoney -price > TotalMoney) {
			//GUI�� ���� ����
			System.out.println("�ܵ��� �����մϴ�");
			FrontPanel p = new FrontPanel();
			p.refundMoney();
		}
		else {
			//���� ����
			System.out.println("Ȯ�εǾ����ϴ�. �ܵ��� �����ֽ��ϴ�.");
			makingsystem.startMakingSystem(new BlakCoffee());
		}
	}

	//�߰� ����
	//making system ��ü�� �����ͼ�, �̰� ���� ���� ��츦 ��Ƽ� 
	//������ ���ٰ� �˷��ָ� �ȴ�
	public boolean error() {
		return false;
	}
	

	
}