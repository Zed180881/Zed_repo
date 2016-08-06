package part1.chapter11;

class CallMe {
    void call(String msg){
//    synchronized void call(String msg){
        System.out.print("[" +  msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}
