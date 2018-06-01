import java.awt.*;

import javax.swing.*;


public class vendingFront extends JFrame{
	// 최상단 패널 (money slot) 세팅
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("돈 투입"); 
	JTextField txtMoney = new JTextField(20);
	
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
	
	// 남쪽 패널 (디스펜서) 세팅
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