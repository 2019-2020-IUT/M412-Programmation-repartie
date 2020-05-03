/**
 *  ----------------------------------------------------------------------------
 * |                        	LockCounter.java								|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.concurrency;

class LockCounter {
	private int c = 0;
	private Object lock = new Object();

	public void increment() {
		synchronized (lock) {
			c++;
		}
	}

	public void decrement() {
		synchronized (lock) {
			c--;
		}
	}
	public int value() {
		return c;
	}

}