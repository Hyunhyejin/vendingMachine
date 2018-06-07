package Money;

import Parents.MoneySlot;
import Parents.MoneyStack;

public class CoinSlot extends MoneySlot{

	private int money;
	@Override
	public void accept(int money) {
		// TODO Auto-generated method stub
		this.money = money;
	}
	
	public int out(int money) {
		return money;
	}
}
