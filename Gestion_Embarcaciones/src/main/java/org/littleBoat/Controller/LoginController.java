package org.littleboat.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.littleboat.View.Login;
import org.littleboat.View.NavigationWindow;

public class LoginController {
    private final Login localLogin;
    private final String in_Password = "popeye";
    private NavWDController localNavigationController;
    private NavigationWindow localNavigationWindow;
    public LoginController(NavigationWindow in_NavigationWindow,Login in_Login){
        localNavigationWindow = in_NavigationWindow;
        localLogin = in_Login;
        localLogin.setAccessBtnListener(new accessBtnHandler());
    }
    private class accessBtnHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String out_password = localLogin.getAccessTextFieldText();
            if(out_password.equals(in_Password)){
                localNavigationController = new NavWDController(localNavigationWindow);
                localNavigationWindow.setVisible(true);  
            }
        }

    }

}
