import java.util.Random;

public class Producer extends Thread {
	
	private SharedBarberChairs queue;
	
	public Producer(SharedBarberChairs queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				
				Random i = new Random();
					
				queue.addCustomer();
				Thread.sleep(i.nextInt(10000));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
}
