package org.java2.lesson2.view.ui;

import org.java2.lesson2.control.common.DbFacade;
import org.java2.lesson2.model.Author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertFrameAuthor extends BaseFrame {

    public InsertFrameAuthor(String title, int width, int height) throws HeadlessException {
        super(title, width, height);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Box box = Box.createVerticalBox();
        JLabel nameLabel = new JLabel("имя");
        final JLabel surnameLabel = new JLabel("фамилия");
        final JLabel middleLabel = new JLabel("отчество");
        final JLabel resLabel = new JLabel("Результат:");

        final JTextField nameTextField = new JTextField();
        final JTextField surnameTextField = new JTextField();
        final JTextField middleTextField = new JTextField();

        nameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameTextField.getPreferredSize().height));
        surnameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, surnameTextField.getPreferredSize().height));
        middleTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, middleTextField.getPreferredSize().height));

        JButton button = new JButton("Добавить автора!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Author author = new Author();
                author.setFirstName(nameTextField.getText());
                author.setSecondName(surnameTextField.getText());
                author.setMiddleName(middleTextField.getText());
                if (DbFacade.getInstance().getAuthorDao().insert(author)) {
                    resLabel.setText("Сохранено!");
                } else {
                    resLabel.setText("Ошибка сохранения!");
                }
            }
        });

        box.add(nameLabel);
        box.add(nameTextField);
        box.add(surnameLabel);
        box.add(surnameTextField);
        box.add(middleLabel);
        box.add(middleTextField);

        box.add(button);

        box.add(resLabel);
        this.setContentPane(box);
    }
}
