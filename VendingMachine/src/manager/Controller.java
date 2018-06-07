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
	
	//자판기에 남아 있는 금액
	public int getTotalMoney() {
		return 	coinStack.account_100*100;
	}

	//물건 확인 
	public boolean check(Product p) {
		this.product = p;
		
		return true;
	}

	//최소금액 확인 메소드
	public boolean checkMoney() {
		//수정예정
		//frontPanel 버튼에 불이 들어오면 된다.
		if (this.usermoney >= 300) {
			return true;
		}
		return false; 
	}

	//잔돈 확인
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

	//돈 받기
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	//잔돈 반환
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