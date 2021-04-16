
public class ThreadsInterface  implements Runnable {
	
	private String MyString;
	
	public ThreadsInterface(String InitString) {
		MyString = InitString;
	}
	
	@Override
	public void run() {
		System.out.println(MyString + " Interface");
	}

}
