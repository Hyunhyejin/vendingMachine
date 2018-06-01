import java.awt.*;

import javax.swing.*;


public class vendingFront extends JFrame{
	// �ֻ�� �г� (money slot) ����
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("�� ����"); 
	JTextField txtMoney = new JTextField(20);
	
	// ���� �г� (Ŀ�� ��ư) ����
	JPanel west = new JPanel();
	JButton btnCoffee1 = new JButton("Ŀ�� 1");
	JButton btnCoffee2 = new JButton("Ŀ�� 2");
	JButton btnCoffee3 = new JButton("Ŀ�� 3");
	JButton btnMCoffee1 = new JButton("�ͽ�Ŀ�� 1");
	JButton btnMCoffee2 = new JButton("�ͽ�Ŀ�� 2");
	JButton btnMCoffee3 = new JButton("�ͽ�Ŀ�� 3");
	JButton btnNCoffee1 = new JButton("�Ϲ��� 1");
	JButton btnNCoffee2 = new JButton("�Ϲ��� 2");
	JButton btnNCoffee3 = new JButton("�Ϲ��� 3");
		
	// �߾� �г� (���Ǳ� ����) ����
	JPanel center = new JPanel();
	JTextField txtWater = new JTextField(20);
	JTextField txtTemperature = new JTextField(20);
	JTextField txtMaking = new JTextField(20);
	
	// ���� �г� (��� ��Ȳ) ����
	JPanel east = new JPanel();
	JButton btnSoldOut = new JButton("�� �� �� ��");
	
	// ���� �г� (���漭) ����
	JPanel south = new JPanel();
	
	public vendingFront(){
		super("vending machine"); 
		
		// upper panel placing
		upper.add(txtMoney);
		upper.add(btnMoney);
		upper.setLayout(new FlowLayout());
		add("North", upper);
		
		// west panel placing
		west.add(btnCoffee1);
		west.add(btnCoffee2);
		west.add(btnCoffee3);
		west.add(btnMCoffee1);
		west.add(btnMCoffee2);
		west.add(btnMCoffee3);
		west.add(btnNCoffee1);
		west.add(btnNCoffee2);
		west.add(btnNCoffee3);
		west.setLayout(new GridLayout(3, 3, 20, 40));
		add("West", west);
		
		// center panel placing
		center.add(txtMaking);
		txtMaking.setEditable(false);
		center.add(txtTemperature);
		txtTemperature.setEditable(false);
		center.add(txtWater);
		txtWater.setEditable(false);
		add("Center", center);
		
		// east panel placing
		east.add(btnSoldOut);
		add("East", east);
		
		// south panel placing
		
		setSize(800, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new vendingFront();
	} 

}