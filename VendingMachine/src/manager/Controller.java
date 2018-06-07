package manager;

import MakingSystem.MakingSystem;
import MakingSystem.Product;
import Money.CoinStack;
import Money.NoteStack;

public class Controller {
	private int usermoney = 0;
	private MakingSystem makingsystem;
	private Product product;
	private CoinStack coinStack;
	private NoteStack noteStack;

	public Controller() {
		makingsystem = new MakingSystem();
		coinStack = new CoinStack();
		noteStack = new NoteStack();
	}
	
	//���Ǳ⿡ ���� �ִ� �ݾ�
	public int getTotalMoney() {
		return 	coinStack.account_100*100;
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
		if(money == 1000){
			noteStack.addMoney(money);
		}else {
			coinStack.addMoney(money);
		}
	}
	
	//�ܵ� ��ȯ
	public int giveChange() {
		int current = usermoney - product.getProductPrice();
		coinStack.outCoinMoney(current);
		return current;
	}
	
	public void init() {
		this.usermoney =0;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int refundMoney() {
		int temp = usermoney;
		coinStack.outCoinMoney(temp);
		usermoney = 0;
		return temp;
	}

	
}