
class Examp {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1,2000,buffer)).start();
        new Thread(new Producer(100,3000,buffer)).start();
        new Thread(new Producer(1000,7000,buffer)).start();


        new Thread(new Consumer(buffer)).start();



    }


}