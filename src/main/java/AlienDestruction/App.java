package AlienDestruction;


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
    addScene(2, new Endscreen());
    addScene(3, new GameMenu());
    setActiveScene(0);
    }
    public class SceneIds {
        public static final int StartScreen = 0;
        public static final int GameScreen = 1;
        public static final int Endscreen = 2;
        public static final int GameMenu = 3;
    }

}
