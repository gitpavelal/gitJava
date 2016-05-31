import java.util.concurrent.TimeoutException;

public class Producer implements Runnable{
    private Integer nameProducer;
    private int timeSleep;
    SingleElementBuffer buffer;
    private long timeOut;

    public Producer(Integer nameProducer, int timeSleep, SingleElementBuffer buffer, int timeOut) {
        this.nameProducer = nameProducer;
        this.timeSleep = timeSleep;
        this.buffer = buffer;
        this.timeOut = timeOut;
    }

    public Integer getNameProducer() {
        return nameProducer;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("Produced " +   Thread.currentThread().getName()+" Element: " + nameProducer);
                this.buffer.put(nameProducer,timeOut);
                nameProducer++;
                Thread.sleep(timeSleep);


            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (TimeoutException e){
                System.err.println("TIME OUT EXCEPTION: PRODUCER " + Thread.currentThread().getName());
                return;
            }
        }
    }


}
