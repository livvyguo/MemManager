package org.lvy.mem.manager.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by livvy on 15/8/24.
 */
public class WindowsCloseHandler extends WindowAdapter{

    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        System.exit(0);
    }
}
