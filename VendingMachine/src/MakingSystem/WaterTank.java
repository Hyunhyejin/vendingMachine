package MakingSystem;

public class WaterTank{
	
	private int tempuratureOfWater;	//현재 물탱크에 있는 물의 온도
	private int curAmountOfWater;	//현재 뭍탱크에 있는 물의 양
	private final int MIN_CAPACITY = 70;	//물탱크의 최소 용량 = 70mL
	private final int MAX_CAPACITY = 2700;	//물탱크의 최대 용량 = 2700ml = 2.7L
	
	private String errorMsg;
	
	//클래스 생성자.
	public WaterTank() {
		this.curAmountOfWater = 2000;
		this.tempuratureOfWater = 50;
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
	 * 현재 물탱크에 있는 물의 용량을 체크 해서 불린값을 반환하는 메소드
	 * */
	public boolean checkProperAmountOfWater() {
		boolean isCapacity = curAmountOfWater > MIN_CAPACITY ? true : false;
		
		if(!isCapacity) {
			errorMsg = "물없다.";
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