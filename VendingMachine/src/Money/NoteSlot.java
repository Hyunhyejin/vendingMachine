package Money;

import Parents.Slot;

public class NoteSlot extends Slot {

	@Override
	public void accept(int money) {
		// TODO Auto-generated method stub
		NoteStack.addNoteMoney(money);
	}

}
