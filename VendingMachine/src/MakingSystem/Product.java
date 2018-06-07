package MakingSystem;

public class Product {

	protected int amountOfCoffeePowder;
	protected int amountOfCreamPowder;
	protected int amountOfSugarPowder;
	protected int amountOfWater;
	protected int amountOfTeaPowder;
	protected int productPrice;
	protected String productName;
	

	public Product(int amountOfCoffeePowder, int amountOfCreamPowder, int amountOfSugarPowder,
			int amountOfWater, int amountOfTeaPowder,String name, int price) {
	
		this.amountOfCoffeePowder = amountOfCoffeePowder;
		this.amountOfCreamPowder = amountOfCreamPowder;
		this.amountOfSugarPowder = amountOfSugarPowder;
		this.amountOfWater = amountOfWater;
		this.amountOfTeaPowder = amountOfTeaPowder;
		this.productName = name;
		this.productPrice = price;

	}
	
	public Product(int amountOfCoffeePowder, int amountOfCreamPowder, int amountOfSugarPowder,
			int amountOfWater, int amountOfTeaPowder) {
		this.amountOfCoffeePowder = amountOfCoffeePowder;
		this.amountOfCreamPowder = amountOfCreamPowder;
		this.amountOfSugarPowder = amountOfSugarPowder;
		this.amountOfWater = amountOfWater;
		this.amountOfTeaPowder = amountOfTeaPowder;
	}



	public int getAmountOfCoffeePowder() {
		return amountOfCoffeePowder;
	}

	public int getAmountOfCreamPowder() {
		return amountOfCreamPowder;
	}

	public int getAmountOfSugarPowder() {
		return amountOfSugarPowder;
	}

	public int getAmountOfWater() {
		return amountOfWater;
	}
	public int getAmountOfTeaPowder() {
		return amountOfWater;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public String getProductName() {
		return productName;
	}
	
	
	
}
