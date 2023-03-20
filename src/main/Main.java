package main;

import com.google.gson.Gson;
import control.Controller;
import model.Game;
import view.HomePage;

public class Main {
    Gson gson = new Gson();

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        Game game = new Game();
        Controller controller = new Controller(homePage,game);
    }
}
