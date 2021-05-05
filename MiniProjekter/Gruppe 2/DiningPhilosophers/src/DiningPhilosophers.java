/* Dining philosophers problematikken ligger ved at disse philosophers er alle sultne og vil spise p� en gang, men de bliver n�dt
* til at skiftes til at spise, da de ikke har mulighed for at have 2/2 chopsticks p� en gang.
* Vi bruger derfor threads til at k�re programmet. */

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
			
			/* Vores deadlock prevention g�r at den sidste philosopher som nu engang normalt ville tage sin h�jre chopstick/spisepind,
			 * nu vil r�kke ud efter den venstre istedet. Dette g�r at alle ikke r�kker ud efte den h�jre og laver et deadlock hvor threads ikke
			 * kan forts�tte, da det ikke komme videre f�r en philosopher f�r hans venstre spisepind.
			 * Foruden denne nedenst�ende if-s�tning, ville programmet opn� denne omtalte deadlock.
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
