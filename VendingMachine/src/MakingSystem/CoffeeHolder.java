package MakingSystem;

import java.beans.Customizer;

import Parents.Holder;

public class CoffeeHolder extends Holder {

	private final int POWDER_TYPE = 1;		//Ȧ���� ���� ������ Ÿ��, 0 = ����, 1= ����1, 2 = ����2
	private int curAmountOfPowder = 11;	//���� Ȧ���� ä���� �ִ� ������ ��.
	
	//������
	public CoffeeHolder() {
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
			curAmountOfPowder -=amount;
			System.out.println(curAmountOfPowder);
			return amount;
		}
		
	}
	
	
	


}
