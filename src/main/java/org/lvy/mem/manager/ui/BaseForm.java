package org.lvy.mem.manager.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by livvy on 15/8/26.
 */
public abstract class BaseForm extends JFrame{

    public BaseForm(int width,int height,boolean isFullScreen) {
        this.setTitle("Memcache Manager");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (isFullScreen) {
            this.setSize(screenSize);
        } else {
            this.setSize(width, height);
            this.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
        }
    }

    public BaseForm(int width,int height) {
        this(width, height,false);
    }
}
