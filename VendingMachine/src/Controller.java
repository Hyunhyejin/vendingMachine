
import MakingSystem.MakingSystem;
import Parents.EndProductCallBack;
import Parents.Product;
import Product.Coffee1;

//��

public class Controller {
	private int TotalMoney = 2000;
	//TotalMoney�� ���� �� (TotalMoney - (userMoney - productMoney)
	int difference;
	//check �޼ҵ忡�� ���� ������ Ŀ�ǿ� ���� Ȯ���� ����
	private String name;
	private int price;
	//stack manager �� ���� ��� ������Ʈ �� ����
	MakingSystem makingsystem;
	Product product;
	FrontPanel fronpanel = new FrontPanel();

	public Controller() {
		makingsystem = new MakingSystem(new EndProductCallBack() {

			@Override
			public void endProductCallBack(Product product, String result) {
				TotalMoney -= difference;
				// TODO Auto-generated method stub
				//System.out.println("�ϼ���پƾƤ���");
			}
		});	
	}

	//���� ���� �޼ҵ�
	public int getPrice() {
		return price;
	}

	//���� �̸� �޼ҵ�
	public String getName() {
		return name;
	}

	//���Ǳ⿡ ���� �ִ� �ݾ�
	public int getTotalMoney() {
		return TotalMoney;
	}

	//���� Ȯ�� 
	public boolean check(Product p) {
		this.product = p;
		name = product.getProductName();
		price = product.getProductPrice();	
		
		return true;
	}

	//�ּұݾ� Ȯ�� �޼ҵ�
	public boolean checkMoney(int money) {
		//��������
		//frontPanel ��ư�� ���� ������ �ȴ�.
		if (money >= 300) {
			//System.out.println("Ȯ�εǾ����ϴ�. ��ư�� ���� ���ɴϴ�.");
			fronpanel.getButtonPressed();

			return true;
		}
		return false; 
	}

	//�ܵ� Ȯ��
	public boolean checkChange(int userMoney) {

		if (userMoney - product.getProductPrice() > getTotalMoney()) {
			//GUI�� ���� ����
			//System.out.println("�ܵ��� �����մϴ�");
			fronpanel.refundMoney();
			return false;
		}
		else {
			//���� ����
			//System.out.println("Ȯ�εǾ����ϴ�. �ܵ��� �����ֽ��ϴ�.");
			difference = userMoney - product.getProductPrice();
			return true;
		}
	}

	//�߰� ����
	//making system ��ü�� �����ͼ�, �̰� ���� ���� ��츦 ��Ƽ� 
	//������ ���ٰ� �˷��ָ� �ȴ�
	public boolean error() {
		return false;
	}
	
	public void startMaking() {
		makingsystem.startMakingSystem(this.product);
	}



}