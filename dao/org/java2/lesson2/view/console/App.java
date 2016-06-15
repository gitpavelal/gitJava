package org.java2.lesson2.view.console;

import dnl.utils.text.table.TextTable;
import org.java2.lesson2.control.common.DbFacade;
import org.java2.lesson2.model.Author;
import org.java2.lesson2.model.Book;

import java.util.Collection;
import java.util.Scanner;

/**
 * Консольное приложение
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет, это книжная лавка!(exit в любом месте для выхода из программы, mainmenu в любом месте программы для возврата в главное меню)");
            try {
            while (true) {
                System.out.println("Выберете опцию:");
                System.out.println("1)добавить автора");
                System.out.println("2)обновить автора");
                System.out.println("3)удалить автора");
                System.out.println("4)посмотреть всех авторов");
                System.out.println("5)добавить книгу");
                System.out.println("6)обновить книгу");
                System.out.println("7)удалить книгу");
                System.out.println("8)посмотреть все книги");
                System.out.println("9)просмотреть все книги и соответствующих авторов");
                try {
                    switch (Integer.parseInt(fromConsole(scanner))) {
                        case 1:
                            insertAuthor(scanner);
                            break;
                        case 2:
                            updateAuthor(scanner);
                            break;
                        case 3:
                            deleteAuthor(scanner);
                            break;
                        case 4:
                            selectAuthors();
                            break;
                        case 5:
                            insertBook(scanner);
                            break;
                        case 6:
                            updateBook(scanner);
                            break;
                        case 7:
                            deleteBook(scanner);
                            break;
                        case 8:
                            selectBooks();
                            break;
                        case 9:
                            selectBooksWithAuthors();
                            break;
                        default:
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Попробуйте еще раз");
                    continue;
                } catch (MainMenuException e) {
                    System.out.println("Вы вернулись в главное меню");
                    continue;
                }
            }
        } catch (ExitException e) {
            System.exit(0);
        }
    }

    private static void selectBooksWithAuthors() {
        Collection<Book> books = DbFacade.getInstance().getBookDao().select();
        Collection<Author> authors = DbFacade.getInstance().getAuthorDao().select();
        String[] columns = {"Название", "Имя", "Фамилия", "Отчество"};
        Object[][] data = new Object[books.size()][columns.length];
        int i = 0;
        for (Book book : books) {
            Object[] dataObjects = data[i++];
            dataObjects[0] = book.getName();
            Author author = getAuthor(authors, book.getAuthor());
            if (author == null)
                continue;
            dataObjects[1] = author.getFirstName();
            dataObjects[2] = author.getSecondName();
            dataObjects[3] = author.getMiddleName();
        }
        new TextTable(columns, data).printTable();
    }

    private static Author getAuthor(final Collection<Author> authors, final Integer id) {
        if (id == null)
            return null;
        if (authors == null || authors.isEmpty())
            return null;
        for (Author author : authors) {
            if (id.equals(author.getId()))
                return author;
        }
        return null;
    }

    private static void updateAuthor(final Scanner scanner) {
        selectAuthors();
        System.out.println("Введите идентификатор автора:");
        Integer author = null;
        while (true) {
            try {
                author = Integer.valueOf(fromConsole(scanner));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Попробуйте еще раз");
            }
        }
        Author a = new Author();
        a.setIdentity(author);
        System.out.println("Введите новое имя:");
        a.setFirstName(fromConsole(scanner));
        System.out.println("Введите новую фамилию:");
        a.setSecondName(fromConsole(scanner));
        System.out.println("Введите новое отчество:");
        a.setMiddleName(fromConsole(scanner));
        System.out.println("Вы уверены что хотите обновить автора?(Y / N)");
        Boolean decision = null;
        while (true) {
            String s = fromConsole(scanner);
            if ("YN".contains(s.toUpperCase())) {
                if ("Y".equalsIgnoreCase(s)) {
                    decision = Boolean.TRUE;
                    break;
                } else if ("N".equalsIgnoreCase(s)) {
                    decision = Boolean.FALSE;
                    break;
                }
            }
            System.out.println("Попробуйте еще раз");
        }
        if (decision) {
            DbFacade.getInstance().getAuthorDao().update(a);
            System.out.println("Сохранен");
        } else {
            System.out.println("Не сохранен");
        }
    }

    private static void updateBook(final Scanner scanner) {
        selectAuthors();
        System.out.println("Введите идентификатор книги:");
        Integer book = null;
        while (true) {
            try {
                book = Integer.valueOf(fromConsole(scanner));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Попробуйте еще раз");
            }
        }
        Book b = new Book();
        b.setIdentity(book);
        System.out.println("Введите новое название:");
        b.setName(fromConsole(scanner));
        System.out.println("Введите нового автора:");
        while (true) {
            try {
                b.setAuthor(Integer.valueOf(fromConsole(scanner)));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Должно быть числом");
            }
        }
        System.out.println("Вы уверены что хотите обновить книгу?(Y / N)");
        Boolean decision = null;
        while (true) {
            String s = fromConsole(scanner);
            if ("YN".contains(s.toUpperCase())) {
                if ("Y".equalsIgnoreCase(s)) {
                    decision = Boolean.TRUE;
                    break;
                } else if ("N".equalsIgnoreCase(s)) {
                    decision = Boolean.FALSE;
                    break;
                }
            }
            System.out.println("Попробуйте еще раз");
        }
        if (decision) {
            DbFacade.getInstance().getBookDao().update(b);
            System.out.println("Сохранена");
        } else {
            System.out.println("Не сохранена");
        }
    }

    private static void deleteAuthor(final Scanner scanner) {
        selectAuthors();
        System.out.println("Введите идентификатор автора:");
        Integer author = null;
        while (true) {
            try {
                author = Integer.valueOf(fromConsole(scanner));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Попробуйте еще раз");
            }
        }
        System.out.println("Вы уверены что хотите удалить автора?(Y / N)");
        Boolean decision = null;
        while (true) {
            String s = fromConsole(scanner);
            if ("YN".contains(s.toUpperCase())) {
                if ("Y".equalsIgnoreCase(s)) {
                    decision = Boolean.TRUE;
                    break;
                } else if ("N".equalsIgnoreCase(s)) {
                    decision = Boolean.FALSE;
                    break;
                }
            }
            System.out.println("Попробуйте еще раз");
        }
        if (decision) {
            Author a = new Author();
            a.setIdentity(author);
            DbFacade.getInstance().getAuthorDao().delete(a);
            System.out.println("Удален");
        } else {
            System.out.println("Не удален");
        }
    }

    private static void deleteBook(final Scanner scanner) {
        selectBooks();
        System.out.println("Введите идентификатор книги:");
        Integer book = null;
        while (true) {
            try {
                book = Integer.valueOf(fromConsole(scanner));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Попробуйте еще раз");
            }
        }
        System.out.println("Вы уверены что хотите удалить книгу?(Y / N)");
        Boolean decision = null;
        while (true) {
            String s = fromConsole(scanner);
            if ("YN".contains(s.toUpperCase())) {
                if ("Y".equalsIgnoreCase(s)) {
                    decision = Boolean.TRUE;
                    break;
                } else if ("N".equalsIgnoreCase(s)) {
                    decision = Boolean.FALSE;
                    break;
                }
            }
            System.out.println("Попробуйте еще раз");
        }
        if (decision) {
            Book b = new Book();
            b.setIdentity(book);
            DbFacade.getInstance().getBookDao().delete(b);
            System.out.println("Удалена");
        } else {
            System.out.println("Не удалена");
        }
    }

    private static void selectAuthors() {
        Collection<Author> authors = DbFacade.getInstance().getAuthorDao().select();
        String[] columns = {"id", "Имя", "Фамилия", "Отчество"};
        Object[][] data = new Object[authors.size()][columns.length];
        int i = 0;
        for (Author author : authors) {
            Object[] authorData = data[i++];
            authorData[0] = author.getId();
            authorData[1] = author.getFirstName();
            authorData[2] = author.getSecondName();
            authorData[3] = author.getMiddleName();
        }
        new TextTable(columns, data).printTable();
    }

    private static void selectBooks() {
        Collection<Book> books = DbFacade.getInstance().getBookDao().select();
        String[] columns = {"id", "Название", "Автор ID"};
        Object[][] data = new Object[books.size()][columns.length];
        int i = 0;
        for (Book book : books) {
            Object[] bookData = data[i++];
            bookData[0] = book.getId();
            bookData[1] = book.getName();
            bookData[2] = book.getAuthor();
        }
        new TextTable(columns, data).printTable();
    }

    private static void insertAuthor(final Scanner scanner) {
        Author author = new Author();
        System.out.println("Введите имя:");
        author.setFirstName(fromConsole(scanner));
        System.out.println("Введите фамилию:");
        author.setSecondName(fromConsole(scanner));
        System.out.println("Введите отчество:");
        author.setMiddleName(fromConsole(scanner));
        if (DbFacade.getInstance().getAuthorDao().insert(author)) {
            System.out.println(String.format("Сохранен, идентификатор = %s", author.getIdentity()));
            return;
        }
        System.out.println("Не сохранен");
    }

    private static void insertBook(final Scanner scanner) {
        Book book = new Book();
        System.out.println("Введите название:");
        book.setName(fromConsole(scanner));
        System.out.println("Введите автора:");
        while (true) {
            try {
                book.setAuthor(Integer.valueOf(fromConsole(scanner)));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Должно быть числом");
            }
        }
        if (DbFacade.getInstance().getBookDao().insert(book)) {
            System.out.println(String.format("Сохранена, идентификатор = %s", book.getIdentity()));
            return;
        }
        System.out.println("Не сохранена");
    }

    /**
     * Получение строки из консоли от пользователя
     *
     * @param scanner
     * @return строка из консоли
     */
    private static String fromConsole(final Scanner scanner) {
        String res = scanner.nextLine().trim();
        if (res.equalsIgnoreCase("exit"))
            throw new ExitException();
        if (res.equalsIgnoreCase("mainmenu"))
            throw new MainMenuException();
        return res;
    }
}
