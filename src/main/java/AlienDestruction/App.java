package AlienDestruction;


import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Scenes.EndScreen;
import AlienDestruction.Scenes.GameMenu;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Scenes.StartScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/** App is de hoofd-klasse van deze game applicatie, deze erfst van YaegerGame.
 * De App klasse is verantwoordelijk voor het initialiseren van de game-instellingen, het opzetten van de verschillende schermen (scenes).
 * App start ook de game op.
 */
public class App extends YaegerGame {

    public static void main(String[] args ) {
        launch("--noSplash");
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

    }

}
