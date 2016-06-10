package lesson2;

public class Hunter extends Human {

	private String wearpon;
	private int killedMammonts;
	
	
	public Hunter(String wearpon) {
		super();
		this.wearpon = wearpon;
	}

	public Hunter() {
		super();
		
	}

	public Hunter(int age) {
		super(age);
		System.out.println(wearpon);
	}

	public void eatMeat(String meat) {
		System.out.println("nyam-nyam " + meat);
	}

	public void killMammont() {
		killedMammonts++;
		eatMeat("mammont meat");
	}

	public void walk() {
		System.out.println("fast go-go-go");
	}

	public int getKilledMammonts() {
		return this.killedMammonts;
	}
}
