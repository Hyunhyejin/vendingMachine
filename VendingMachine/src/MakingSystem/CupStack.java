package MakingSystem;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Parents.Product;
import Parents.VendingMachineStack;

public class CupStack {

	private final static int MAX_COUNT_OF_CUP = 100;
	private static Queue<Cup> cups =  new LinkedList<Cup>();

	public CupStack() {
		super();
		for(int i =0; i<100; i++) {
			cups.offer(new Cup());
		}
		
	}

	public static void put(Object ins) {
		// TODO Auto-generated method stub
		if(cups.size() < MAX_COUNT_OF_CUP) {
			cups.offer((Cup)ins);
		}else {
			System.out.println("�� �̻� ���� ���� �� �����ϴ�.");
		}
	}

	public Object get() {
		// TODO Auto-generated method stub
		
		if(cups.peek()!=null) {
			
			return cups.poll();
		}
		
		return null;
	}
	
	public static int getSize() {
		return cups.size();
	}
	
}

class Cup{
	
	private final int CAPACITY = 180;	//���� ml
	private Product productInCup;
	
	public Product getProductInCup() {
		return productInCup;
	}
	public void setProductInCup(Product productInCup) {
		this.productInCup = productInCup;
	}
}
