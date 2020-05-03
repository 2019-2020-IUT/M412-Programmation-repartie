/**
 *  ----------------------------------------------------------------------------
 * |	                        CounterThread.java								|
 * |                                                                            |
 * | @author     JunkJumper (Josée SRIFI) 										|
 * | @since      21/01/2020                                						|
 *  ----------------------------------------------------------------------------
 * 
 */

package td1.concurrency;

public class CounterThread implements Runnable {
	private Counter count;
	private int N;

	public CounterThread(Counter count, int N) {
		this.count = count;
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			count.increment();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Counter count = new Counter();
		System.out.println("Initial value for count: " + count.value());

		CounterThread ct1 = new CounterThread(count, 10000);
		Thread t1 = new Thread(ct1);
		CounterThread ct2 = new CounterThread(count, 10000);
		Thread t2 = new Thread(ct2);

		t1.start();
		t2.start();

		t2.join();
		t1.join();

		System.out.println("Final value for count: " + count.value());

	}

}
