import java.util.concurrent.*;

class Shared {
	static int count = 0;
}

class MyThread extends Thread {
	Semaphore semPro;
	Semaphore semCon;
	String threadName;
	
	public MyThread( Semaphore mySemPro, Semaphore mySemCon, String myThreadName ) {
		super(myThreadName);
		this.semPro = mySemPro;
		this.semCon = mySemCon;
		this.threadName = myThreadName;
	}
	
	@Override
	public void run() {
		if ( this.getName().equals("Producer") ) {
			System.out.println("Producer starting...");
			for (int i=0; i<5; i++) {
				try {
					semPro.acquire();
					Shared.count++;
					System.out.println( threadName + " Writes: " + Shared.count);
					semCon.release();
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Consumer starting...");
			for (int i=0; i<5; i++) {
				try {
					semCon.acquire();
					System.out.println( threadName + " Reads: " + Shared.count);
					semPro.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(threadName + " Ending");
	}

}
