/**
 *  ----------------------------------------------------------------------------
 * |                        	LockCounterThread.java							|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.concurrency;

public class LockCounterThread implements Runnable {
	private LockCounter count;
	private int N;
	private int nInc, nDec;

	public LockCounterThread(LockCounter count, int nInc, int nDec) {
		this.count = count;
		this.nInc = nInc;
		this.nDec = nDec;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			count.increment();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		LockCounter count = new LockCounter();
		System.out.println("Initial value for count: " + count.value());

		LockCounterThread ct1 = new LockCounterThread(count, 5000, 10000);
		Thread t1 = new Thread(ct1);
		LockCounterThread ct2 = new LockCounterThread(count, 10000, 5000);
		Thread t2 = new Thread(ct2);

		t1.start();
		t2.start();

		t2.join();
		t1.join();

		System.out.println("Final value for count: " + count.value());

	}

}
