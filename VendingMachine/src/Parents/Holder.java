package Parents;

public abstract class Holder {
	
	protected final int MAX_CAPACITY = 500;	//홀더에 들어가는 가루의 양,단위 = g
	public abstract int putPowderInMixPipe(int amount);
	
}
