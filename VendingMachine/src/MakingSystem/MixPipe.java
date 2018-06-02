package MakingSystem;
import Parents.Product;
import Product.Coffee1;
import Product.Coffee2;
import Product.Coffee3;
import Product.MixCoffee1;
import Product.MixCoffee2;
import Product.MixCoffee3;

public class MixPipe {
	
	int curAmountOfWater;	//���� �ͽ� �������� �ִ� ���� ��
	int curAmountOfCoffee;	//���� �ͽ� �������� �ִ� Ŀ���� ��
	int curAmountOfCream;	//���� �ͽ� �������� �ִ� ũ���� ��
	int curAmountOfSugar;	//���� �ͽ� �������� �ִ� ������ ��
	
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
		
		if(p instanceof Coffee1) {
			return new Coffee1();
		}else if(p instanceof Coffee2) {
			return new Coffee2();
		}else if(p instanceof Coffee3) {
			return new Coffee3();
		}else if(p instanceof MixCoffee1) {
			return new MixCoffee1();
		}else if(p instanceof MixCoffee2) {
			return new MixCoffee2();
		}else if(p instanceof MixCoffee3){
			return new MixCoffee3();
		}else {
			return null;
		}
		
	
	}
	

}
