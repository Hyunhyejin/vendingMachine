import java.awt.*;

import javax.swing.*;


public class vendingFront extends JFrame{
	
	// �ֻ�� �г� (money slot) ����
	JPanel upper = new JPanel();
	JButton btnMoney = new JButton("�� ����"); 
	JTextField txtMoney = new JTextField(20);
	
	// ���� �г� (Ŀ�� ��ư) ����
	
	// �߾� �г� (���Ǳ� ����) ����
	
	// ���� �г� (��� ��Ȳ) ����
	
	// ���� �г� (���漭) ����
	
	public vendingFront(){
		super("vending machine"); 
		
		// upper panel placing
		upper.add(txtMoney);
		upper.add(btnMoney);
		upper.setLayout(new FlowLayout());
		add(upper);
		
		
		setSize(800, 500); // �������� ũ�� ����x����
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new vendingFront();
	} 

}