import java.util.concurrent.TimeoutException;

public class SingleElementBuffer implements Runnable {

    private Integer elem = null;

    public SingleElementBuffer() {
    }

    @Override
    public void run() {

    }

    public synchronized void  put (Integer newElement, long timeOut) throws InterruptedException, TimeoutException {

        long waitTime = timeOut;
        while (elem != null && waitTime > 0){
            long t0 = System.currentTimeMillis();
            this.wait();
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;


        }
        if (waitTime < 0){
            throw new TimeoutException();
        }


        this.elem = newElement;
        this.notifyAll();

    }

    public synchronized Integer get () throws InterruptedException {

        while (elem == null){
            this.wait();
        }

        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
