public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        producerConsumer();

    }

    public static void producerConsumer() throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Runnable consumeTask = ()-> {
            for(int i =0; i< 50 ; i++) {
                producerConsumer.consume();
            }
            System.out.println("Done consuming");
        };

        Runnable produceTask = ()-> {
            for(int i =0; i< 50 ; i++) {
                producerConsumer.produce();
            }
            System.out.println("Done producing");
        };

        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();
        consumerThread.join();
        producerThread.join();
        System.out.println("Items :" + producerConsumer.getCount());
    }

    public static void happensBeforeLink() throws InterruptedException {
        HappensBeforeLink happensBeforeLink = new HappensBeforeLink();
        Runnable task1 = ()-> {
            happensBeforeLink.firstMethod();
        };

        Runnable task2 = ()-> {
            happensBeforeLink.secondMethod();
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);


        t1.start();
        t2.start();
        t1.join();
        t2.join();



        System.out.println("Value " + happensBeforeLink.r2);
    }
}
