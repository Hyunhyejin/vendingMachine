
import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
import Product.Coffee1;

//얍

public class Controller implements EndProductCallBack{
	private int TotalMoney = 2000;
	//TotalMoney에 빼둘 돈 (TotalMoney - (userMoney - productMoney)
	int difference;
	//check 메소드에서 고객이 구매한 커피와 가격 확인할 변수
	private String name;
	private int price;
	//stack manager 에 의해 계속 업데이트 될 예정
	MakingSystem makingsystem;
	Product product;
	FrontPanel fronpanel = new FrontPanel();
	String result;
	
	public Controller() {
		makingsystem = new MakingSystem(this);
	}
	
	
	@Override
	public void endProductCallBack(Product product, String result) {
		// TODO Auto-generated method stub
		this.result = result;
	}


	//물건 가격 메소드
	public int getPrice() {
		return price;
	}

	//물건 이름 메소드
	public String getName() {
		return name;
	}

	//자판기에 남아 있는 금액
	public int getTotalMoney() {
		return TotalMoney;
	}

	//물건 확인 
	public void check(Product p) {
		this.product = p;
		name = product.getProductName();
		price = product.getProductPrice();	
	}

	//최소금액 확인 메소드
	public boolean checkMoney(int money) {
		//수정예정
		//frontPanel 버튼에 불이 들어오면 된다.
		if (money >= 300) {
			System.out.println("확인되었습니다. 버튼에 불이 들어옵니다.");
			fronpanel.getButtonPressed();

			return true;
		}
		return false; 
	}

	//잔돈 확인
	public void checkChange(int userMoney) {

		if (userMoney - product.getProductPrice() > getTotalMoney()) {
			//GUI로 수정 예정
			System.out.println("잔돈이 부족합니다");
			fronpanel.refundMoney();
		}
		else {
			//수정 예정
			System.out.println("확인되었습니다. 잔돈이 남아있습니다.");
			difference = userMoney - product.getProductPrice();
			
		}
	}

	//추가 예정
	//making system 객체를 가져와서, 이게 오류 나는 경우를 모아서 
	//에러가 났다고 알려주면 된다
	public boolean error() {
		return false;
	}
	
	public void startMaking() {
		makingsystem.startMakingSystem(this.product);
	}



}