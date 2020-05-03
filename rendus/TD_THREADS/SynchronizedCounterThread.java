/**
 *  ----------------------------------------------------------------------------
 * |                       	SynchronizedCounterThread.java						|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.concurrency;

public class SynchronizedCounterThread implements Runnable {
	private SynchronizedCounter count;
	private int nInc, nDec;

	public SynchronizedCounterThread(SynchronizedCounter count, int nInc, int nDec) {
		this.count = count;
		this.nInc = nInc;
		this.nDec = nDec;
	}

	public void run() {
		for (int i = 0; i < this.nInc; i++) {
			count.increment();
		}
		
		for (int i = 0; i < this.nDec; i++) {
			count.decrement();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		SynchronizedCounter count = new SynchronizedCounter();
		System.out.println("Initial value for count: " + count.value());

		SynchronizedCounterThread ct1 = new SynchronizedCounterThread(count, 5000, 10000);
		Thread t1 = new Thread(ct1);
		SynchronizedCounterThread ct2 = new SynchronizedCounterThread(count, 5000, 10000);
		Thread t2 = new Thread(ct2);

		t1.start();
		t2.start();

		t2.join();
		t1.join();

		System.out.println("Final value for count: " + count.value());

	}

}
