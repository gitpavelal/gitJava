import dao.BookDao;
import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public Menu() {
    }

    public void viewMenu() {
        BookDao bookStore = new BookDao();


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

            if (nextInt) {
                int chose = sc.nextInt();
                if (chose == 1) {
                    System.out.println("odin");
                    System.out.println();
                    continue;
                } else if (chose == 2) {
                    System.out.println("dva");
                    System.out.println();
                    continue;
                } else if (chose == 3) {
                    System.out.println("tri");
                    System.out.println();
                    continue;
                } else if (chose == 4) {
                    System.out.println("четыре");
                    System.out.println();
                    continue;
                } else if (chose == 5) {
                    addNewBookNameAndIdAuthor(bookStore, sc);
                    continue;
                } else if (chose == 6) {
                    updateBookByNameIdAuthorToId(bookStore, sc);
                    continue;
                } else if (chose == 7) {
                    Book book = new Book();
                    System.out.print("id книги для удаления: ");
                    chose = sc.nextInt();
                    book.setBookId(chose);
                    sc.nextLine();

                    bookStore.removeInStore(book);

                    logger.info("Книга удалена: " + book.getBookName());
                    System.out.println();


                    System.out.println();
                    continue;
                } else if (chose == 8) {
                    viewAllBooks(bookStore);
                    continue;
                } else if (chose == 9) {
                    System.out.println("tri");
                    continue;
                } else {
                    System.err.println("Нет такого пункта меню");
                    System.out.println();
                    continue;
                }

            }
            String text = sc.next();

            if (text.equalsIgnoreCase("exit")) {
                System.out.println("Выход");
                return;
            }
            System.err.println("Нет такого пункта меню");
            System.out.println();
        }


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
