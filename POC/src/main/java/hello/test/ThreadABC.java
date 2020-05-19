
public class ThreadABC {
	public static void main(String[] args) {
		Task t = new Task();
		t.currentValue = 1;
		t.limit = 22;
		Printer p1 = new Printer(1, t,"a");
		Printer p2 = new Printer(2, t,"b");
		Printer p3 = new Printer(3, t,"c");

		p1.start();
		p2.start();
		p3.start();
	}

}

class Task {
	public int limit;
	public int currentValue;
}

class Printer extends Thread {
	Task t;
	int nextValue;
	String initial;

	public Printer(int init, Task t, String initial) {
		nextValue = init;
		this.t = t;
		this.initial = initial;
	}

	@Override
	public void run() {
		while(nextValue < t.limit) {

		synchronized (t) {
					while(t.currentValue != nextValue) {
						try {
							t.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println(initial+nextValue+Thread.currentThread().getName());
					nextValue=nextValue+3;
					t.currentValue++;
					t.notifyAll();
			}
		}
	}
}