public class HappensBeforeLink {

    public int x,y,r1,r2;
    private Object lock = new Object();

    public void firstMethod() {
        x=1;
        synchronized (lock) {
            y=1;
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            r1=y;
        }

        r2 = x;
    }
}
