
public class Consumer extends Thread{
	
	SharedBarberChairs queue;
	
	public Consumer(SharedBarberChairs queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				
				queue.removeCustomer();
				Thread.sleep(10000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
