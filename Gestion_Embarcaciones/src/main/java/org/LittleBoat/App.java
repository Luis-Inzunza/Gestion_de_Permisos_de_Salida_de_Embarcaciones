package org.LittleBoat;

import org.LittleBoat.Controller.LoginController;
import org.LittleBoat.Controller.NavWDController;
import org.LittleBoat.Controller.TableButtonsController;
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
       //TableButtonsController tableButtonsController = new TableButtonsController(navigationWindow);
       Login login = new Login();
       NavWDController navigationController = new NavWDController(navigationWindow/*,tableButtonsController*/);
       navigationWindow.setVisible(true);
      /*  
       LoginController appLogin = new LoginController(navigationWindow, login);
        login.setVisible(true);*/
    }
}
