import dao.BookDao;

import java.util.Scanner;

public class Menu{


    public Menu() {
    }

    public void viewMenu () {
        BookDao bookDao = new BookDao();
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
                if (chose == 1){
                    System.out.println("odin");
                    System.out.println();
                    continue;
                }else if (chose == 2){
                    System.out.println("dva");
                    System.out.println();
                    continue;
                }else if (chose == 3){
                    System.out.println("tri");
                    System.out.println();
                    continue;
                }else if (chose == 4){
                    System.out.println("четыре");
                    System.out.println();
                    continue;
                }else if (chose == 5){
                    System.out.println("пять");
                    System.out.println();
                    continue;
                }else if (chose == 6){
                    System.out.println("шесть");
                    System.out.println();
                    continue;
                }else if (chose == 7){
                    System.out.println("семь");
                    System.out.println();
                    continue;
                }else if (chose == 8){
                    for (Object books: bookDao.getListBooksStore()
                            ) {
                        System.out.println(books);
                    }

                    System.out.println();
                    continue;
                }else if (chose == 9){
                    System.out.println("tri");
                    continue;
                }else{
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



}
