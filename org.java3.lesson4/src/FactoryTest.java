import java.util.ArrayList;
import java.util.List;

/**создаем шаблон фабрика*/

public class FactoryTest {
/**главный класс маркер*/
    public static abstract class Mesage {
    }
/**интерфейс кретор создает объекты*/
    public static interface Creator<T extends Mesage> {
        T create();
    }
/**сами объекты*/
    public static class Mail extends Mesage {
        @Override
        public String toString() {
            return "Mail{} ";
        }
    }

    public static class Sms extends Mesage {
        @Override
        public String toString() {
            return "Sms{} ";
        }
    }

/**сущеность создающая объекты импл от Creator*/
    public static class MailCreator implements Creator<Mail> {
        @Override
        public Mail create() {
            return new Mail();
        }
    }

    public static class SmsCreator implements Creator<Sms> {
        @Override
        public Sms create() {
            return new Sms();
        }
    }
/**проверка. если поставить объект не унаследованный от Mesage, объект не создастся*/

    public static void main(String[] args) {

        List list = new ArrayList<>();

        list.add(new MailCreator().create());
        list.add(new SmsCreator().create());
        list.add(new MailCreator().create());
        list.add(new SmsCreator().create());
        list.add(new MailCreator().create());
        list.add(new SmsCreator().create());

        for (Object o : list
                ) {
            System.out.println(o);
        }

    }

}
