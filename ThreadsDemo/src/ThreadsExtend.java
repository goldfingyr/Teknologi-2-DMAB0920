
public class ThreadsExtend extends Thread {
	private String MyString;
	
	public ThreadsExtend ( String InitString ) {
		MyString = InitString;
	}
	
	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(MyString + " running");
	}

}
