package MakingSystem;
import java.util.Scanner;

public class MakingSystem extends Thread {
	
	private boolean state = false;	//makingSystem가동상태 true = 제품 만드는 중, false = 제품 만들고 있지 않음.
	
	private WaterTank waterTank;
	private CoilHeater coilHeater;
	
	private DummyProduct product;
	
	
	
	
	public MakingSystem() {
		super();
		
		waterTank = new WaterTank();
		coilHeater = new CoilHeater();
		
		
	}

	// 시스템 가동으로 상태를 변경하는 메소드.
	public void startMakingSystem(DummyProduct product) {
		this.state = true;
		this.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(state) {
			
			//물탱크에 충분한 물이 있는지 확인.
			if(!waterTank.checkProperAmountOfWater()) {
				System.out.println(waterTank.sendError());
				state = false;
			}
			
			//물 탱크의 물의 온도가 일정 온도인지 확인.
			if(!coilHeater.checkProperTempuratureOfWater(waterTank.getTempuratureOfWater())) {
				System.out.println("물을 데운다.");
				
				int temp = coilHeater.heatWater();
				
				if(temp > coilHeater.getMIN_TEMPURATURE()) {
					waterTank.setTempuratureOfWater(coilHeater.heatWater());
					System.out.println("물을 다 데웠다. 물의 온도는 :" + waterTank.getTempuratureOfWater());
				}else {
					System.out.println("물 데우기 실패 !" + coilHeater.sendError());
				}
				
				
				
					
				
			}
			
			
			
			
			
			
			
			
			
			
		}
	}
	

	
}

class WaterTank{
	
	private int tempuratureOfWater;	//현재 물탱크에 있는 물의 온도
	private int curAmountOfWater;	//현재 뭍탱크에 있는 물의 양
	private final int MIN_CAPACITY = 70;	//물탱크의 최소 용량 = 70mL
	private final int MAX_CAPACITY = 2700;	//물탱크의 최대 용량 = 2700ml = 2.7L
	
	private String errorMsg;
	
	//클래스 생성자.
	public WaterTank() {
		this.curAmountOfWater = 2700;
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
	
	
	
}

class CoilHeater{
	
	private final int MAX_TEMPURATURE = 90;
	private final int MIN_TEMPURATURE = 50;
	
	private String errorMsg;
	
	public int getMAX_TEMPURATURE() {
		return MAX_TEMPURATURE;
	}


	public int getMIN_TEMPURATURE() {
		return MIN_TEMPURATURE;
	}


	public boolean checkProperTempuratureOfWater(int curTempOfWater) {
		boolean isHot = curTempOfWater > 70? true: false;
		
		return isHot;
	}
	

	public int heatWater() {
		return MAX_TEMPURATURE;
	}
	
	public String sendError() {
		return this.errorMsg;
	}
	
	
	
}









