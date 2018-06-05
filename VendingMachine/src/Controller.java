
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


	//자판기에 남아 있는 금액
	public int getTotalMoney() {
		return 	CoinStack.account_100*100;
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