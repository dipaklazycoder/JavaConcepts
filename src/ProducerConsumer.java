public class ProducerConsumer {

    int a[] = new int[100];
    int count = 0;

    public synchronized void consume() {
        while (isEmpty(count)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        a[--count] = 0;
        notify();
    }

    public synchronized void produce()  {
        while (isFull(a, count)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        a[count++] = 1;
        notify();
    }

    public boolean isEmpty(int count) {
      return count == 0;
    }

    public boolean isFull(int[] a, int count) {
        return a.length-1 == count;
    }

    int getCount() {
        return count;
    }
}

