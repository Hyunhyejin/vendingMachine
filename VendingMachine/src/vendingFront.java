//�ܵ� ���� �ʿ���

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Product.Coffee1;
import Product.Coffee2;
import Product.Coffee3;
import Product.MixCoffee1;
import Product.MixCoffee2;
import Product.MixCoffee3;
import Product.Tea1;
import Product.Tea2;
import Product.Tea3;

public class vendingFront extends JFrame implements ActionListener{
	Controller controller = new Controller();
	FrontPanel frontpanel = new FrontPanel();
	
	//JFrame ����
	JFrame frame = new JFrame();
	
	// �ֻ�� �г� (money slot) ����
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("�� ����"); 
	JTextField txtMoney = new JTextField(20);
	JTextField txtError = new JTextField(20);
	
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
	JButton btnRefund = new JButton("�� ȯ");
	
	// ���� �г� (���漭) ����
	JPanel south = new JPanel();
	JTextField txtDispenser = new JTextField(20);
	JTextField txtChange = new JTextField(20);
	
	// ����� ���� �ݾ� ����
	// input: ����ڰ� �ʱ� ������ �ݾ�
	// current: ���Ǳ� ������ ���Ǹ� ���ŵǴ� �ݾ�
	int input, current;
	
	public vendingFront(){
		super("vending machine"); 
		
		// JFrame placing
		frame.setLayout(new BorderLayout(30, 30));
		
		// upper panel placing
		upper.add(txtMoney);
		upper.add(btnMoney);
		upper.add(txtError); txtError.setEditable(false);
		frame.add("North", upper);
		
		// west panel placing
		west.add(btnCoffee1); btnCoffee1.setEnabled(false);
		west.add(btnCoffee2); btnCoffee2.setEnabled(false);
		west.add(btnCoffee3); btnCoffee3.setEnabled(false);
		west.add(btnMCoffee1); btnMCoffee1.setEnabled(false);
		west.add(btnMCoffee2); btnMCoffee2.setEnabled(false);
		west.add(btnMCoffee3); btnMCoffee3.setEnabled(false);
		west.add(btnNCoffee1); btnNCoffee1.setEnabled(false);
		west.add(btnNCoffee2); btnNCoffee2.setEnabled(false);
		west.add(btnNCoffee3); btnNCoffee3.setEnabled(false);
		west.setLayout(new GridLayout(3, 3, 20, 40));
		frame.add("West", west);
		
		// center panel placing
		center.add(txtTemperature);
		txtTemperature.setEditable(false);
		center.add(txtWater);
		txtWater.setEditable(false);
		frame.add("Center", center);
		
		// east panel placing
		east.add(btnSoldOut);
		btnSoldOut.setEnabled(false);
		east.add(btnRefund);
		btnRefund.setEnabled(false);
		east.setLayout(new GridLayout(2, 1, 20, 40));
		frame.add("East", east);
		
		// south panel placing
		south.add(txtDispenser);
		south.add(txtChange);
		txtDispenser.setEditable(false);
		txtChange.setEditable(false);
		south.setLayout(new GridLayout(1,2,40,60));
		frame.add("South", south);
		
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eventHandler();
	}
	
	public void eventHandler() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);	
			}	
		});
		
		btnMoney.addActionListener(this);
		btnCoffee1.addActionListener(this);
		btnCoffee2.addActionListener(this);
		btnCoffee3.addActionListener(this);
		btnMCoffee1.addActionListener(this);
		btnMCoffee2.addActionListener(this);
		btnMCoffee3.addActionListener(this);
		btnNCoffee1.addActionListener(this);
		btnNCoffee2.addActionListener(this);
		btnNCoffee3.addActionListener(this);
		btnRefund.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj==btnMoney) btnMoney_Click();
		if(obj==btnCoffee1) btnCoffee_Click(1);
		if(obj==btnCoffee2) btnCoffee_Click(2);
		if(obj==btnCoffee3) btnCoffee_Click(3);
		if(obj==btnMCoffee1) btnMCoffee_Click(1);
		if(obj==btnMCoffee2) btnMCoffee_Click(2);
		if(obj==btnMCoffee3) btnMCoffee_Click(3);
		if(obj==btnNCoffee1) btnNCoffee_Click(1);
		if(obj==btnNCoffee2) btnNCoffee_Click(2);
		if(obj==btnNCoffee3) btnNCoffee_Click(3);
		if(obj==btnRefund) btnRefund_Click();
		
	}
	
	public void btnMoney_Click() {
		String strMoney = txtMoney.getText();
		input = Integer.parseInt(strMoney);
		
		// acceptmoney(temp);
		if (input < 300) {
			txtError.setText("���� �����մϴ�!");
			txtError.setForeground(Color.red);
		} else {
			txtError.setText("Ŀ�� ������ �����ϼ���.");
			txtError.setForeground(Color.blue);
			txtMoney.setEditable(false);
			btnRefund.setEnabled(true);
			lightBtn();
		}
	}
	
	public void btnCoffee_Click(int coffeenum) {
		switch(coffeenum) {
		case 1:
			controller.check(new Coffee1());
			break;
		case 2:
			controller.check(new Coffee2());
			break;
		case 3:
			controller.check(new Coffee3());
			break;
		}
		
		if (controller.checkChange(input)) {
			JOptionPane.showMessageDialog(null, "�Ϲ�Ŀ�� " + coffeenum + "�� ������ �����մϴ�.");
			makingMsg();
		} else {
			txtError.setText("�ܵ��� �����մϴ�.");
		}
	}


	public void btnMCoffee_Click(int coffeenum) {
		switch(coffeenum) {
		case 1:
			controller.check(new MixCoffee1());
			break;
		case 2:
			controller.check(new MixCoffee2());
			break;
		case 3:
			controller.check(new MixCoffee3());
			break;
		}
		
		if (controller.checkChange(input)) {
			JOptionPane.showMessageDialog(null, "�ͽ�Ŀ�� " + coffeenum + "�� ������ �����մϴ�.");
			makingMsg();
		} else {
			txtError.setText("�ܵ��� �����մϴ�.");
		}
	}
	
	public void btnNCoffee_Click(int coffeenum) {
		switch(coffeenum) {
		case 1:
			controller.check(new Tea1());
			break;
		case 2:
			controller.check(new Tea2());
			break;
		case 3:
			controller.check(new Tea3());
			break;
		}
		
		if (controller.checkChange(input)) {
			JOptionPane.showMessageDialog(null, "�Ϲ��� " + coffeenum + "�� ������ �����մϴ�.");
			makingMsg();
		} else {
			txtError.setText("�ܵ��� �����մϴ�.");
		}
	}
	
	public void btnRefund_Click() {
		JOptionPane.showMessageDialog(null, "ȯ���� �����մϴ�.");
		txtMoney.setText("");
		// ȯ�� �Լ� ȣ��
		txtError.setText("ȯ�� �Ϸ�");
		txtError.setForeground(Color.blue);
		btnRefund.setEnabled(false);
		txtMoney.setEditable(true);
		offBtn();
	}
	
	public void lightBtn() {
		btnCoffee1.setEnabled(true);
		btnCoffee2.setEnabled(true);
		btnCoffee3.setEnabled(true);
		btnMCoffee1.setEnabled(true);
		btnMCoffee2.setEnabled(true);
		btnMCoffee3.setEnabled(true);
		btnNCoffee1.setEnabled(true);
		btnNCoffee2.setEnabled(true);
		btnNCoffee3.setEnabled(true);
	}
	
	public void offBtn() {
		btnCoffee1.setEnabled(false);
		btnCoffee2.setEnabled(false);
		btnCoffee3.setEnabled(false);
		btnMCoffee1.setEnabled(false);
		btnMCoffee2.setEnabled(false);
		btnMCoffee3.setEnabled(false);
		btnNCoffee1.setEnabled(false);
		btnNCoffee2.setEnabled(false);
		btnNCoffee3.setEnabled(false);
	}
	
	public void makingMsg() {
		current = input - 300;
		this.sleep(2000);
		controller.startMaking();
		String temp = String.valueOf(current);
		btnRefund.setEnabled(false);
		txtMoney.setText(temp);
		txtError.setText("");
		txtDispenser.setText("���� �Ϸ�. ���漭���� ���Ḧ ����������.");
		if (current > 0) {
			JOptionPane.showMessageDialog(null, "�ܵ� " + current + "���� ��ȯ�մϴ�.");
			// �ܵ� ��ȯ �޼ҵ� ȣ��
			txtMoney.setText("");
			txtMoney.setEditable(true);
		}
		offBtn();
	}

	
	public void sleep (int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
	}

	public static void main(String[] args){
		new vendingFront();
	}

}