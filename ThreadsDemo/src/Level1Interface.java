//
// Demo of thread starting a thread
//

public class Level1Interface  implements Runnable {

	private String MyString;

	public Level1Interface(String InitString) {
		MyString = InitString;
	}
	
	@Override
	public void run() {
		System.out.println(MyString + " Interface");
		ThreadsExtend myThreadA = new ThreadsExtend( MyString + "A" );
		myThreadA.start();
		try {
			myThreadA.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(MyString + " Interface...Done");
	}
}
