/**
 *  ----------------------------------------------------------------------------
 * |                        	SynchronizedCounter.java						|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.concurrency;

public class SynchronizedCounter {
	
	/* ATTRIBUTS */
	
	private int c = 0;
	
	/* METHODES */
	
	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public int value() {
		return c;
	}
	
}
