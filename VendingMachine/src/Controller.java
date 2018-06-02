import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
import Product.Coffee1;

public class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"A커피", "B커피", "C커피"};
	//check 메소드에서 고객이 구매한 커피와 가격 확인할 변수
	private String name;
	private int price;
	//stack manager 에 의해 계속 업데이트 될 예정
	int information[][] = { {2,1000}, {4, 2000}, {5, 3000}};
	MakingSystem makingsystem;
	
	public Controller() {
		makingsystem = new MakingSystem(new EndProductCallBack() {
			
			@Override
			public void endProductCallBack(Product product, String result) {
				// TODO Auto-generated method stub
				System.out.println("완성됬다아아ㅏㅏ");
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


	//자판기에 남아 있는 금액 입력
	public void setTotalMoney(int TotalMoney) {
		this.TotalMoney = TotalMoney;
	}	

	//자판기에 남아 있는 금액
	public int getTotalMoney() {
		return TotalMoney;
	}
	
	//물건 확인 
	public void check(String p) {
		for (int i = 0; i < product.length; i++) {
			if (p == product[i]) {
				name = product[i];
				price = information[i][1];
				break;
			}				
		}
	}

	//최소금액 확인 메소드
	public boolean checkMoney(int money) {
		//수정예정
		//frontPanel 버튼에 불이 들어오면 된다.
		if (money >= information[0][1]) {
			System.out.println("확인되었습니다. 버튼에 불이 들어옵니다.");
			FrontPanel p = new FrontPanel();
			p.getButtonPressed();
			
			return true;
		}
		return false; 
	}

	//잔돈 확인
	public void checkChange(int userMoney) {
		if (userMoney -price > TotalMoney) {
			//GUI로 수정 예정
			System.out.println("잔돈이 부족합니다");
			FrontPanel p = new FrontPanel();
			p.refundMoney();
		}
		else {
			//수정 예정
			System.out.println("확인되었습니다. 잔돈이 남아있습니다.");
			makingsystem.startMakingSystem(new Coffee1());
		}
	}

	//추가 예정
	//making system 객체를 가져와서, 이게 오류 나는 경우를 모아서 
	//에러가 났다고 알려주면 된다
	public boolean error() {
		return false;
	}
	

	
}