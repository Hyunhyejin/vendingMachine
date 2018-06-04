package Money;

import Parents.Slot;

public class CoinSlot extends Slot{

	@Override
	public void accept(int money) {
		// TODO Auto-generated method stub
		CoinStack.addCoinMoney(money);		
	}
	
	public void out(int money) {
		CoinStack.outCoinMoney(money);
	}

}
