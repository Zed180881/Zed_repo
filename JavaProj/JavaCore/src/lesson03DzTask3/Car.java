package lesson03DzTask3;

public class Car {

	private String model;
	private Wheel wheel1;
	private Wheel wheel2;
	private Wheel wheel3;
	private Wheel wheel4;
	private Body body;
	private SteeringWheel steeringWheel;
	private boolean isOK;

	public Car(String model, String color) {
		this.model = model;
		this.body = new Body(color);
		this.steeringWheel = new SteeringWheel();
		this.wheel1 = new Wheel("переднє ліве", 100);
		this.wheel2 = new Wheel("переднє праве", 100);
		this.wheel3 = new Wheel("заднє ліве", 100);
		this.wheel4 = new Wheel("заднє праве", 100);
		this.isOK = true;
	}

	public void run() {		
		if (isOK) {
			System.out.println(this.model + " їде");
			wheel1.run();
			wheel2.run();
			wheel3.run();
			wheel4.run();
			body.run();
			steeringWheel.run();
		} else
			System.out.println("Машина зламалася");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
