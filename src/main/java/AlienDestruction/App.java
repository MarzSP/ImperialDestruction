package AlienDestruction;


import AlienDestruction.Scenes.EndScreen;
import AlienDestruction.Scenes.GameMenu;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Scenes.StartScreen;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class App extends YaegerGame {

    public static void main(String[] args )
    {
        launch(args);
        System.out.println("Hallo hub");
        System.out.println("Test");

    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {

    addScene(0, new StartScreen(this));
    addScene(1, new GameScreen());
    addScene(2, new EndScreen());
    addScene(3, new GameMenu());
    setActiveScene(0);
    }
    public class SceneIds {
        public static final int StartScreen = 0;
        public static final int GameScreen = 1;
        public static final int EndScreen = 2;
        public static final int GameMenu = 3;
    }

}
