package MakingSystem;
import java.util.Scanner;

public class MakingSystem extends Thread {
	
	private boolean state = false;	//makingSystem�������� true = ��ǰ ����� ��, false = ��ǰ ����� ���� ����.
	
	private WaterTank waterTank;
	private CoilHeater coilHeater;
	
	private DummyProduct product;
	
	
	
	
	public MakingSystem() {
		super();
		
		waterTank = new WaterTank();
		coilHeater = new CoilHeater();
		
		
	}

	// �ý��� �������� ���¸� �����ϴ� �޼ҵ�.
	public void startMakingSystem(DummyProduct product) {
		this.state = true;
		this.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(state) {
			
			//����ũ�� ����� ���� �ִ��� Ȯ��.
			if(!waterTank.checkProperAmountOfWater()) {
				System.out.println(waterTank.sendError());
				state = false;
			}
			
			//�� ��ũ�� ���� �µ��� ���� �µ����� Ȯ��.
			if(!coilHeater.checkProperTempuratureOfWater(waterTank.getTempuratureOfWater())) {
				System.out.println("���� �����.");
				
				int temp = coilHeater.heatWater();
				
				if(temp > coilHeater.getMIN_TEMPURATURE()) {
					waterTank.setTempuratureOfWater(coilHeater.heatWater());
					System.out.println("���� �� ������. ���� �µ��� :" + waterTank.getTempuratureOfWater());
				}else {
					System.out.println("�� ����� ���� !" + coilHeater.sendError());
				}
				
				
				
					
				
			}
			
			
			
			
			
			
			
			
			
			
		}
	}
	

	
}

class WaterTank{
	
	private int tempuratureOfWater;	//���� ����ũ�� �ִ� ���� �µ�
	private int curAmountOfWater;	//���� ����ũ�� �ִ� ���� ��
	private final int MIN_CAPACITY = 70;	//����ũ�� �ּ� �뷮 = 70mL
	private final int MAX_CAPACITY = 2700;	//����ũ�� �ִ� �뷮 = 2700ml = 2.7L
	
	private String errorMsg;
	
	//Ŭ���� ������.
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









