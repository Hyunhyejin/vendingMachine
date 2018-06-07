package MakingSystem;


public class WaterTank{
	
	private int tempuratureOfWater;	//���� ����ũ�� �ִ� ���� �µ�
	private static int curAmountOfWater =2000;	//���� ����ũ�� �ִ� ���� ��
	public static final int MIN_CAPACITY = 70;	//����ũ�� �ּ� �뷮 = 70mL
	public static final int MAX_CAPACITY = 2700;	//����ũ�� �ִ� �뷮 = 2700ml = 2.7L

	
	//Ŭ���� ������.
	public WaterTank() {
		//this.curAmountOfWater = 2000;
		this.tempuratureOfWater = 90;
	}
	
	public int getTempuratureOfWater() {
		return tempuratureOfWater;
	}

	public void setTempuratureOfWater(int tempuratureOfWater) {
		this.tempuratureOfWater = tempuratureOfWater;
	}


	public static int getCurAmountOfWater() {
		return curAmountOfWater;
	}

	public static void setCurAmountOfWater(int curAmountOfWater) {
		WaterTank.curAmountOfWater = curAmountOfWater;
	}



	/*
	 * ���� ����ũ�� �ִ� ���� �뷮�� üũ �ؼ� �Ҹ����� ��ȯ�ϴ� �޼ҵ�
	 * */
	public boolean checkProperAmountOfWater() {
		boolean isCapacity = curAmountOfWater > MIN_CAPACITY ? true : false;

		return isCapacity;
	}

	public int putWaterInMixPipe(int amount) {
		
		if(curAmountOfWater < (amount)) {
			return -1;
		}else {
			curAmountOfWater -=amount;
			return amount;
		}
		
	}
	
	
	
}