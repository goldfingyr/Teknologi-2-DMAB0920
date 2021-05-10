import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;


public class BarberShop {
    public static void main(String[] args) {

        AtomicInteger emptyChairs = new AtomicInteger(10);

        Semaphore semCustomer = new Semaphore(0);
        Semaphore semBarber = new Semaphore(1);
        
        Thread barber = new Barber(semCustomer, semBarber);
        barber.start();
    

        while(true) {
            try {
                Barber.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Barber sleep until next customer
            } catch (InterruptedException e) {
                System.out.println("Could not make barber sleep");
            }
        
            System.out.println("Customer walks in");

            if(emptyChairs.get() > 0){
                Thread customer = new Customer(emptyChairs, semCustomer, semBarber);
                customer.start();
            
            } else {
            	System.out.println("Customer walks out, as no seats are avaliable");
            }

        }

    }
}