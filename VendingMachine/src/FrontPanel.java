//올리는용

public class FrontPanel {
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
		//System.out.println("버튼을 누릅니다");
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
	
}