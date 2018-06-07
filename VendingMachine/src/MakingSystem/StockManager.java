package MakingSystem;

public class StockManager {
	private static int amount_water = WaterTank.getCurAmountOfWater();
	private static int amount_coffee_powder = CoffeeHolder.getCurAmountOfPowder();
	private static int amount_sugar_powder = SugarHolder.getCurAmountOfPowder();
	private static int amount_cream_powder = CreamHolder.getCurAmountOfPowder();
	private static int amount_cup = CupStack.getSize();
	private static final int MAX_CAPACITY_OF_HOLDER = 500;	
	
	public static int getAmount_water() {
		return amount_water;
	}
	public static void addAmount_water(int amount_water) {
		WaterTank.setCurAmountOfWater(StockManager.amount_water + amount_water); 
	}
	public static void setAmount_water(int amount_water) {
		StockManager.amount_water = amount_water;
	}
	public static void setAmount_coffee_powder(int amount_coffee_powder) {
		StockManager.amount_coffee_powder = amount_coffee_powder;
	}
	public static void setAmount_sugar_powder(int amount_sugar_powder) {
		StockManager.amount_sugar_powder = amount_sugar_powder;
	}
	public static void setAmount_cream_powder(int amount_cream_powder) {
		StockManager.amount_cream_powder = amount_cream_powder;
	}
	public static void setAmount_cup(int amount_cup) {
		StockManager.amount_cup = amount_cup;
	}
	public static int getAmount_coffee_powder() {
		return amount_coffee_powder;
	}
	public static void addAmount_coffee_powder(int amount_coffee_powder) {
		CoffeeHolder.setCurAmountOfPowder(StockManager.amount_coffee_powder + amount_coffee_powder);
	}
	public static int getAmount_sugar_powder() {
		return amount_sugar_powder;
	}
	public static void addAmount_sugar_powder(int amount_sugar_powder) {
		SugarHolder.setCurAmountOfPowder(StockManager.amount_sugar_powder + amount_sugar_powder);
	}
	public static int getAmount_cream_powder() {
		return amount_cream_powder;
	}
	public static void addAmount_cream_powder(int amount_cream_powder) {
		CreamHolder.setCurAmountOfPowder(StockManager.amount_cream_powder + amount_cream_powder);
	}
	public static int getAmount_cup() {
		return amount_cup;
	}
	public static void addAmount_cup(int amount_cup) {
		for(int i =0; i<amount_cup; i++) {
			CupStack.put(new Cup());
		}		
	}
	public static int getMaxCapacityOfHolder() {
		return MAX_CAPACITY_OF_HOLDER;
	}
	
	

}
