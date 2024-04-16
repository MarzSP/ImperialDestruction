package AlienDestruction;


import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Scenes.EndScreen;
import AlienDestruction.Scenes.GameMenu;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class App extends YaegerGame {

    public static void main(String[] args ) {
        System.out.println("Test 16 april");
        launch(args);
        System.out.println("Hallo hub end");
    }

    @Override
    public void setupGame() {
        setGameTitle("AlienDestruction");
        setSize(new Size(1000, 700));
    }

    @Override
    public void setupScenes() {

    addScene(0, new StartScreen(this));
    addScene(1, new GameScreen(this));
    addScene(2, new EndScreen(this));
    addScene(3, new GameMenu());
    //setActiveScene(2);
    }

    public class SceneIds {
        public static final int StartScreen = 0;
        public static final int GameScreen = 1;
        public static final int EndScreen = 2;
        public static final int GameMenu = 3;
    }
}
