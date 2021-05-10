import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends Thread {
    private Semaphore semCustomer;
    private Semaphore semBarber;
    private AtomicInteger emptyChairs;

	public Customer(AtomicInteger emptyChairs, Semaphore semCustomer, Semaphore semBarber) {
		this.semCustomer = semCustomer;
		this.semBarber = semBarber;
		this.emptyChairs = emptyChairs;
	}

    @Override
    public void run() {
        try {
        	//Gives access to a new thread
            semCustomer.release();    
            //If any available threads we can continue
            if(semBarber.hasQueuedThreads()) {
            	//Number of empty chairs left
                emptyChairs.decrementAndGet();
                System.out.println("Amount of seats available: " + emptyChairs);
                //if customer is waiting, the customer is acquired
                semBarber.acquire();
                //emptychairs is incremented
                emptyChairs.incrementAndGet();
                System.out.println("Amount of seats available: " + emptyChairs);
            } else {
                semBarber.acquire();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
}
