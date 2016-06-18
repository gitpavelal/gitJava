/**
 * пример сокращени безымянных классов
 * пример  лямбды
 *
 * разрешена с java 1.8
 * */
public class LambdaTest {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("r");
            }
        };

        Runnable run = () -> System.out.println("r");
    }
}
