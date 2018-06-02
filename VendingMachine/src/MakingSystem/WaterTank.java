package MakingSystem;


public class WaterTank{
	
	private int tempuratureOfWater;	//���� ����ũ�� �ִ� ���� �µ�
	private int curAmountOfWater;	//���� ����ũ�� �ִ� ���� ��
	private final int MIN_CAPACITY = 70;	//����ũ�� �ּ� �뷮 = 70mL
	private final int MAX_CAPACITY = 2700;	//����ũ�� �ִ� �뷮 = 2700ml = 2.7L
	
	private String errorMsg;
	
	//Ŭ���� ������.
	public WaterTank() {
		this.curAmountOfWater = 2000;
		this.tempuratureOfWater = 90;
	}
	
	public int getTempuratureOfWater() {
		return tempuratureOfWater;
	}



	public void setTempuratureOfWater(int tempuratureOfWater) {
		this.tempuratureOfWater = tempuratureOfWater;
	}



	public int getCurAmountOfWater() {
		return curAmountOfWater;
	}



	public void setCurAmountOfWater(int curAmountOfWater) {
		this.curAmountOfWater = curAmountOfWater;
	}



	/*
	 * ���� ����ũ�� �ִ� ���� �뷮�� üũ �ؼ� �Ҹ����� ��ȯ�ϴ� �޼ҵ�
	 * */
	public boolean checkProperAmountOfWater() {
		boolean isCapacity = curAmountOfWater > MIN_CAPACITY ? true : false;
		
		if(!isCapacity) {
			errorMsg = "������.";
		}
		
		return isCapacity;
	}
	
	public String sendError() {
		return errorMsg;
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