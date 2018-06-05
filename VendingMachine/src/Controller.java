
import MakingSystem.MakingSystem;
import Money.CoinStack;
import Parents.Product;

public class Controller {
	private int usermoney = 0;
	private MakingSystem makingsystem;
	private Product product;

	public Controller() {
		makingsystem = new MakingSystem();
	}


	//���Ǳ⿡ ���� �ִ� �ݾ�
	public int getTotalMoney() {
		return 	CoinStack.account_100*100;
	}

	//���� Ȯ�� 
	public boolean check(Product p) {
		this.product = p;
		
		return true;
	}

	//�ּұݾ� Ȯ�� �޼ҵ�
	public boolean checkMoney() {
		//��������
		//frontPanel ��ư�� ���� ������ �ȴ�.
		if (this.usermoney >= 300) {
			return true;
		}
		return false; 
	}

	//�ܵ� Ȯ��
	public boolean checkChange(int userMoney) {
		if (userMoney - product.getProductPrice() > getTotalMoney()) {
			return false;
		}
		else {
			return true;
		} 
	}

	public void startMaking() {
		makingsystem.startMakingSystem(this.product);
	}	

	//�� �ޱ�
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	//�ܵ� ��ȯ
	public int giveChange() {
		int current = usermoney - product.getProductPrice();
		return current;
	}
	
	void init() {
		this.usermoney =0;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	public Product getProduct() {
		return product;
	}

	
}