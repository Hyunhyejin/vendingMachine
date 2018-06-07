package MakingSystem;

import Parents.Holder;

public class TeaHolder extends Holder{

	private static int curAmountOfPowder = 500;	//현재 홀더에 채워져 있는 가루의 양.


	public static int getCurAmountOfPowder() {
		return curAmountOfPowder;
	}
	
	public static void setCurAmountOfPowder(int curAmountOfPowde) {
		TeaHolder.curAmountOfPowder = curAmountOfPowde;
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
