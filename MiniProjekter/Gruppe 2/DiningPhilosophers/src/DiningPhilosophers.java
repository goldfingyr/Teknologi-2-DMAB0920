/* Dining philosophers problematikken ligger ved at disse philosophers er alle sultne og vil spise på en gang, men de bliver nødt
* til at skiftes til at spise, da de ikke har mulighed for at have 2/2 chopsticks på en gang.
* Vi bruger derfor threads til at køre programmet. */

public class DiningPhilosophers {

	public static void main (String[] args) throws Exception {
		
		Philosopher[] philosophers = new Philosopher [5];
		Object[] chopsticks = new Object[philosophers.length];
		
		for (int x = 0; x < chopsticks.length; x++) {
			chopsticks[x] = new Object();
		}
		
		for (int x = 0; x < philosophers.length; x++) {
			Object chopstickL = chopsticks[x];
			Object chopstickR = chopsticks[(x + 1) % chopsticks.length];
			
			/* Vores deadlock prevention gør at den sidste philosopher som nu engang normalt ville tage sin højre chopstick/spisepind,
			 * nu vil række ud efter den venstre istedet. Dette gør at alle ikke rækker ud efte den højre og laver et deadlock hvor threads ikke
			 * kan fortsætte, da det ikke komme videre før en philosopher får hans venstre spisepind.
			 * Foruden denne nedenstående if-sætning, ville programmet opnå denne omtalte deadlock.
			 */
			if(x == philosophers.length - 1) {
				philosophers[x] = new Philosopher(chopstickR, chopstickL);
			} else {
				philosophers[x] = new Philosopher(chopstickL, chopstickR);
			}
			
			Thread t = new Thread (philosophers[x], "Philosopher " + (x + 1));
			t.start();
			
		}
		
	}
	
}
