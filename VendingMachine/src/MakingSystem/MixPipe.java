package MakingSystem;


public class MixPipe {
	
	int curAmountOfWater;	//���� �ͽ� �������� �ִ� ���� ��
	int curAmountOfCoffee;	//���� �ͽ� �������� �ִ� Ŀ���� ��
	int curAmountOfCream;	//���� �ͽ� �������� �ִ� ũ���� ��
	int curAmountOfSugar;	//���� �ͽ� �������� �ִ� ������ ��
	int curAmountOfTea;
	
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
	public int getCurAmountOfTea() {
		return curAmountOfTea;
	}
	public void setCurAmountOfTea(int curAmountOfTea) {
		this.curAmountOfTea = curAmountOfTea;
	}
	
	
	Product mix(int coffeeP, int creamP, int sugarP, int water, int teaP) {
		Product p = new Product(coffeeP, creamP, sugarP, water,teaP);
		return p;
	
	}
	

}
