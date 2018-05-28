import java.util.*;

//WaterTank 
public class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"A커피", "B커피", "C커피"};
	//check 메소드에서 고객이 구매한 커피와 가격 확인할 변수
	private String name;
	private int price;
	//stack manager 에 의해 계속 업데이트 될 예정
	int information[][] = { {3,1000}, {4, 2000}, {5, 3000}};


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
	public void checkMoney(int money) {
		if (money < information[0][1]/*최소금액*/) {
			//GUI로 수정 예정
			System.out.println("액수가 부족합니다.");
			System.exit(0);
		}
		//수정예정
		//frontPanel 버튼에 불이 들어오면 된다.
		else {
			System.out.println("확인되었습니다. 버튼에 불이 들어옵니다.");
		}
	}

	//잔돈 확인
	public void checkChange(int userMoney) {
		if (userMoney - price > TotalMoney) {
			//GUI로 수정 예정
			System.out.println("잔돈이 부족합니다");
			System.exit(0);
		}
		else
			//수정 예정
			System.out.println("확인되었습니다. 잔돈이 남아있습니다.");
	}
	
	//재고 확인 메소드
	public void checkProduct() {
		for (int i = 0; i < product.length; i++) {
			if (product[i] == name) {
				if (information[i][0] < 1) {
					System.out.println("재고가 부족합니다");
					System.exit(0);
				}
				else
					//GUI로 보여주면 됨
					System.out.println("재고가 남아있습니다");
			}
		}
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		Scanner sc = new Scanner(System.in);
		//GUI로 인해 frontPanel 로 입력될 예정
		int money;
		money = sc.nextInt();
		System.out.println(money + "원 넣었습니다");
		c.checkMoney(money);

		c.check("A커피");
		c.setTotalMoney(200);		
		c.checkChange(money);
		c.checkProduct();
	}
}
