package org.java2.lesson2.view.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;

public class SelectFrame<T> extends BaseFrame {
    public static interface SelectFrameInterface<T> {
        Object[] getArray(T t);
    }

    private JTable table;
    private DefaultTableModel model;
    private SelectFrameInterface<T> selectFrameInterface;

    //ctrl+q -> документация
    public SelectFrame(String title, int width, int height, final SelectFrameInterface<T> selectFrameInterface, String[] columns) throws HeadlessException {
        super(title, width, height);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.model = new DefaultTableModel(columns, 1);
        this.table = new JTable(this.model);
        JScrollPane pane = new JScrollPane(this.table);
        this.getContentPane().add(pane);
        this.selectFrameInterface = selectFrameInterface;
    }

    public void showData(final Collection<T> collection) {
        this.model.setRowCount(0);
        for (T t : collection) {
            this.model.addRow(this.selectFrameInterface.getArray(t));
        }
    }
}
