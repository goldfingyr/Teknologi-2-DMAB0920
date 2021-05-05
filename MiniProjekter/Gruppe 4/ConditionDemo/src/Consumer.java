// Consuming the words from the queue.
// Counting total number of words and keeping track of unique words
//
import java.util.HashSet;
import java.util.Set;
 
public class Consumer extends Thread {
    private SharedFiFoQueue queue;
 
    public Consumer(SharedFiFoQueue queue) {
        this.queue = queue;
    }
     
    @Override
    public void run() {
      int currentCustomer;
    	
    	while (true) {
		try {
			currentCustomer = queue.remove();
			System.out.println("current customer " + currentCustomer);
			Thread.sleep(5000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
    }
}