package MakingSystem;
import Parents.Holder;

public class SugarHolder extends Holder {
	private final int POWDER_TYPE = 0;	
	
	private static int curAmountOfPowder = 500;	//���� Ȧ���� ä���� �ִ� ������ ��.

	
	
	public int getPOWDER_TYPE() {
		return POWDER_TYPE;
	}



	public static int getCurAmountOfPowder() {
		return curAmountOfPowder;
	}
	
	public static void setCurAmountOfPowder(int curAmountOfPowder) {
		SugarHolder.curAmountOfPowder = curAmountOfPowder;
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

