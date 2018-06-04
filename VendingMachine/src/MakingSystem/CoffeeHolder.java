package MakingSystem;


import java.beans.Customizer;

import Parents.Holder;

public class CoffeeHolder extends Holder {

	private final int POWDER_TYPE = 1;		//홀더에 들어가는 가루의 타입, 0 = 설탕, 1= 가루1, 2 = 가루2
	private static int curAmountOfPowder = 500;	//현재 홀더에 채워져 있는 가루의 양.
	
	//생성자
	public CoffeeHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public int getPOWDER_TYPE() {
		return POWDER_TYPE;
	}




	public static int getCurAmountOfPowder() {
		return curAmountOfPowder;
	}
	
	public static void setCurAmountOfPowder(int curAmountOfPowde) {
		CoffeeHolder.curAmountOfPowder = curAmountOfPowde;
	}




	@Override
	public int putPowderInMixPipe(int amount) {
		// TODO Auto-generated method stub
		
		if(curAmountOfPowder < (amount)) {
			return -1;
		}else {
			curAmountOfPowder -=amount;
			System.out.println(curAmountOfPowder);
			return amount;
		}
		
	}
	
	
	


}
