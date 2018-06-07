import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.*;

import MakingSystem.StockManager;
import MakingSystem.WaterTank;
import Money.CoinSlot;
import Money.NoteSlot;
import Parents.ResultCallBack;
import Product.Coffee1;
import Product.Coffee2;
import Product.Coffee3;
import Product.MixCoffee1;
import Product.MixCoffee2;
import Product.MixCoffee3;
import Product.Tea1;
import Product.Tea2;
import Product.Tea3;
import Util.ResultEventHandler;

public class FrontPanel extends JFrame implements ActionListener, ResultCallBack{
	Controller controller = new Controller();
	CoinSlot coinslot = new CoinSlot();
	NoteSlot noteslot = new NoteSlot();

	//JFrame 생성
	JFrame frame = new JFrame();

	// 최상단 패널 (money slot) 세팅
	JPanel upper = new JPanel();
	JButton btn100 = new JButton("+ 100");
	JButton btn500 = new JButton("+ 500");
	JButton btn1000 = new JButton("+ 1000");
	JLabel lblInput = new JLabel("투입금액");
	JTextField txtInput = new JTextField(20);
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
	JLabel lblCoffee1 = new JLabel("300원");
	JLabel lblMCoffee1 = new JLabel("300원");
	JLabel lblNCoffee1 = new JLabel("300원");
	JLabel lblCoffee2 = new JLabel("400원");
	JLabel lblMCoffee2 = new JLabel("400원");
	JLabel lblNCoffee2 = new JLabel("400원");
	JLabel lblCoffee3 = new JLabel("500원");
	JLabel lblMCoffee3 = new JLabel("500원");
	JLabel lblNCoffee3 = new JLabel("500원");


	// 중앙 패널 (자판기 상태) 세팅
	JPanel center = new JPanel();
	JTextField txtTemperature = new JTextField(20);
	JTextField txtWater = new JTextField(20);
	JLabel lblTemperature = new JLabel("현재온도");
	JLabel lblWater = new JLabel("수용량");

	// 동쪽 패널 (재고 현황) 세팅
	JPanel east = new JPanel();
	JButton btnSoldOut = new JButton("재 고 없 음");
	JButton btnRefund = new JButton("반 환");
	JButton btnAdmin = new JButton(" 관 리 자");

	// 남쪽 패널 (디스펜서) 세팅
	JPanel south = new JPanel();
	JTextField txtDispenser = new JTextField(20);
	JTextField txtChange = new JTextField(20);
	JLabel lblDispenser = new JLabel("음료 출구");
	JLabel lblChange = new JLabel("잔돈 반환");

	// 사용자 투입 금액 세팅
	// input: 사용자가 초기 투입한 금액

	public FrontPanel(){
		super("vending machine"); 

		// JFrame placing
		frame.setLayout(new BorderLayout(30, 30));

		// upper panel placing
		upper.setBorder(new EmptyBorder(10, 50, 20, 50));
		upper.setBackground(Color.LIGHT_GRAY);
		upper.add(btn100);
		upper.add(btn500);
		upper.add(btn1000);
		upper.add(lblInput);
		lblInput.setBorder(new EmptyBorder(0,120,0,0));
		upper.add(txtInput); txtInput.setEditable(false);
		txtInput.setBackground(Color.WHITE);
		upper.add(txtError); txtError.setEditable(false);
		upper.setLayout(new GridLayout(2,3,10,10));
		frame.add("North", upper);

		// west panel placing
		west.setBorder(new EmptyBorder(5, 40, 0, 0));
		west.add(btnCoffee1); btnCoffee1.setEnabled(false); 
		west.add(btnCoffee2); btnCoffee2.setEnabled(false); 
		west.add(btnCoffee3); btnCoffee3.setEnabled(false);
		west.add(lblCoffee1); west.add(lblCoffee2); west.add(lblCoffee3);
		west.add(btnMCoffee1); btnMCoffee1.setEnabled(false); 
		west.add(btnMCoffee2); btnMCoffee2.setEnabled(false); 
		west.add(btnMCoffee3); btnMCoffee3.setEnabled(false);
		west.add(lblMCoffee1); west.add(lblMCoffee2); west.add(lblMCoffee3);
		west.add(btnNCoffee1); btnNCoffee1.setEnabled(false);
		west.add(btnNCoffee2); btnNCoffee2.setEnabled(false); 
		west.add(btnNCoffee3); btnNCoffee3.setEnabled(false);
		west.add(lblNCoffee1); west.add(lblNCoffee2); west.add(lblNCoffee3);
		west.setLayout(new GridLayout(6, 3, 20, 5));
		frame.add("West", west);

		// center panel placing
		center.setLayout(new GridLayout(4,1,0,10));
		center.setBorder(new EmptyBorder(50, 0, 50, 0));
		center.add(lblTemperature);
		txtTemperature.setFont(new Font("돋움", Font.BOLD, 18));
		center.add(txtTemperature); txtTemperature.setEditable(false);
		center.add(lblWater);	center.add(txtWater);
		txtWater.setText("제조 대기");
		txtWater.setEditable(false);
		frame.add("Center", center);

		// east panel placing
		east.setBorder(new EmptyBorder(0, 0, 0, 50));
		east.add(btnSoldOut);
		btnSoldOut.setEnabled(false);
		east.add(btnRefund);
		btnRefund.setEnabled(false);
		east.add(btnAdmin);
		btnAdmin.setBackground(Color.black);
		btnAdmin.setForeground(Color.white);
		east.setLayout(new GridLayout(3, 1, 20, 40));
		frame.add("East", east);

		// south panel placing
		south.add(lblDispenser);
		south.add(lblChange);
		south.add(txtDispenser);
		south.add(txtChange);
		txtDispenser.setEditable(false);
		txtChange.setEditable(false);
		south.setLayout(new GridLayout(2,2,40,0));
		south.setBorder(new EmptyBorder(0, 40, 20, 50));
		frame.add("South", south);

		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		eventHandler();
		ResultEventHandler.addEventListner(this);
	}



	@Override
	public void resultCallBack(String result, String msg) {
		// TODO Auto-generated method stub
		if (result.equals("success")) {
			String temp = String.valueOf(controller.giveChange());
			btnRefund.setEnabled(false);
			txtDispenser.setText("제조 완료. 디스펜서에서 음료를 가져가세요.");
			if (controller.giveChange() > 0) {
				JOptionPane.showMessageDialog(null, "잔돈 " + controller.giveChange() + "원을 반환합니다.");
				coinslot.out(controller.giveChange());
			}
			offBtn();
			controller.init();
			txtInput.setText("");
		} else {
			txtError.setText(msg);
			btnSoldOut.setEnabled(true);
		}
	}



	public void eventHandler() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);	
			}	
		});

		btn100.addActionListener(this);
		btn500.addActionListener(this);
		btn1000.addActionListener(this);
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
		btnAdmin.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if(obj==btn100) btn100_Click();
		if(obj==btn500) btn500_Click();
		if(obj==btn1000) btn1000_Click();
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
		if(obj==btnAdmin) btnAdmin_Click();

	}

	public void btn100_Click() {

		controller.acceptMoney(100);
		coinslot.accept(100);

		String t = String.valueOf(controller.getMoney());
		txtInput.setText(t);

		// input < controller.product.getProductPrice()
		if (!controller.checkMoney()) {
			txtError.setText("돈이 부족합니다!");
			txtError.setForeground(Color.red);
		} else {
			txtError.setText("커피 종류를 선택하세요.");
			txtError.setForeground(Color.blue);
			btnRefund.setEnabled(true);
			lightBtn(controller.getMoney());
		}
	}

	public void btn500_Click() {
		controller.acceptMoney(500);
		coinslot.accept(500);

		String t = String.valueOf(controller.getMoney());
		txtInput.setText(t);

		if (!controller.checkMoney()) {
			txtError.setText("돈이 부족합니다!");
			txtError.setForeground(Color.red);
		} else {
			txtError.setText("커피 종류를 선택하세요.");
			txtError.setForeground(Color.blue);
			btnRefund.setEnabled(true);
			lightBtn(controller.getMoney());
		}
	}

	public void btn1000_Click() {

		controller.acceptMoney(1000);
		noteslot.accept(1000);

		String t = String.valueOf(controller.getMoney());
		txtInput.setText(t);

		if (!controller.checkMoney()) {
			txtError.setText("돈이 부족합니다!");
			txtError.setForeground(Color.red);
		} else {
			txtError.setText("커피 종류를 선택하세요.");
			txtError.setForeground(Color.blue);
			btnRefund.setEnabled(true);
			lightBtn(controller.getMoney());
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

		if (controller.checkChange(controller.getMoney())) {
			JOptionPane.showMessageDialog(null, "일반커피 " + coffeenum + "의 제조를 시작합니다.");
			makingMsg();
		} else {
			txtError.setText("잔돈이 부족합니다.");
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

		if (controller.checkChange(controller.getMoney())) {
			JOptionPane.showMessageDialog(null, "믹스커피 " + coffeenum + "의 제조를 시작합니다.");
			System.out.println();
			makingMsg();
		} else {
			txtError.setText("잔돈이 부족합니다.");
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

		if (controller.checkChange(controller.getMoney())) {
			JOptionPane.showMessageDialog(null, "일반차 " + coffeenum + "의 제조를 시작합니다.");
			makingMsg();
		} else {
			txtError.setText("잔돈이 부족합니다.");
		}
	}

	public void btnRefund_Click() {
		JOptionPane.showMessageDialog(null, "환불을 진행합니다.");
		controller.refundMoney();
		txtInput.setText("");
		txtError.setText("환불 완료");
		coinslot.out(controller.getMoney());
		txtError.setForeground(Color.blue);
		btnRefund.setEnabled(false);
		//atxtMoney.setEditable(true);
		offBtn();
	}

	public void lightBtn(int money) {

		if (money >= 500) {
			btnCoffee1.setEnabled(true);
			btnCoffee2.setEnabled(true);
			btnCoffee3.setEnabled(true);
			btnMCoffee1.setEnabled(true);
			btnMCoffee2.setEnabled(true);
			btnMCoffee3.setEnabled(true);
			btnNCoffee1.setEnabled(true);
			btnNCoffee2.setEnabled(true);
			btnNCoffee3.setEnabled(true);
		} else if (money >= 400) {
			btnCoffee1.setEnabled(true);
			btnCoffee2.setEnabled(true);
			btnMCoffee1.setEnabled(true);
			btnMCoffee2.setEnabled(true);
			btnNCoffee1.setEnabled(true);
			btnNCoffee2.setEnabled(true);
			
		} else {
			btnCoffee1.setEnabled(true);
			btnMCoffee1.setEnabled(true);
			btnNCoffee1.setEnabled(true);
		}
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
	
	public void btnAdmin_Click() {
		new AdminPage();
	}

	public void makingMsg() {
		this.sleep(2000);
		controller.startMaking();
	}


	public void sleep (int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
	}

	public static void main(String[] args){
		new FrontPanel();
	}

}