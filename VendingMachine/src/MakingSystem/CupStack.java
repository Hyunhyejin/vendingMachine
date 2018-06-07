package MakingSystem;


public class CupStack {

	public final static int MAX_COUNT_OF_CUP = 100;
	private static int curCupCount = 100;

	public CupStack() {
		super();
	}

	
	public void put(int cupCount) {
		curCupCount += cupCount;
	}
	
	public Cup get() {
		curCupCount --;
		return new Cup();
	}


	public static int getCurCupCount() {
		return curCupCount;
	}


	public static void setCurCupCount(int curCupCount) {
		CupStack.curCupCount = curCupCount;
	}

	
}

class Cup{
	
	private final int CAPACITY = 180;	//¥‹¿ß ml
	private Product productInCup;
	
	public Product getProductInCup() {
		return productInCup;
	}
	public void setProductInCup(Product productInCup) {
		this.productInCup = productInCup;
	}
}
