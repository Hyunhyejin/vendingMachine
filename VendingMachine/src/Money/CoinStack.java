package Money;

import Parents.MoneyStack;

public class CoinStack extends MoneyStack{
	public  int account_100 = 1000;
	public  int account_500 = 1000;
	
	
	public  void outCoinMoney(int money) {
		int out_count = money / 100;
		account_100 -= out_count;
	}

	@Override
	public void addMoney(int money) {
		// TODO Auto-generated method stub
		if (money == 100)
			account_100++;
		else if (money == 500)
			account_500++;
	}
	
	
	
	
	
	
}
