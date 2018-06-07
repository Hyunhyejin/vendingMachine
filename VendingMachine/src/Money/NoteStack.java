package Money;

import Parents.MoneyStack;

public class NoteStack extends MoneyStack {

	private int account_1000 = 10;

	@Override
	public void addMoney(int money) {
		// TODO Auto-generated method stub
		account_1000++;
	}

}
