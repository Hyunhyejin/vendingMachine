import java.awt.*;

import javax.swing.*;


public class vendingFront extends JFrame{
	
	// 최상단 패널 (money slot) 세팅
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("돈 투입"); 
	JTextField txtMoney = new JTextField(20);
	
	// 서쪽 패널 (커피 버튼) 세팅
	
	// 중앙 패널 (자판기 상태) 세팅
	
	// 동쪽 패널 (재고 현황) 세팅
	
	// 남쪽 패널 (디스펜서) 세팅
	
	public vendingFront(){
		super("vending machine"); 
		
		// upper panel placing
		upper.add(txtMoney);
		upper.add(btnMoney);
		upper.setLayout(new FlowLayout());
		add(upper);
		
		
		setSize(800, 500); // 윈도우의 크기 가로x세로
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new vendingFront();
	} 

}