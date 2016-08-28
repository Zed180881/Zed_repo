package ch11_observer;

import java.util.Observable;
import java.util.Observer;

public class RadioChannel implements Observer {
	@Override
	public void update(Observable agency, Object newsItem) {
		if (agency instanceof Publisher) {
			System.out.println((String) newsItem);
		}
	}
}