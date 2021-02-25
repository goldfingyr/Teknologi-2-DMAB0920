import java.util.concurrent.*;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semPro = new Semaphore(1);
		Semaphore semCon = new Semaphore(0);
		
		MyThread mt1 = new MyThread(semPro, semCon, "Producer");
		MyThread mt2 = new MyThread(semPro, semCon, "Consumer");
		
		mt1.start();
		mt2.start();
		
		try {
			mt1.join();
			mt2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count= " + Shared.count);

	}

}
