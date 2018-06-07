package MakingSystem;
import Parents.Holder;

public class CreamHolder extends Holder {

	private static int curAmountOfPowder = 50;	//현재 홀더에 채워져 있는 가루의 양.

	
	public CreamHolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int getCurAmountOfPowder() {
		return curAmountOfPowder;
	}
	
	public static void setCurAmountOfPowder(int curAmountOfPowder) {
		CreamHolder.curAmountOfPowder = curAmountOfPowder;
	}


	@Override
	public int putPowderInMixPipe(int amount) {
		// TODO Auto-generated method stub
		
		if(curAmountOfPowder < (amount)) {
			return -1;
		}else {
			curAmountOfPowder -= amount;
			return amount;
		}
	}
	
}
