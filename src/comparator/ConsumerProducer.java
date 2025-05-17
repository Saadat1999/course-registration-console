package comparator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducer {

    public static BlockingQueue<String> myQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException{

        Thread producer = new Thread() {
            public void run() {
                while(true) {
                    try {
                        for(int i=0; i<25;i++) {
                            myQueue.put(i+"");
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread consumer = new Thread() {
            public void run() {
                while(true) {
                    try {
                        System.out.println("\nwaiting...");
                        String take = myQueue.take();
                        System.out.println("Received: "+take);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        producer.start();
        consumer.start();
    }
}
