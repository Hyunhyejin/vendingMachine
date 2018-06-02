package MakingSystem;
import java.util.Scanner;

import Parents.EndProductCallBack;
import Parents.Product;

public class MakingSystem implements Runnable {
	
	private boolean state = false;	//makingSystem가동상태 true = 제품 만드는 중, false = 제품 만들고 있지 않음.
	
	private WaterTank waterTank;
	private CoilHeater coilHeater;
	private Product product;
	private CoffeeHolder coffeeHolder;
	private CreamHolder creamHolder;
	private SugarHolder sugarHolder;
	private CupStack cupStack;
	private MixPipe mixPipe;
	
	private EndProductCallBack endProductCallBack;
	
	public MakingSystem(EndProductCallBack endProductCallBack) {
		super();
		this.endProductCallBack = endProductCallBack;
		
		waterTank = new WaterTank();
		coilHeater = new CoilHeater();
		
		coffeeHolder = new CoffeeHolder();
		creamHolder = new CreamHolder();
		sugarHolder = new SugarHolder();
		
		cupStack = new CupStack();
		
		mixPipe = new MixPipe();
	
	}

	// 시스템 가동으로 상태를 변경하는 메소드.
	public void startMakingSystem(Product product) {
		this.product = product;
		this.state = true;
		this.run();
		
	}
	
	public boolean getStateMk() {
		return this.state;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(state) {
			
			//물탱크에 충분한 물이 있는지 확인.
			if(!waterTank.checkProperAmountOfWater()) {
				System.out.println(waterTank.sendError());
				state = false;
				break;
			}
			
			//물 탱크의 물의 온도가 일정 온도인지 확인.
			if(!coilHeater.checkProperTempuratureOfWater(waterTank.getTempuratureOfWater())) {
				System.out.println("물을 데운다.");
				
				int temp = coilHeater.heatWater();	
				
				if(temp > coilHeater.getMIN_TEMPURATURE()) {
					waterTank.setTempuratureOfWater(coilHeater.heatWater());
					System.out.println("물을 다 데웠다. 물의 온도는 :" + waterTank.getTempuratureOfWater());
				}else {
					state = false;
					System.out.println("물 데우기 실패 !" + coilHeater.sendError());
					break;
				}
			}
			
			//컵스택에서 컵 가져오기 
			Cup cup = (Cup)cupStack.get();
			
			if(cup == null) {
				System.out.println("컵이 없습니다. 관리자에게 문의 해 주세요.");
				state = false;
				break;
			}
			
		
			//컵에 가루넣기 
			if((coffeeHolder.getCurAmountOfPowder() < product.getAmountOfCoffeePowder())) {
				System.out.println("커피 가루가 없습니다. 관리자에게 문의해 주세요.");
				System.out.println("남은 가루의 양 : " + coffeeHolder.getCurAmountOfPowder());
				state = false;
				break;
			}
			
			if(creamHolder.getCurAmountOfPowder() < product.getAmountOfCreamPowder()) {
				System.out.println("크림 가루가 없습니다. 관리자에게 문의해 주세요.");
				state = false;
				break;
			}
			
			if(sugarHolder.getCurAmountOfPowder() < product.getAmountOfSugarPowder()) {
				System.out.println("설탕가루가 없습니다. 관리자에게 문의해 주세요.");
				state = false;
				break;
			}
			
			int amountOfCoffeeP = coffeeHolder.putPowderInMixPipe(product.getAmountOfCoffeePowder());
			int amountOfCreamP = creamHolder.putPowderInMixPipe(product.getAmountOfCreamPowder());
			int amountOfsugarP = sugarHolder.putPowderInMixPipe(product.getAmountOfSugarPowder());
			int amountOfWater =waterTank.putWaterInMixPipe(product.getAmountOfWater());
			
			//믹스하기
			cup.setProductInCup(mixPipe.mix(amountOfCoffeeP, amountOfCreamP, amountOfsugarP, amountOfWater));
			System.out.println("완성했다.");
			state = false;
			break;
		}
		
	}
	
}













