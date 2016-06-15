package org.java2.lesson2.view.ui;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {

    public BaseFrame(final String title, final int width, final int height) throws HeadlessException {
        this.setTitle(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(width, height);
    }
}
