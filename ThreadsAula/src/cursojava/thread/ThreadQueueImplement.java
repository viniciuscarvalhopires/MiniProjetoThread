package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadQueueImplement extends Thread {
		private static ConcurrentLinkedQueue<ThreadQueue> dQueue = new ConcurrentLinkedQueue<ThreadQueue>();
	
		public static void add(ThreadQueue threadQueue) {
			dQueue.add(threadQueue);
		}
	
		@Override
		public void run() {
			
		
			while(true) {
				
				Iterator iterator = dQueue.iterator();
				
			synchronized (iterator) { //bloqueia o acesso à lista por outros processos
				

			while(iterator.hasNext())//enquanto houver dados 
				{
				ThreadQueue runQueue = (ThreadQueue) iterator.next();
				
				iterator.remove(); //remove e passa para o proximo objeto
				
				try { //dar tempo para "descarga de memória"
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
				System.out.println("Opaaa");
				}
			}
			
		
			try { //dar tempo para "descarga de memória"
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			}
	}
		
		
}
