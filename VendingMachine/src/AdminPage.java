import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

import javax.swing.*;
import javax.swing.border.*;

import MakingSystem.CoffeeHolder;
import MakingSystem.CupStack;
import MakingSystem.StockManager;
import MakingSystem.WaterTank;
import Parents.Holder;

public class AdminPage extends JFrame implements ActionListener {
	
	// JPanel 생성
	JPanel west = new JPanel();
	JPanel east = new JPanel();
	JPanel north = new JPanel();
	
	// JLabel 생성 (컵, 커피, 가루, 코인 스택)
	JLabel lblCoffee = new JLabel("커피 재고");
	JLabel lblPowder1 = new JLabel("크림 파우더 재고");
	JLabel lblPowder2 = new JLabel("설탕 파우더 재고");
	JLabel lblWater = new JLabel("남은 물 양");
	JLabel lblCoin = new JLabel("잔돈 양");
	JLabel lblCup = new JLabel ("컵 수량");
	JLabel lblTitle = new JLabel("Admin Page");
	
	// JTextField 생성
	JTextField stockCoffee = new JTextField(20);
	JTextField stockCreamPowder = new JTextField(20);
	JTextField stockSugarPowder = new JTextField(20);
	JTextField stockWater = new JTextField(20);
	JTextField stockCoin = new JTextField(20);
	JTextField stockCup = new JTextField(20);
	
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
		
		west.setLayout(new GridLayout(5,1,10,10));
		west.setBorder(new EmptyBorder(0, 10, 0, 0));
		west.add(lblCoffee);
		west.add(lblPowder1);
		west.add(lblPowder2);
		west.add(lblWater);
		west.add(lblCup);
		add("West", west);
		
		east.setLayout(new GridLayout(5,1,10,10));
		east.setBorder(new EmptyBorder(0, 30, 0, 50));
		east.add(stockCoffee);
		east.add(stockCreamPowder);
		east.add(stockSugarPowder);
		east.add(stockWater);
		east.add(stockCup);
		add("Center", east);
		
		south.setLayout(new FlowLayout());
		south.setBorder(new EmptyBorder(10, 0, 10, 0));
		south.add(btnApply);
		south.add(btnReset);
		south.add(btnExit);
		add("South", south);
		
		int tmpCoffee = StockManager.getAmount_coffee_powder();
		String tmpC = Integer.toString(tmpCoffee);
		stockCoffee.setText(tmpC);
		
		int tmpCream = StockManager.getAmount_cream_powder();
		String tmpCr = Integer.toString(tmpCream);
		stockCreamPowder.setText(tmpCr);
		
		int tmpSugar = StockManager.getAmount_sugar_powder();
		String tmpS = Integer.toString(tmpSugar);
		stockSugarPowder.setText(tmpS);
		
		int tmpWater = StockManager.getAmount_water();
		String tmpW = Integer.toString(tmpWater);
		stockWater.setText(tmpW);
		
		int tmpCup = StockManager.getAmount_cup();
		String tmpCu = Integer.toString(tmpCup);
		stockCup.setText(tmpCu);
		
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

	@Override
	public void actionPerformed(ActionEvent a) {
		Object obj = a.getSource();
		
		if (obj == btnExit) exitWindow();
		if (obj == btnApply) applySetting();
		if (obj == btnReset) resetSetting();
		
	}
	
	public void exitWindow() {
		System.exit(0);
	}
	
	public void applySetting() {
		String Ct = stockCoffee.getText();
		int Coffeetmp = Integer.parseInt(Ct);
		
		String Crt = stockCreamPowder.getText();
		int CreamPowdertmp = Integer.parseInt(Crt);
		
		String St = stockSugarPowder.getText();
		int SugarPowdertmp = Integer.parseInt(St);
	
		String Cupt = stockCup.getText();
		int Cuptmp = Integer.parseInt(Cupt);
	
		String Watert = stockWater.getText();
		int Watertmp = Integer.parseInt(Watert);
		
		if(CupStack.MAX_COUNT_OF_CUP - Cuptmp < Cuptmp) {
			StockManager.addAmount_cup(Cuptmp);
		}
		
		if(WaterTank.MAX_CAPACITY - Watertmp < Watertmp) {
			StockManager.addAmount_water(Watertmp);
		}
		
		if(StockManager.getMaxCapacityOfHolder()-Coffeetmp <Coffeetmp) {
			StockManager.addAmount_coffee_powder(Coffeetmp);
		}
		
		if(StockManager.getMaxCapacityOfHolder()-CreamPowdertmp <CreamPowdertmp) {
			StockManager.addAmount_cream_powder(CreamPowdertmp);
		}
		
		if(StockManager.getMaxCapacityOfHolder()-SugarPowdertmp <SugarPowdertmp) {
			StockManager.addAmount_sugar_powder(SugarPowdertmp);
		}
		
		
	}
	
	public void resetSetting() {
		int tmpCoffee = StockManager.getAmount_coffee_powder();
		String tmpC = Integer.toString(tmpCoffee);
		stockCoffee.setText(tmpC);
		
		int tmpCream = StockManager.getAmount_cream_powder();
		String tmpCr = Integer.toString(tmpCream);
		stockCreamPowder.setText(tmpCr);
		
		int tmpSugar = StockManager.getAmount_sugar_powder();
		String tmpS = Integer.toString(tmpSugar);
		stockSugarPowder.setText(tmpS);
		
		int tmpWater = StockManager.getAmount_water();
		String tmpW = Integer.toString(tmpWater);
		stockWater.setText(tmpW);
		
		int tmpCup = StockManager.getAmount_cup();
		String tmpCu = Integer.toString(tmpCup);
		stockCup.setText(tmpCu);
	}
	
	public static void main (String[] args) {
		new AdminPage();
	}
	
}