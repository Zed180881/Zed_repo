package lesson15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    private static final ExecutorService SERVICE = Executors
	    .newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException,
	    ExecutionException, TimeoutException {

	// Producer producer = new Producer();
	// // Producer producer1 = new Producer();
	// Consumer consumer1 = new Consumer();
	// Consumer consumer2 = new Consumer();
	// Thread.sleep(10000);
	// producer.interrupt();

	SERVICE.execute(new Runnable() {

	    @Override
	    public void run() {
		System.out.println(12);

	    }

	});
	Future<String> future = SERVICE.submit(new Task());
	String result = future.get(2, TimeUnit.SECONDS);
	System.out.println(result);
	SERVICE.awaitTermination(50, TimeUnit.SECONDS);
	SERVICE.shutdown();
	

    }

}
