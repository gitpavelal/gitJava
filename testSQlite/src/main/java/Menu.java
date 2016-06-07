import dao.AuthorDao;
import dao.BookDao;
import model.Author;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public Menu() {
    }

    public void viewMenu() {
        BookDao bookStore = new BookDao();
        AuthorDao authorStore = new AuthorDao();

        while (true) {
            System.out.println("Книжная лавка. Exit для выхода.");
            System.out.println("1 - добавление автора");
            System.out.println("2 - обновить автора ");
            System.out.println("3 - удалить автора");
            System.out.println("4 - посмотреть всех авторов");
            System.out.println();
            System.out.println("5 - добавить книгу");
            System.out.println("6 - обновить книгу");
            System.out.println("7 - удалить книгу");
            System.out.println("8 - посмотреть все книги");
            System.out.println("9 - посмотреть все книги и авторов");
            System.out.print("> ");

            Scanner sc = new Scanner(System.in);
            boolean nextInt = sc.hasNextInt();
            System.out.println();
            if (realizationMenu(bookStore, authorStore, sc, nextInt)) continue;

            String text = sc.next();
            if (text.equalsIgnoreCase("exit")) {
                System.out.println("Выход");
                return;
            }
            System.err.println("Нет такого пункта меню");
            System.out.println();
        }


    }

    private boolean realizationMenu(BookDao bookStore, AuthorDao authorStore, Scanner sc, boolean nextInt) {
        if (nextInt) {
            int chose = sc.nextInt();
            if (chose == 1) {
                addAutorByFirstSeconMiddleNames(authorStore, sc);
                return true;
            } else if (chose == 2) {
                updateAuthorFirstSecondMiddleNamesById(authorStore, sc);
                return true;
            } else if (chose == 3) {
                removeAuthorById(authorStore, sc);
                return true;
            } else if (chose == 4) {
                viewAllAuthor(authorStore);
                return true;
            } else if (chose == 5) {
                addNewBookNameAndIdAuthor(bookStore, sc);
                return true;
            } else if (chose == 6) {
                updateBookByNameIdAuthorToId(bookStore, sc);
                return true;
            } else if (chose == 7) {
                removeBookById(bookStore, sc);
                return true;
            } else if (chose == 8) {
                viewAllBooks(bookStore);
                return true;
            } else if (chose == 9) {
                System.out.println("Все авторы:");
                viewAllAuthor(authorStore);
                System.out.println("Все книги");
                viewAllBooks(bookStore);
                return true;
            } else {
                System.err.println("Нет такого пункта меню");
                System.out.println();
                return true;
            }

        }
        return false;
    }

    private void viewAllAuthor(AuthorDao authorStore) {
        for (Object author : authorStore.getListBooksStore()) {
            System.out.println(author);
        }
        logger.info("Просмотрен список авторов.");
        System.out.println();
    }

    private void removeAuthorById(AuthorDao authorStore, Scanner sc) {
        int chose;
        Author author = new Author();
        System.out.print("id автора для удаления: ");
        chose = sc.nextInt();
        author.setAutorId(chose);
        sc.nextLine();

        authorStore.removeInStore(author);

        logger.info("Автор удален.");
        System.out.println();
    }

    private void updateAuthorFirstSecondMiddleNamesById(AuthorDao authorStore, Scanner sc) {
        int chose;
        Author author = new Author();
        System.out.print("id автора для обновления: ");
        chose = sc.nextInt();
        author.setAutorId(chose);
        sc.nextLine();

        System.out.print("Новое имя автора: ");
        String text = sc.next();
        author.setAuthorFirstName(text);
        sc.nextLine();

        System.out.print("Новая фамилия автора: ");
        text = sc.next();
        author.setAuthorSecondName(text);
        sc.nextLine();

        System.out.print("Новое отчество автора: ");
        text = sc.next();
        author.setAuthorMiddleName(text);
        sc.nextLine();


        authorStore.updateInStore(author);

        logger.info("ФИО автора обновлено: " + author);
        System.out.println();
    }

    private void addAutorByFirstSeconMiddleNames(AuthorDao authorStore, Scanner sc) {
        Author author = new Author();
        System.out.print("Имя: ");
        String text = sc.next();
        author.setAuthorFirstName(text);
        sc.nextLine();

        System.out.print("Фамилия: ");
        text = sc.next();
        author.setAuthorSecondName(text);
        sc.nextLine();

        System.out.print("Отчество: ");
        text = sc.next();
        author.setAuthorMiddleName(text);
        sc.nextLine();

        authorStore.addInStore(author);

        logger.info("Автор добавлен: "
                + author.getAuthorFirstName() + " "
                + author.getAuthorSecondName() + " "
                + author.getAuthorMiddleName());
        System.out.println();
        System.out.println();
    }

    private void removeBookById(BookDao bookStore, Scanner sc) {
        int chose;
        Book book = new Book();
        System.out.print("id книги для удаления: ");
        chose = sc.nextInt();
        book.setBookId(chose);
        sc.nextLine();

        bookStore.removeInStore(book);

        logger.info("Книга удалена.");
        System.out.println();
        System.out.println();
    }

    private void updateBookByNameIdAuthorToId(BookDao bookStore, Scanner sc) {
        int chose;
        Book book = new Book();
        System.out.print("id книги для обновления: ");
        chose = sc.nextInt();
        book.setBookId(chose);
        sc.nextLine();

        System.out.print("Новое название книги: ");
        String text = sc.next();
        book.setBookName(text);
        sc.nextLine();

        System.out.print("id автора: ");
        chose = sc.nextInt();
        book.setBookAuthorId(chose);

        bookStore.updateInStore(book);

        logger.info("Книга обновлена: " + book.getBookName());
        System.out.println();
    }

    private void addNewBookNameAndIdAuthor(BookDao bookStore, Scanner sc) {
        int chose;
        Book book = new Book();
        System.out.print("Название книги: ");
        String text = sc.next();
        book.setBookName(text);
        sc.nextLine();


        System.out.print("id автора: ");
        chose = sc.nextInt();
        book.setBookAuthorId(chose);

        bookStore.addInStore(book);
        logger.info("Книга добавлена: " + book.getBookName());
        System.out.println();

        return;
    }

    private void viewAllBooks(BookDao bookStore) {
        for (Object books : bookStore.getListBooksStore()) {
            System.out.println(books);
        }
        logger.info("Просмотрен список книг");
        System.out.println();
        return;
    }


}
