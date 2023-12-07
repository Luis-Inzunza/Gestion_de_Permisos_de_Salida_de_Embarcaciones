package org.LittleBoat.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.LittleBoat.View.Login;
import org.LittleBoat.View.NavigationWindow;
import org.LittleBoat.security.Key;

public class LoginController {
    private final Key key;
    private final Login localLogin;
    private final String loginPassword;
    private NavWDController localNavigationController;
    private NavigationWindow localNavigationWindow;

    public LoginController(NavigationWindow in_NavigationWindow, Login in_Login) {
        localNavigationWindow = in_NavigationWindow;
        localLogin = in_Login;
        localLogin.setAccessBtnListener(new accessBtnHandler());
        this.key = new Key();
        loginPassword = key.obtainKey();
        localNavigationController = new NavWDController(localNavigationWindow);
        localNavigationWindow.setVisible(true);
    }

    private class accessBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String out_password = localLogin.getAccessTextFieldText();
            if (out_password.equals(loginPassword)) {
                localNavigationController = new NavWDController(localNavigationWindow);
                localNavigationWindow.setVisible(true);
            }
        }

    }

}
