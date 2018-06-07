package MakingSystem;


import java.beans.Customizer;

import Parents.Holder;

public class CoffeeHolder extends Holder {


	private static int curAmountOfPowder = 50;	//현재 홀더에 채워져 있는 가루의 양.

	//생성자
	public CoffeeHolder() {
		super();
		// TODO Auto-generated constructor stub
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
