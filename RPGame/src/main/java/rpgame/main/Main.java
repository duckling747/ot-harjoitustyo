package rpgame.main;

import java.util.Random;
import static javafx.application.Application.launch;
import rpgame.UI.Menu;

public class Main {

    public static final Random RANDOM_SOURCE
            = new Random();

    public static void main(String[] args) {
        launch(Menu.class);
    }

}
