// The file "input.txt" is read on a line basis.
// Words are separated and fed to the queue
// Finally a null object is fed to the queue to signal the consumer the end of operation



import java.util.Random;
 
public class Producer extends Thread {
    private SharedFiFoQueue queue;
     
    public Producer(SharedFiFoQueue queue) {
        this.queue = queue;
    }
     
    @Override
    public void run() {
     Random WaitTime = new Random();
     int customerId = 0;
     
     while (true) {
		try {
			Thread.sleep(WaitTime.nextInt(5)*1000);
			System.out.println("Customer " + customerId + " arrives at shop");
			queue.add(customerId++);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
     
    }
}