package lesson12Dz;

public class MyThread extends Thread {

    private int count;

    public MyThread(int count) {
	this.count = count;
    }

    @Override
    public void run() {
	for (int i = 1; i <= count; i++) {
	    System.out.print(fibonacci(i) + " ");
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
	    }
	}
	System.out.println();
    }

    public int fibonacci(int n) {
	if (n == 1 || n == 2)
	    return 1;
	return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
