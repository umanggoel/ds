import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolExecutor {
	int limit =0;
	Queue<Task> taskq = new LinkedList<ThreadPoolExecutor.Task>();
	Worker[] workers;
	
	public ThreadPoolExecutor(int limit) {
		this.limit = limit;
		workers= new Worker[limit];
		for(int i=0;i<limit;i++) {
			Worker temp = new Worker();
			temp.start();
			workers[i] =temp;
		}
	}
	
	public void submitTask(Task task) {
		taskq.add(task);
	}
	
	class Task{
		public void doWork(String str) {
			System.out.println("executing task"+this+" thread:"+str);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class Worker extends Thread{
		public void run() {
			while(true) {
				Task t = null;
				synchronized (taskq) {
					if(!taskq.isEmpty()) {
						t = taskq.poll();
					}
				}
				if(t!=null) {
					t.doWork(Thread.currentThread().getName());
				}
			}
		}
	}
	
	class Producer extends Thread{
			public void run() {
				while(true) {
					Task t = new Task();
					synchronized (taskq) {
						taskq.add(t);
					}
				}
			}
	}
	
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1);
		(pool.new Producer()).start();
	}
}

