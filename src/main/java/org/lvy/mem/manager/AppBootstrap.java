package org.lvy.mem.manager;

import org.lvy.mem.manager.ui.LoginForm;

import javax.swing.*;

/**
 * Created by livvy on 15/8/24.
 */
public class AppBootstrap {
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(700, 500);
        loginForm.setVisible(true);
        loginForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
