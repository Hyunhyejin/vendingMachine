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
