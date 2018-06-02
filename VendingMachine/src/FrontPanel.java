public class FrontPanel {
	private int usermoney = 0;
	//�� �ޱ�
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	//��ư ������
	//GUI���� ��ư Ŭ������ ���� ����
	public void getButtonPressed() {
		//GUI���� ���� ����
		System.out.println("��ư�� �����ϴ�");
	}
	
	//GUI ���� ����
	//������ �ܵ� �����ֱ�
	public void giveChange(int price) {
		int change = usermoney - price;
		System.out.println("�ܵ� " + change + "�� �����帳�ϴ�." );		
	}
	
	//GUI ���� ����
	//������ ��ǰ �ֱ�
	public void giveProduct(String product) {
		System.out.println(product + "�� �ϼ��Ǿ����ϴ�. �߰ſ�Ƿ� �������ּ���.");
	}
	
	//making system�� �߰��Ǹ� ���� ����
	//���� �޼���
	//�ٸ� ������ ������ ��, frontPanel ���� �����ִ� �뵵
	//error �޼ҵ�� ����
	public void refundMoney() {
		//GUI�� ���� ����
		System.out.println("�̷��� ������ �����Ͽ����ϴ�.");
		System.out.println("���� ��ȯ�մϴ�.");
		System.exit(0);
	}
	
}