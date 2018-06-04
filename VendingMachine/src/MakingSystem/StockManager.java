package MakingSystem;

public class StockManager {
	private int amount_water = WaterTank.getCurAmountOfWater();
	private int amount_coffee_powder = CoffeeHolder.getCurAmountOfPowder();
	private int amount_sugar_powder = SugarHolder.getCurAmountOfPowder();
	private int amount_cream_powder = CreamHolder.getCurAmountOfPowder();
	private int amount_cup = CupStack.getSize();
	
	public int getAmount_water() {
		return amount_water;
	}
	public void addAmount_water(int amount_water) {
		WaterTank.setCurAmountOfWater(this.amount_water + amount_water); 
	}
	public void setAmount_water(int amount_water) {
		this.amount_water = amount_water;
	}
	public void setAmount_coffee_powder(int amount_coffee_powder) {
		this.amount_coffee_powder = amount_coffee_powder;
	}
	public void setAmount_sugar_powder(int amount_sugar_powder) {
		this.amount_sugar_powder = amount_sugar_powder;
	}
	public void setAmount_cream_powder(int amount_cream_powder) {
		this.amount_cream_powder = amount_cream_powder;
	}
	public void setAmount_cup(int amount_cup) {
		this.amount_cup = amount_cup;
	}
	public int getAmount_coffee_powder() {
		return amount_coffee_powder;
	}
	public void addAmount_coffee_powder(int amount_coffee_powder) {
		CoffeeHolder.setCurAmountOfPowder(this.amount_coffee_powder + amount_coffee_powder);
	}
	public int getAmount_sugar_powder() {
		return amount_sugar_powder;
	}
	public void addAmount_sugar_powder(int amount_sugar_powder) {
		SugarHolder.setCurAmountOfPowder(this.amount_sugar_powder + amount_sugar_powder);
	}
	public int getAmount_cream_powder() {
		return amount_cream_powder;
	}
	public void addAmount_cream_powder(int amount_cream_powder) {
		CreamHolder.setCurAmountOfPowder(this.amount_cream_powder + amount_cream_powder);
	}
	public int getAmount_cup() {
		return amount_cup;
	}
	public void addAmount_cup(int amount_cup) {
		for(int i =0; i<amount_cup; i++) {
			CupStack.put(new Cup());
		}		
	}
	

}
