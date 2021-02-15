import java.io.IOException;

public class ProcessDemo {

	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("C:\\Program Files\\GIMP 2\\bin\\gimp-2.10.exe");
		try {
			Process process = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
