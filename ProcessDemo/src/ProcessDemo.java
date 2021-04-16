import java.io.IOException;

public class ProcessDemo {
	// You will have to find your own application path for this

	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("C:\\Program Files\\HeidiSQL\\heidisql.exe");
		try {
			Process process = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

}
