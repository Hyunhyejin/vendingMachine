package MakingSystem;

import java.beans.EventHandler;
import java.util.Scanner;

import Parents.ResultCallBack;
import Util.ResultEventHandler;
import Parents.Product;

public class MakingSystem implements Runnable {

	private boolean state = false; // makingSystem�������� true = ��ǰ ����� ��, false = ��ǰ ����� ���� ����.

	private WaterTank waterTank;
	private CoilHeater coilHeater;
	private Product product;
	private CoffeeHolder coffeeHolder;
	private CreamHolder creamHolder;
	private SugarHolder sugarHolder;
	private CupStack cupStack;
	private MixPipe mixPipe;
	private StockManager stockmanager;

	public MakingSystem() {
		super();
		stockmanager = new StockManager();

		waterTank = new WaterTank();
		coilHeater = new CoilHeater();

		coffeeHolder = new CoffeeHolder();
		creamHolder = new CreamHolder();
		sugarHolder = new SugarHolder();

		cupStack = new CupStack();

		mixPipe = new MixPipe();

	}

	// �ý��� �������� ���¸� �����ϴ� �޼ҵ�.
	public void startMakingSystem(Product product) {

		this.product = product;
		this.state = true;

		this.run();

	}

	public boolean getStateMk() {
		return this.state;
	}

	public void updateStock() {
		waterTank.setCurAmountOfWater(stockmanager.getAmount_water());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (state) {
			// ����ũ�� ����� ���� �ִ��� Ȯ��.
			if (!waterTank.checkProperAmountOfWater()) {
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "���� �����մϴ�");
				state = false;
				break;
			}

			// �� ��ũ�� ���� �µ��� ���� �µ����� Ȯ��.
			if (!coilHeater.checkProperTempuratureOfWater(waterTank.getTempuratureOfWater())) {
				System.out.println("���� �����.");

				int temp = coilHeater.heatWater();

				if (temp > coilHeater.getMIN_TEMPURATURE()) {
					waterTank.setTempuratureOfWater(coilHeater.heatWater());
					System.out.println("���� �� ������. ���� �µ��� :" + waterTank.getTempuratureOfWater());
				} else {
					state = false;
					// System.out.println("�� ����� ���� !" + coilHeater.sendError());
					ResultEventHandler.callEvent(MakingSystem.class, "fail", "�� ����� ����!");
					break;
				}
			}

			// �Ž��ÿ��� �� ��������
			Cup cup = (Cup) cupStack.get();

			if (cup == null) {
				System.out.println("���� �����ϴ�. �����ڿ��� ���� �� �ּ���.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "���� �����ϴ�. �����ڿ��� ���� �� �ּ���.");
				state = false;
				break;
			}

			// �ſ� ����ֱ�
			if ((coffeeHolder.getCurAmountOfPowder() < product.getAmountOfCoffeePowder())) {
				// System.out.println("Ŀ�� ���簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "Ŀ�� ���簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				state = false;
				break;
			}

			if (creamHolder.getCurAmountOfPowder() < product.getAmountOfCreamPowder()) {
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "ũ�� ���簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				// System.out.println("ũ�� ���簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				state = false;
				break;
			}

			if (sugarHolder.getCurAmountOfPowder() < product.getAmountOfSugarPowder()) {
				// System.out.println("�������簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				ResultEventHandler.callEvent(MakingSystem.class, "fail", "���� ���簡 �����ϴ�. �����ڿ��� ������ �ּ���.");
				state = false;
				break;
			}

			int amountOfCoffeeP = coffeeHolder.putPowderInMixPipe(product.getAmountOfCoffeePowder());
			int amountOfCreamP = creamHolder.putPowderInMixPipe(product.getAmountOfCreamPowder());
			int amountOfsugarP = sugarHolder.putPowderInMixPipe(product.getAmountOfSugarPowder());
			int amountOfWater = waterTank.putWaterInMixPipe(product.getAmountOfWater());

			// �ͽ��ϱ�
			Product p = mixPipe.mix(amountOfCoffeeP, amountOfCreamP, amountOfsugarP, amountOfWater);
			cup.setProductInCup(p);

			// �ݹ��Լ��� ��ǰ������ �Ϸ� �Ǿ����� �˸���
			// this.endProductCallBack.resultCallBack(this.product,"success");

			ResultEventHandler.callEvent(MakingSystem.class, "success", "Tt");

			stockmanager.setAmount_coffee_powder(coffeeHolder.getCurAmountOfPowder());
			stockmanager.setAmount_cream_powder(creamHolder.getCurAmountOfPowder());
			stockmanager.setAmount_cup(cupStack.getSize());
			stockmanager.setAmount_sugar_powder(sugarHolder.getCurAmountOfPowder());
			stockmanager.setAmount_water(waterTank.getCurAmountOfWater());

			state = false;
			break;
		}

	}

}
