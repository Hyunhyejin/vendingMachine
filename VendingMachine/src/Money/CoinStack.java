package Money;

public class CoinStack {
	public static int account_100 = 10;
	public static int account_500 = 10;
	
	public static void addCoinMoney(int coinmoney) {
		if (coinmoney == 100)
			account_100++;
		else if (coinmoney == 500)
			account_500++;
	}
	
	public static void outCoinMoney(int money) {
		int out_count = money / 100;
		account_100 -= out_count;
	}
	
	
}
