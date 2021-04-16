
public class ThreadsDemo {

	public static void main(String[] args) {
		ThreadsExtend myThreadA = new ThreadsExtend("A");
		ThreadsExtend myThreadB = new ThreadsExtend("B");
		ThreadsExtend myThreadC = new ThreadsExtend("C");
		Runnable myRunnableD = new ThreadsInterface("D");
		Runnable myRunnableE = new ThreadsInterface("E");
		Runnable myRunnableF = new Level1Interface("F");
		myThreadA.start();
		myThreadB.start();
		myThreadC.start();
		Thread  myThreadD = new Thread( myRunnableD );
		myThreadD.start();
		Thread myThreadE = new Thread( myRunnableE );
		myThreadE.start();
		Thread myThreadF = new Thread( myRunnableF );
		myThreadF.start();
		
		try {
			myThreadA.join();
			myThreadB.join();
			myThreadC.join();
			myThreadD.join();
			myThreadE.join();
			myThreadF.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Done...");
	}
}
