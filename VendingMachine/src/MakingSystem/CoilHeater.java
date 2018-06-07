package MakingSystem;


 public class CoilHeater{
	
	private final int MAX_TEMPURATURE = 90;
	private final int MIN_TEMPURATURE = 50;

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

}