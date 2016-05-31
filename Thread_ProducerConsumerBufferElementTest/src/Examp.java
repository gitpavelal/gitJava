
class Examp {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1,200,buffer,1000), "1").start();
        new Thread(new Producer(100,300,buffer,1000), "10").start();
        new Thread(new Producer(1000,400,buffer,1000),"100").start();


        new Thread(new Consumer(buffer)).start();



    }


}