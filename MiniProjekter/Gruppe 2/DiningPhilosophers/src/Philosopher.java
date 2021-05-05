
public class Philosopher implements Runnable {

	private Object chopstickL;
	private Object chopstickR;
	

	Philosopher (Object chopstickL, Object chopstickR) {
	this.chopstickL = chopstickL;
	this.chopstickR = chopstickR;	
}
	
	@Override
	public void run() {
		try {
			while(true) {
		useChopstick(System.nanoTime() + ": Considering options");
			synchronized (chopstickR) {
				useChopstick(System.nanoTime() + ": Picked up the right chopstick, now he got 1/2 Chopsticks");
				synchronized (chopstickL) {
					useChopstick(System.nanoTime() + ": Picked up the left Chopstick, now he got 2/2 Chopsticks and started to eat");
					useChopstick(System.nanoTime() + ": Put down the left Chopstick");
				}
				useChopstick(System.nanoTime() + ": Put down the left Chopstick & returned to thinking again");
		}
		}
	}	catch (InterruptedException e) {
		Thread.currentThread().interrupt();
	}
	}
	
	private void useChopstick (String takingChopstick) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + takingChopstick);
		Thread.sleep(5000);
	}
	
}