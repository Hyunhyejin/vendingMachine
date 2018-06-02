package MakingSystem;
import Parents.Product;
import Product.Coffee1;
import Product.Coffee2;
import Product.Coffee3;
import Product.MixCoffee1;
import Product.MixCoffee2;
import Product.MixCoffee3;

public class MixPipe {
	
	int curAmountOfWater;	//현재 믹스 파이프에 있는 물의 양
	int curAmountOfCoffee;	//현재 믹스 파이프에 있는 커피의 양
	int curAmountOfCream;	//현재 믹스 파이프에 있는 크림의 양
	int curAmountOfSugar;	//현태 믹스 파이프에 있는 설탕의 양
	
	public int getCurAmountOfWater() {
		return curAmountOfWater;
	}
	public void setCurAmountOfWater(int curAmountOfWater) {
		this.curAmountOfWater = curAmountOfWater;
	}
	public int getCurAmountOfCoffee() {
		return curAmountOfCoffee;
	}
	public void setCurAmountOfCoffee(int curAmountOfCoffee) {
		this.curAmountOfCoffee = curAmountOfCoffee;
	}
	public int getCurAmountOfCream() {
		return curAmountOfCream;
	}
	public void setCurAmountOfCream(int curAmountOfCream) {
		this.curAmountOfCream = curAmountOfCream;
	}
	public int getCurAmountOfSugar() {
		return curAmountOfSugar;
	}
	public void setCurAmountOfSugar(int curAmountOfSugar) {
		this.curAmountOfSugar = curAmountOfSugar;
	}
	
	
	Product mix(int coffeeP, int creamP, int sugarP, int water) {
		Product p = new Product(coffeeP, creamP, sugarP, water);
		return p;
	
	}
	

}
