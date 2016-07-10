import java.util.ArrayList;
import java.util.Collection;


/**
 * создаем шаблон наблюдатель
 */
public class Observable {

    /**
     * interface ChatServer
     */
    public static interface ChatServer {

        void register(final ChatUser user);

        void remove(final ChatUser user);

        void notifyUsers(final String message);

        void recive(final String message);
    }

    /**
     * interface ChatUser
     */
    public static interface ChatUser {

        void recive(final String message);

        void send(final String message);
    }

    /**
     * class SimpleChatServer
     */
    public static class SimpleChatServer implements ChatServer {

        private final Collection<ChatUser> users = new ArrayList<>();

        public Collection<ChatUser> getUsers() {
            return users;
        }

        public SimpleChatServer() {
        }

        @Override
        public void register(final ChatUser user) {
            this.users.add(user);
            notifyUsers(String.format("add new user  = %s", user));
        }

        @Override
        public void remove(final ChatUser user) {
            this.users.remove(user);
            notifyUsers(String.format("remove  user  =  %s", user));
        }

        @Override
        public void notifyUsers(final String message) {
            for (ChatUser user : this.users) {
                user.recive(message);
            }
        }

        @Override
        public void recive(String message) {
            notifyUsers(message);
        }


    }

    /**
     * class SimpleChatUser
     */
    public static class SimpleChatUser implements ChatUser {

        /**
         * нужно хранить сам сервер для того что бы его не потерять
         */
        private ChatServer server;
        private String name;

        public SimpleChatUser() {
        }

        public SimpleChatUser(ChatServer server) {
            this.server = server;
            server.register(this);
        }


        public SimpleChatUser(String name, ChatServer server) {
            this.name = name;
            this.server = server;
            server.register(this);
        }

        @Override
        public void recive(String message) {
            System.out.println(String.format("from server = %s", message));
        }

        @Override
        public void send(final String message) {
            this.server.recive(message);
        }

        public ChatServer getServer() {
            return server;
        }

        public void setServer(ChatServer server) {
            this.server = server;
        }

        @Override
        public String toString() {
            return "{" + name + '}';
        }
    }


    public static void main(String[] args) {
        SimpleChatServer server = new SimpleChatServer();

        SimpleChatUser user1 = new SimpleChatUser("user1", server);
        user1.send("hello");

        SimpleChatUser user2 = new SimpleChatUser("user2", server);
//        server.remove(user1);
        SimpleChatUser user3 = new SimpleChatUser("user3", server);
        user3.send("Yap");
        user2.send("FU");

        System.out.println(server.getUsers());


    }

}
