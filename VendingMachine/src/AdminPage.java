import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminPage extends JFrame {
	// JFrame 생성
	JFrame frame = new JFrame();
	
	// 메인 JPanel 생성
	JPanel panel = new JPanel();
	
	// JLabel 생성 (컵, 커피, 가루, 코인 스택)
	JLabel lblCoffee = new JLabel("커피 재고");
	JLabel lblPowder1 = new JLabel("파우더 1 재고");
	JLabel lblPowder2 = new JLabel("파우더 2 재고");
	JLabel lblPowder3 = new JLabel("파우더 3 재고");
	JLabel lblWater = new JLabel("남은 물 양");
	JLabel lblCoin = new JLabel("잔돈 양");
	
	// JTextField 생성
	JTextField stockCoffee = new JTextField(20);
	JTextField stockPowder1 = new JTextField(20);
	JTextField stockPowder2 = new JTextField(20);
	JTextField stockPowder3 = new JTextField(20);
	JTextField stockWater = new JTextField(20);
	JTextField stockCoin = new JTextField(20);
	
	public AdminPage() {
		panel.setLayout(new GridLayout(6,2,10,60));
		panel.add(lblCoffee);		panel.add(stockCoffee);
	}
	
	
	
}
