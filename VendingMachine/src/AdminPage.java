import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminPage extends JFrame {
	
	// ���� JPanel ����
	JPanel panel = new JPanel();
	
	// JLabel ���� (��, Ŀ��, ����, ���� ����)
	JLabel lblCoffee = new JLabel("Ŀ�� ���");
	JLabel lblPowder1 = new JLabel("�Ŀ�� 1 ���");
	JLabel lblPowder2 = new JLabel("�Ŀ�� 2 ���");
	JLabel lblPowder3 = new JLabel("�Ŀ�� 3 ���");
	JLabel lblWater = new JLabel("���� �� ��");
	JLabel lblCoin = new JLabel("�ܵ� ��");
	
	// JTextField ����
	JTextField stockCoffee = new JTextField(20);
	JTextField stockPowder1 = new JTextField(20);
	JTextField stockPowder2 = new JTextField(20);
	JTextField stockPowder3 = new JTextField(20);
	JTextField stockWater = new JTextField(20);
	JTextField stockCoin = new JTextField(20);
	
	public AdminPage() {
		panel.setLayout(new GridLayout(6,2,10,60));
		panel.add(lblCoffee);		panel.add(stockCoffee);
		add(panel);
		
		setSize(600, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args) {
		new AdminPage();
	}
	
}
