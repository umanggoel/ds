import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	int limit=5;
	static Queue<Double> q = new LinkedList<>();

	public class Producer implements Runnable {
		Queue<Double> q;

		public Producer(Queue q) {
			this.q = q;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (q) {
					if(q.size() == limit) {
						try {
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Double temp = Math.random();
					q.add(temp);
					System.out.println("Produced:"+temp);
					q.notifyAll();
				}
			}

		}

	}

	public class Consumer implements Runnable {

		Queue<Double> q;

		public Consumer(Queue q) {
			this.q = q;
		}

		@Override
		public void run() {
			while (true) {
				Double temp;
				synchronized (q) {
					if(q.isEmpty()) {
						try {
							q.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					temp = q.poll();
					System.out.println("Consumed : "+ temp);
					q.notifyAll();
				}
			}
		}

	}
	
	public static void main(String args[]) {

		Producer p =  (new ProducerConsumer()).new Producer(q);
		Consumer c =  (new ProducerConsumer()).new Consumer(q);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();

		
	}
}
