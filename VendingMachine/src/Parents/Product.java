package Parents;


public class Product {

	protected int productId;
	
	protected int amountOfCoffeePowder;
	protected int amountOfCreamPowder;
	protected int amountOfSugarPowder;
	protected int amountOfWater;
	protected int productPrice;
	protected String productName;
	

	public Product() {
		
	}
	
	public Product(int amountOfCoffeePowder, int amountOfCreamPowder, int amountOfSugarPowder,
			int amountOfWater) {
		super();
	
		this.amountOfCoffeePowder = amountOfCoffeePowder;
		this.amountOfCreamPowder = amountOfCreamPowder;
		this.amountOfSugarPowder = amountOfSugarPowder;
		this.amountOfWater = amountOfWater;

	}

	public int getProductId() {
		return productId;
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

	public int getProductPrice() {
		return productPrice;
	}

	public String getProductName() {
		return productName;
	}
	
	
	
	
	
}
