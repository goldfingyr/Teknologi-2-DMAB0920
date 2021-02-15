
public class ThreadsDemo {

	public static void main(String[] args) {
		ThreadsExtend myThreadA = new ThreadsExtend("A");
		ThreadsExtend myThreadB = new ThreadsExtend("B");
		ThreadsExtend myThreadC = new ThreadsExtend("C");
		myThreadA.start();
		myThreadB.start();
		myThreadC.start();
		
		try {
			myThreadA.join();
			myThreadB.join();
			myThreadC.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}