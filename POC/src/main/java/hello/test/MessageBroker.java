import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MessageBroker {

	Map<String, Queue<Message>> queues = new HashMap<>();
	Map<String,List<Consumer>> consumers = new HashMap<>();
	
	public void addConsumer(String routingKey, String name) {
		List<Consumer> consumersList = null;
		if(consumers.get(routingKey) == null) {
			consumersList = new ArrayList<>();
		}
		Consumer c = new Consumer();
		c.name = name;
		c.q = queues.get(routingKey);
		consumersList.add(c);
		c.start();
	}
	
	public void addQueue(String routingKey) {
		if(queues.get(routingKey)!=null) {
			System.out.println("Queue already exists");
			return;
		}
		queues.put(routingKey, new LinkedList<>());
	}
	
	public void addMessage(String routingKey, Message message) {
		if(queues.get(routingKey) == null) {
			System.out.println("No such queue is available");
			return;
		}
		queues.get(routingKey).add(message);
	}
	
	public void getMessage(String routingKey) {
		if(queues.get(routingKey) == null) {
			System.out.println("No such queue is available");
			return;
		}
		System.out.println(queues.get(routingKey).peek());
	}
	
}

class Consumer extends Thread{
	String name;
	Queue<Message> q;
	
	@Override
	public void run() {
		while(true) {
			Message m = null;
			synchronized (q) {
				while(q.isEmpty()) {
					try {
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				m = q.poll();
				q.notifyAll();
			}
			System.out.println(m);
		}
	}
}

class Message{
	String name;
	@Override
	public String toString() {
		return name;
	}
	
}