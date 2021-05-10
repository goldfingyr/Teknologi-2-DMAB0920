import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Barber extends Thread {
    Semaphore semCustomer; // Costumer 
    Semaphore semBarber; // Barber

	public Barber(Semaphore semCustomer, Semaphore semBarber) {
		this.semCustomer = semCustomer;
		this.semBarber = semBarber;
	}

    @Override
    public void run() {
        while(true) {
        	try {
				semCustomer.acquire();
				System.out.println("Customer is getting a new hair style ");
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000 + 1000));
				System.out.println("Customer pays and leaves");
				semBarber.release();
        	} catch (Exception e) {
				System.out.println("could not acquire customer");
			}
        }



    }
}
