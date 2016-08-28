package ch04_Singleton;

public class MySingleton4 {

	private static MySingleton4 instance = null;

	static {
		instance = new MySingleton4();
	}

	private MySingleton4() {
	}

	public static MySingleton4 getInstance() {
		return instance;
	}
}
