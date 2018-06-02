import java.util.Scanner;
//돈 반환과 에러메세지는 frontPanel이 출력하지만
//에러를 인식하는 건 controller
//재고 확인 메소드 지울 것 같다... 재고 = 컵스택, 물용량 기타 등등이라서...
//Test

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
		//c.check("A커피");
		c.setTotalMoney(200);		
		c.checkChange(p.getMoney());
		
		
		p.giveChange(c.getPrice());
		p.giveProduct(c.getName());
	}
}