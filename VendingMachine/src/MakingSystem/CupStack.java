package MakingSystem;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Parents.Product;

public class CupStack implements Stack {

	private final int MAX_COUNT_OF_CUP = 100;
	private Queue<Cup> cups;

	public CupStack() {
		super();
		cups = new LinkedList<Cup>();
		for(int i =0; i<3; i++) {
			cups.offer(new Cup());
		}
		
	}

	@Override
	public void put(Object ins) {
		// TODO Auto-generated method stub
		if(cups.size() < MAX_COUNT_OF_CUP) {
			cups.offer((Cup)ins);
		}else {
			System.out.println("더 이상 컵을 넣을 수 없습니다.");
		}
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		
		if(cups.peek()!=null) {
			return cups.poll();
		}
		
		return null;
	}

}

class Cup{
	
	private final int CAPACITY = 180;	//단위 ml
	private Product productInCup;
	
	public Product getProductInCup() {
		return productInCup;
	}
	public void setProductInCup(Product productInCup) {
		this.productInCup = productInCup;
	}
}
