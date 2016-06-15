package org.java2.lesson2.view.ui;

import org.java2.lesson2.control.common.DbFacade;
import org.java2.lesson2.model.Author;

public class App {
    public static void main(String[] args) {
        BaseFrame frame = new BaseFrame("Hello", 400, 600);
        frame.setVisible(true);

        SelectFrame<Author> selectFrame = new SelectFrame<>("Select", 600, 400,
                new SelectFrame.SelectFrameInterface<Author>() {
                    @Override
                    public Object[] getArray(final Author author) {
                        return new Object[]{
                                author.getId(),
                                author.getFirstName(),
                                author.getSecondName(),
                                author.getMiddleName()
                        };
                    }
                }, new String[]{"id", "имя", "фамилия", "отчество"});
        selectFrame.showData(DbFacade.getInstance().getAuthorDao().select());
        selectFrame.setVisible(true);

        InsertFrameAuthor insertFrameAuthor = new InsertFrameAuthor("Insert Author", 600, 400);
        insertFrameAuthor.setVisible(true);
    }
}
