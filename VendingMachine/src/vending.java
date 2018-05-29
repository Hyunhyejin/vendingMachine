import java.util.Scanner;
//돈 반환과 에러메세지는 frontPanel이 출력하지만
//에러를 인식하는 건 controller
//재고 확인 메소드 지울 것 같다... 재고 = 컵스택, 물용량 기타 등등이라서...
//Test

class FrontPanel {
	private int usermoney = 0;
	//돈 받기
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	//버튼 누르기
	//GUI에서 버튼 클릭으로 수정 예정
	public void getButtonPressed() {
		//GUI에서 수정 예정
		System.out.println("버튼을 누릅니다");
	}
	
	//GUI 수정 예정
	//고객에게 잔돈 돌려주기
	public void giveChange(int price) {
		int change = usermoney - price;
		System.out.println("잔돈 " + change + "원 돌려드립니다." );		
	}
	
	//GUI 수정 예정
	//고객에게 제품 주기
	public void giveProduct(String product) {
		System.out.println(product + "가 완성되었습니다. 뜨거우므로 조심해주세요.");
	}
	
	//making system이 추가되면 수정 예정
	//에러 메세지
	//다른 곳에서 실패한 걸, frontPanel 에서 보여주는 용도
	//error 메소드와 연관
	public void refundMoney() {
		//GUI로 수정 예정
		System.out.println("이러한 이유로 실패하였습니다.");
		System.out.println("돈을 반환합니다.");
		System.exit(0);
	}
	
}

class Controller {
	private int TotalMoney = 0;
	private static final String product[] = {"A커피", "B커피", "C커피"};
	//check 메소드에서 고객이 구매한 커피와 가격 확인할 변수
	private String name;
	private int price;
	//stack manager 에 의해 계속 업데이트 될 예정
	int information[][] = { {2,1000}, {4, 2000}, {5, 3000}};
	
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
		if (userMoney - price > TotalMoney) {
			//GUI로 수정 예정
			System.out.println("잔돈이 부족합니다");
			FrontPanel p = new FrontPanel();
			p.refundMoney();
		}
		else
			//수정 예정
			System.out.println("확인되었습니다. 잔돈이 남아있습니다.");
	}
	
	//재고 확인 메소드
	public void checkProduct() {
		//재고를 너무 합쳐버림...
		for (int i = 0; i < product.length; i++) {
			if (product[i] == name) {
				if (information[i][0] < 1) {
					System.out.println("재고가 부족합니다.");
					FrontPanel p = new FrontPanel();
					p.refundMoney();
				}
				else
					//GUI로 보여주면 됨
					System.out.println("재고가 남아있습니다.");
			}
		}
	}
	//추가 예정
	//making system 객체를 가져와서, 이게 오류 나는 경우를 모아서 
	//에러가 났다고 알려주면 된다
	public boolean error() {
		return false;
	}
	
	
}

public class vending {
	public static void main(String[] args) {
		Controller c = new Controller();
		FrontPanel p = new FrontPanel();
		Scanner sc = new Scanner(System.in);
		
		//GUI로 인해 frontPanel 로 입력될 예정
		int money;
		money = sc.nextInt();
		p.acceptMoney(money);
		//GUI로 수정 예정 
		System.out.println(p.getMoney() + "원 넣었습니다");
		//최소금액 미만일 경우, 아무런 일이 벌어지지 않는다
		while (c.checkMoney(p.getMoney()) != true) {
			money = sc.nextInt();
			p.acceptMoney(money);
			System.out.println(p.getMoney() + "원 넣었습니다");
		}		
		
		//GUI에서 커피 버튼으로 입력될 예정
		c.check("A커피");
		c.setTotalMoney(200);		
		c.checkChange(p.getMoney());
		c.checkProduct();
		
		p.giveChange(c.getPrice());
		p.giveProduct(c.getName());
	}
}