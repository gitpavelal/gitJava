
public class Consumer implements Runnable {
    SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println("Consumed " + this.buffer.get());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
