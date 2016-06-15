package org.java2.lesson2.control.common;

import org.java2.lesson2.control.dao.AuthorDao;
import org.java2.lesson2.control.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс реализующий шаблон Facade, для работы с БД
 * Реализован как класс Singleton
 * Не рассчитан на многопоточность
 */
public class DbFacade {
    /**
     * Экземпляр фасада для работы с БД
     */
    private static DbFacade instance;

    private AuthorDao authorDao;
    private BookDao bookDao;

    /**
     * Объект для логирования
     */
    private static Logger LOG = LoggerFactory.getLogger(DbFacade.class);

    private DbFacade() {
        this.authorDao = new AuthorDao();
        this.bookDao = new BookDao();
        LOG.info("CREATE DbFacade");
    }

    /**
     * Метод для получения экземпляра DbFacade
     *
     * @return Facade для работы с БД
     */
    public static DbFacade getInstance() {
        if (instance == null)
            instance = new DbFacade();
        return instance;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }
}
