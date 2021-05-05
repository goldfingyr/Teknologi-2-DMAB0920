// Similar to the Circular buffer example, but with objects

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class SharedFiFoQueue {
 
    private int[] elems = null;
    private int PosW = 0;
    private int PosR = 0;
     
    private Lock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
     
    public SharedFiFoQueue(int capacity) {
        this.elems = new int[capacity];
    }
     
    public void add(int elem) throws InterruptedException {
        lock.lock();
        if( ((PosW + 1) % elems.length) == PosR) {
        	System.out.println("Customer " + elem + " was sent away");
        	lock.unlock();
        	return;
        }
        	
        elems[PosW] = elem;
         
        //We need the modulo, in order to avoid going out of bounds.
        PosW = (PosW + 1) % elems.length;
                  
        //Notify the consumer that there is data available.
        isEmpty.signal();
         
        lock.unlock();
    }
 
    public int remove() throws InterruptedException {
    	int elem = 0;
         
        lock.lock();
        while( PosR == PosW ) {
            System.out.println("Barber sleeps");
        	isEmpty.await();
        	System.out.println("Barber wakes");
        }
        elem = elems[PosR];
 
        //We need the modulo, in order to avoid going out of bounds.
        PosR = (PosR + 1) % elems.length;
         
        lock.unlock();
         
        return elem;
    }
}