
public class SingleElementBuffer implements Runnable {

    private Integer elem = null;

    public SingleElementBuffer() {
    }

    @Override
    public void run() {

    }

    public synchronized void  put (Integer newElement) throws InterruptedException {

        while (!(elem == null)){
            this.wait();
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
