
public class SleepingBarberDemo {
	
	public static void main(String[] args) {
		SharedBarberChairs chairs = new SharedBarberChairs();
		Producer producer = new Producer(chairs);
		Consumer consumer = new Consumer(chairs);
		
		producer.start();
		consumer.start();
		
		
		try {
			consumer.join();
			System.out.println("Consumer Joined");
			producer.join();
			System.out.println("Producer joined");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
