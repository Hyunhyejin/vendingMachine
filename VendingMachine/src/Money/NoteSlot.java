package Money;

import Parents.MoneySlot;

public class NoteSlot extends MoneySlot {

	private int money;
	@Override
	public void accept(int money) {
		// TODO Auto-generated method stub
		this.money = money;
	}

}
