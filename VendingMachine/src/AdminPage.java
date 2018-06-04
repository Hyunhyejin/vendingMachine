import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AdminPage extends JFrame implements ActionListener {
	
	// JPanel 생성
	JPanel west = new JPanel();
	JPanel east = new JPanel();
	JPanel north = new JPanel();
	
	// JLabel 생성 (컵, 커피, 가루, 코인 스택)
	JLabel lblCoffee = new JLabel("커피 재고");
	JLabel lblPowder1 = new JLabel("파우더 1 재고");
	JLabel lblPowder2 = new JLabel("파우더 2 재고");
	JLabel lblPowder3 = new JLabel("파우더 3 재고");
	JLabel lblWater = new JLabel("남은 물 양");
	JLabel lblCoin = new JLabel("잔돈 양");
	JLabel lblTitle = new JLabel("Admin Page");
	
	// JTextField 생성
	JTextField stockCoffee = new JTextField(20);
	JTextField stockPowder1 = new JTextField(20);
	JTextField stockPowder2 = new JTextField(20);
	JTextField stockPowder3 = new JTextField(20);
	JTextField stockWater = new JTextField(20);
	JTextField stockCoin = new JTextField(20);
	
	// 남쪽 패널
	JPanel south =  new JPanel();
	JButton btnExit = new JButton("관리자 모드 종료");
	JButton btnApply = new JButton("결과 적용");
	JButton btnReset = new JButton("초기화");
	
	public AdminPage() {
		north.add(lblTitle);
		lblTitle.setFont(new Font(Font.SANS_SERIF, Font.PLAIN|Font.BOLD, 16));
		lblTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
		add("North", north);
		
		west.setLayout(new GridLayout(6,1,10,10));
		west.setBorder(new EmptyBorder(0, 10, 0, 0));
		west.add(lblCoffee);
		west.add(lblPowder1);
		west.add(lblPowder2);
		west.add(lblPowder3);
		west.add(lblCoin);
		west.add(lblWater);
		add("West", west);
		
		east.setLayout(new GridLayout(6,1,10,10));
		east.setBorder(new EmptyBorder(0, 30, 0, 50));
		east.add(stockCoffee);
		east.add(stockPowder1);
		east.add(stockPowder2);
		east.add(stockPowder3);
		east.add(stockCoin);
		east.add(stockWater);
		add("Center", east);
		
		south.setLayout(new FlowLayout());
		south.setBorder(new EmptyBorder(10, 0, 10, 0));
		south.add(btnApply);
		south.add(btnReset);
		south.add(btnExit);
		add("South", south);
		
		setSize(600, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		eventHandler();
	}
	
	public void eventHandler() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);	
			}	
		});
		
		btnExit.addActionListener(this);
		btnApply.addActionListener(this);
		btnReset.addActionListener(this);
	}
	
	public static void main (String[] args) {
		new AdminPage();
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		Object obj = a.getSource();
		
		if (obj == btnExit) btnExit_Click();
		if (obj == btnApply) btnApply_Click();
		if (obj == btnReset) btnReset_Click();
		
	}
	
	public void btnExit_Click() {
		
	}
	
	public void btnApply_Click() {
		
	}
	
	public void btnReset_Click() {
		
	}
	
}
