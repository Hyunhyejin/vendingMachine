
import MakingSystem.MakingSystem;
import Parents.ResultCallBack;
import Parents.Product;
import Product.Coffee1;

//��

public class Controller {
	private int usermoney = 0;
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
		makingsystem = new MakingSystem(new ResultCallBack() {

			@Override
			public void resultCallBack(String result, String msg) {
				// TODO Auto-generated method stub
				
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
	public boolean checkMoney() {
		//��������
		//frontPanel ��ư�� ���� ������ �ȴ�.
		if (this.usermoney >= 300) {
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
	
	//frontPanel
	

	//�� �ޱ�
	public void acceptMoney(int money) {
		usermoney += money;
	}
	
	//GUI ���� ����
	//������ �ܵ� �����ֱ�
	public void giveChange(int price) {
		int change = usermoney - price;
		//System.out.println("�ܵ� " + change + "�� �����帳�ϴ�." );		
	}
	
	//GUI ���� ����
	//������ ��ǰ �ֱ�
	public void giveProduct(String product) {
		//System.out.println(product + "�� �ϼ��Ǿ����ϴ�. �߰ſ�Ƿ� �������ּ���.");
	}
	
	//making system�� �߰��Ǹ� ���� ����
	//���� �޼���
	//�ٸ� ������ ������ ��, frontPanel ���� �����ִ� �뵵
	//error �޼ҵ�� ����
	public void refundMoney() {
		//GUI�� ���� ����
		//System.out.println("�̷��� ������ �����Ͽ����ϴ�.");
		//System.out.println("���� ��ȯ�մϴ�.");
		//System.exit(0);
	}
	
	void init() {
		this.usermoney =0;
	}
	
	public int getMoney() {
		return usermoney;
	}
	
	
}