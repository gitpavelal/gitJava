/**создаем шаблон наблюдатель*/
public class Observable {

    public static interface ChatServer {

        void register(final ChatUser user);

        void remove(final ChatUser user);

        void nitfiyUsers(final String message);

        void recive(final String message);
    }

    public static interface ChatUser {

        void recive(final String message);

        void send(final String message);
    }



}
