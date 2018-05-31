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
		this.product = product;
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













