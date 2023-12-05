package org.LittleBoat;

import org.LittleBoat.Controller.LoginController;
import org.LittleBoat.View.Login;
import org.LittleBoat.View.NavigationWindow;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //NuevoTripulante barco = new NuevoTripulante();
        //barco.setVisible(true);
       NavigationWindow navigationWindow = new NavigationWindow();
       Login login = new Login();
       LoginController appLogin = new LoginController(navigationWindow, login);
        login.setVisible(true);
    }
}
