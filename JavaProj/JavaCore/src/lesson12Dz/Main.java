//package lesson12Dz;
//
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Main {
//    
//    public static void main(String[] args) {
//	System.out.println("Enter count of Fibonacci number you need:");
//	Scanner sc = new Scanner(System.in);
//	int count = sc.nextInt();
//	sc.close();
//	ExecutorService service = Executors.newFixedThreadPool(1);
//	service.submit(new MyThread(count));
//	service.submit(new RunnableThread(count));
//	service.shutdown();
//    }
//}
