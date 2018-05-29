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













