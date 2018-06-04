
import MakingSystem.MakingSystem;
import Parents.ResultCallBack;
import Parents.Product;
import Product.Coffee1;

//얍

public class Controller {
	private int usermoney = 0;
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

	public Controller() {
		makingsystem = new MakingSystem(new ResultCallBack() {

			@Override
			public void resultCallBack(String result, String msg) {
				// TODO Auto-generated method stub
				
			}

	
		});	
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
	public boolean check(Product p) {
		this.product = p;
		name = product.getProductName();
		price = product.getProductPrice();	
		
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
			//GUI로 수정 예정
			//System.out.println("잔돈이 부족합니다");
			fronpanel.refundMoney();
			return false;
		}
		else {
			//수정 예정
			//System.out.println("확인되었습니다. 잔돈이 남아있습니다.");
			difference = userMoney - product.getProductPrice();
			return true;
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
	
	//frontPanel
	

	//돈 받기
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	//GUI 수정 예정
	//고객에게 잔돈 돌려주기
	public void giveChange(int price) {
		int change = usermoney - price;
		//System.out.println("잔돈 " + change + "원 돌려드립니다." );		
	}
	
	//GUI 수정 예정
	//고객에게 제품 주기
	public void giveProduct(String product) {
		//System.out.println(product + "가 완성되었습니다. 뜨거우므로 조심해주세요.");
	}
	
	//making system이 추가되면 수정 예정
	//에러 메세지
	//다른 곳에서 실패한 걸, frontPanel 에서 보여주는 용도
	//error 메소드와 연관
	public void refundMoney() {
		//GUI로 수정 예정
		//System.out.println("이러한 이유로 실패하였습니다.");
		//System.out.println("돈을 반환합니다.");
		//System.exit(0);
	}
	
	void init() {
		this.usermoney =0;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	
}