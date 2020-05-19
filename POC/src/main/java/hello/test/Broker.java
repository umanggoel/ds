
public class Broker {

}

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentLinkedQueue;
///**
// * 
// * @author Nalin.Sharma
// *
// */
///*
// * Concurrent linked Queue
// * simple one producer one exchange multiple queues, one q to one consumer example
// */
//class Sleep{
//	static void sleep(){
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//}
//}
////consumer job
//class Consumer implements Runnable{
//	//ds
//	Queue q;
//	String name;
//	boolean hasReceived = false; 
//	
//	Consumer(String n){
//		name = n;
//		(new Thread(this)).start();
//	}
//	@Override
//	public void run() {
//		hasReceived = true;
//		while(true){
//		Sleep.sleep();
//			if(!q.isEmpty())
//		System.out.println(name+" reading "+q.remove());
//		}
//	}
//}
////producer job
//class Producer implements Runnable{
//	//ds
//	Exchange exchange;
//	//Object payload;
//	String routingKey;
//	//boolean hasSent = true;
//	
//	Producer(Exchange e){
//		exchange = e;
//		(new Thread(this)).start();
//	}
//	@Override
//	public void run() {
//		//hasSent = true;
//		int i = 0;
//		Sleep.sleep();
//		while(i < 100){
//		
//		if(i%2 == 0)	
//		exchange.addAndRoute(i,"even,number");
//		else
//			exchange.addAndRoute(i,"odd,number");	
//		System.out.println("prod .. "+ i);
//		i++;
//		}
//		System.out.println("prod done ");
//	}
//}
//class MyQueue{
//	//ds
//	String routingKey;
//	Queue q;
//	Consumer c; //you can count number of consumers of a type and spawn multiple threads
//	
//	public MyQueue(String routingKey, Queue q, Consumer c) {
//		this.routingKey = routingKey;
//		this.q = q;
//		this.c = c;
//		c.q = q; //one to one
//	}
//}
//
//class Exchange{
//	//ds
//	String name;
//	Producer p; //one producer
//	Map<String,List<MyQueue>> qs = new HashMap<>(); //routing queue and list of queues(each having one consumer)
//	
//	Exchange(String n){
//		name = n;
//	}
//	void bindProducer(Producer p){
//		this.p = p;
//	}
//	void bindConsumer(MyQueue q){
//		if(qs.get(q.routingKey) == null)
//		qs.put(q.routingKey, new ArrayList<>());
//		qs.get(q.routingKey).add(q);
//	}
//	void addAndRoute(Object payload, String routingKeys){
//		String [] rKeys = routingKeys.split(",");
//		for(String key :rKeys){
//			List<MyQueue> Q = qs.get(key);
//			for (int i = 0; i < Q.size(); i++) {
//				Q.get(i).q.add(payload); 
//			}
//		}
//	}
//}
//
//class Broker{
//	//ds
//	Exchange exchange;
//	
//	Broker(Exchange e, Producer p){
//		this.exchange = e;
//		this.exchange.p = p;
//	}
//	void bindToExchange(Queue q, Consumer c, String rq){
//		MyQueue mq = new MyQueue(rq, q, c);
//		exchange.bindConsumer(mq);
//	}
//}
//public class MessageBrokerDesign {
//
//	
//	public static void main(String[] args) {
//		Exchange e = new Exchange("e1");
//		Producer p = new Producer(e);
//		Broker mb = new Broker(e, p);
//		
//		Queue odd = new ConcurrentLinkedQueue();
//		Consumer oddC1 = new Consumer("odd");
//		mb.bindToExchange(odd, oddC1, "odd");
//
//		Queue even = new ConcurrentLinkedQueue();
//		Consumer evenC1 = new Consumer("even");
//		mb.bindToExchange(even, evenC1, "even");
//		
//		Queue number = new ConcurrentLinkedQueue();
//		Consumer numberC = new Consumer("number");
//		mb.bindToExchange(number, numberC, "number");
//	}
//}