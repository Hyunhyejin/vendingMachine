package MakingSystem;
import Parents.Holder;

public class CreamHolder extends Holder {

	private final int POWDER_TYPE = 2;
	private int curAmountOfPowder = 11;	//���� Ȧ���� ä���� �ִ� ������ ��.

	
	public CreamHolder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getPOWDER_TYPE() {
		return POWDER_TYPE;
	}



	public int getCurAmountOfPowder() {
		return curAmountOfPowder;
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
