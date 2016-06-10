package lesson3DzTask3;

public class Wheel {

	public Wheel(String position, int airPressure) {
		this.position = position;
		this.airPressure = airPressure;
		this.isOK = this.checkStatus();
	}

	private boolean checkStatus() {
		if (this.airPressure > 60)
			return true;
		return false;
	}

	public void run() {
		this.checkStatus();
		if (isOK)
			System.out.println(this.position + " колесо крутититься");
		else
			System.out
					.println("Низький тиск в "+this.position+" колесі. Поїздка не можлива. Підкачай колесо.");
	}

	public int getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(int airPressure) {
		this.airPressure = airPressure;
	}

	private boolean isOK;
	private int airPressure;
	private String position;

}
