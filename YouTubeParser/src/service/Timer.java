package service;

public class Timer {

	public static void getTimeInSec(int seconds) {
		Thread thead = new Thread();
		
		try {
			thead.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
