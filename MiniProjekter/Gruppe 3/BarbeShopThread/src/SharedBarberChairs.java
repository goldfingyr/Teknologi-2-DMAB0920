import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBarberChairs {
	
	private ArrayList<String> chairs = new ArrayList<>();
	private int count = 0;
	private final int MAX_SIZE = 5;
	
	private Lock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();

    
    public void addCustomer() throws InterruptedException {
    	lock.lock();
    	
    	while(chairs.size()==MAX_SIZE) {
  
    		System.out.println("Customer: " + ++count + " has left");
    		lock.unlock();
    		return;
    	}
    	
    	
    	
    	chairs.add("customer" + ++count);
    	System.out.println("Customer(" + count +")"+ " has entered shop");
    	
    	//Signals the consumer, that list is no longer empty
    	isEmpty.signal();
   
    	lock.unlock(); 
    }
    
    public void removeCustomer() throws InterruptedException {
    	
    	lock.lock();
    	
    	while(chairs.isEmpty()) {
    		System.out.println("Barber is sleeping");
    		isEmpty.await();
    		
    	}
    	
    	//String customer = chairs.get(0);
    	
		//chairs.remove(customer);
		
		String customer = chairs.remove(0);
		System.out.println("Barber has cut hair of " + customer );		
		
    	
    	
    	lock.unlock();
    	
    	
    }

}
