package MakingSystem;

import java.beans.EventHandler;
import java.util.Scanner;

import Util.ResultCallBack;
import Util.ResultEventHandler;
import manager.StockManager;
import Parents.Product;

public class MakingSystem implements Runnable {

	private boolean state = false; // makingSystem가동상태 true = 제품 만드는 중, false = 제품 만들고 있지 않음.

	private WaterTank waterTank;
	private CoilHeater coilHeater;
	private Product product;
	private CoffeeHolder coffeeHolder;
	private CreamHolder creamHolder;
	private SugarHolder sugarHolder;
	private CupStack cupStack;
	private MixPipe mixPipe;
	
	public MakingSystem() {
		super();
		
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

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (state) {
			// 물탱크에 충분한 물이 있는지 확인.
			if (!waterTank.checkProperAmountOfWater()) {
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "물이 부족합니다");
				state = false;
				break;
			}

			// 물 탱크의 물의 온도가 일정 온도인지 확인.
			if (!coilHeater.checkProperTempuratureOfWater(waterTank.getTempuratureOfWater())) {
				System.out.println("물을 데운다.");

				int temp = coilHeater.heatWater();

				if (temp > coilHeater.getMIN_TEMPURATURE()) {
					waterTank.setTempuratureOfWater(coilHeater.heatWater());
					System.out.println("물을 다 데웠다. 물의 온도는 :" + waterTank.getTempuratureOfWater());
				} else {
					state = false;
					// System.out.println("물 데우기 실패 !" + coilHeater.sendError());
					ResultEventHandler.callEvent(MakingSystem.class, "fail", "물 데우기 실패!");
					break;
				}
			}

			// 컵스택에서 컵 가져오기
			Cup cup = (Cup) cupStack.get();

			if (cup == null) {
				System.out.println("컵이 없습니다. 관리자에게 문의 해 주세요.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "컵이 없습니다. 관리자에게 문의 해 주세요.");
				state = false;
				break;
			}

			// 컵에 가루넣기
			if ((coffeeHolder.getCurAmountOfPowder() < product.getAmountOfCoffeePowder())) {
				// System.out.println("커피 가루가 없습니다. 관리자에게 문의해 주세요.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "커피 가루가 없습니다. 관리자에게 문의해 주세요.");
				state = false;
				break;
			}

			if (creamHolder.getCurAmountOfPowder() < product.getAmountOfCreamPowder()) {
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "크림 가루가 없습니다. 관리자에게 문의해 주세요.");
				// System.out.println("크림 가루가 없습니다. 관리자에게 문의해 주세요.");
				state = false;
				break;
			}

			if (sugarHolder.getCurAmountOfPowder() < product.getAmountOfSugarPowder()) {
				// System.out.println("설탕가루가 없습니다. 관리자에게 문의해 주세요.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "설탕 가루가 없습니다. 관리자에게 문의해 주세요.");
				state = false;
				break;
			}

			//믹스파이프로 재료보내기 
			int amountOfCoffeeP = coffeeHolder.putPowderInMixPipe(product.getAmountOfCoffeePowder());
			int amountOfCreamP = creamHolder.putPowderInMixPipe(product.getAmountOfCreamPowder());
			int amountOfsugarP = sugarHolder.putPowderInMixPipe(product.getAmountOfSugarPowder());
			int amountOfWater = waterTank.putWaterInMixPipe(product.getAmountOfWater());

			// 믹스하기
			Product p = mixPipe.mix(amountOfCoffeeP, amountOfCreamP, amountOfsugarP, amountOfWater);
			cup.setProductInCup(p);

			ResultEventHandler.callEvent(MakingSystem.class, "success", "");

			StockManager.setAmount_coffee_powder(coffeeHolder.getCurAmountOfPowder());
			StockManager.setAmount_cream_powder(creamHolder.getCurAmountOfPowder());
			StockManager.setAmount_cup(cupStack.getCurCupCount());
			StockManager.setAmount_sugar_powder(sugarHolder.getCurAmountOfPowder());
			StockManager.setAmount_water(waterTank.getCurAmountOfWater());

			state = false;
			break;
		}

	}

}
