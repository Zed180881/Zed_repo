package part2.chapter28;

import java.util.concurrent.Exchanger;

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Get: " + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
