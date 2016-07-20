package lesson15;

import java.util.LinkedList;
import java.util.Queue;

public class Connector {

    private static final Connector instance = new Connector();

    public static Connector getInstance() {
	return instance;
    }

    private Connector() {
    }

    private volatile Queue<Integer> queue = new LinkedList<Integer>();

    public Integer getTask() {
	return queue.poll();
    }

    public void addTask(int task) {
	queue.add(task);
    }

}
