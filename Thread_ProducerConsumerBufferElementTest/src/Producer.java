
public class Producer implements Runnable{
    private Integer nameProducer;
    private int timeSleep;
    SingleElementBuffer buffer;

    public Producer(Integer nameProducer, int timeSleep, SingleElementBuffer buffer) {
        this.nameProducer = nameProducer;
        this.timeSleep = timeSleep;
        this.buffer = buffer;
    }

    public Integer getNameProducer() {
        return nameProducer;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("Produced " + nameProducer);
                this.buffer.put(nameProducer);
                nameProducer++;
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
