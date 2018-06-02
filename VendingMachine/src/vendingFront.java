import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.awt.Robot;

public class vendingFront extends JFrame implements ActionListener{
	//JFrame 생성
	JFrame frame = new JFrame();
	
	// 최상단 패널 (money slot) 세팅
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("돈 투입"); 
	JTextField txtMoney = new JTextField(20);
	JTextField txtError = new JTextField(20);
	
	// 서쪽 패널 (커피 버튼) 세팅
	JPanel west = new JPanel();
	JButton btnCoffee1 = new JButton("커피 1");
	JButton btnCoffee2 = new JButton("커피 2");
	JButton btnCoffee3 = new JButton("커피 3");
	JButton btnMCoffee1 = new JButton("믹스커피 1");
	JButton btnMCoffee2 = new JButton("믹스커피 2");
	JButton btnMCoffee3 = new JButton("믹스커피 3");
	JButton btnNCoffee1 = new JButton("일반차 1");
	JButton btnNCoffee2 = new JButton("일반차 2");
	JButton btnNCoffee3 = new JButton("일반차 3");
		
	// 중앙 패널 (자판기 상태) 세팅
	JPanel center = new JPanel();
	JTextField txtWater = new JTextField(20);
	JTextField txtTemperature = new JTextField(20);
	JTextField txtMaking = new JTextField(20);
	
	// 동쪽 패널 (재고 현황) 세팅
	JPanel east = new JPanel();
	JButton btnSoldOut = new JButton("재 고 없 음");
	JButton btnRefund = new JButton("반 환");
	
	// 남쪽 패널 (디스펜서) 세팅
	JPanel south = new JPanel();
	JTextField txtDispenser = new JTextField(20);
	JTextField txtChange = new JTextField(20);
	
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
		int money = Integer.parseInt(strMoney);
		// acceptmoney(temp);
		if (money < 300) {
			txtError.setText("돈이 부족합니다!");
			txtError.setForeground(Color.red);
		} else {
			txtError.setText("커피 종류를 선택하세요.");
			txtError.setForeground(Color.blue);
			txtMoney.setEditable(false);
			lightBtn();
		}
	}
	
	public void btnCoffee_Click(int coffeenum) {
		JOptionPane.showMessageDialog(null, "일반커피 " + coffeenum + "의 제조를 시작합니다.");
    	makingMsg();
	}


	public void btnMCoffee_Click(int coffeenum) {
		JOptionPane.showMessageDialog(null, "믹스커피 " + coffeenum + "의 제조를 시작합니다.");
    	makingMsg();
	}
	
	public void btnNCoffee_Click(int coffeenum) {
		JOptionPane.showMessageDialog(null, "일반 차  " + coffeenum + "의 제조를 시작합니다.");
    	makingMsg();
	}
	
	public void btnRefund_Click() {
		
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
		this.sleep(2000);
		txtDispenser.setText("제조 완료. 디스펜서에서 음료를 가져가세요.");
		// 잔돈 메소드 호출
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