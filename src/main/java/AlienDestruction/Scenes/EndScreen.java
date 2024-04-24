package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.PlayAgainButton;
import AlienDestruction.Buttons.QuitGameButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.YaegerScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Deze klasse EndScreen is een sub-klasse van StaticScene (niet MenuManager) en implementeert YaegerScene.
 * Het toont het "GAME OVER" scherm. Deze bevat een achtergrond image, de tekst "Game Over", de score, de optie om opnieuw te spelen, en een 'Quit Game' button.
 */
public class EndScreen extends StaticScene implements YaegerScene{

    private App app;

    public EndScreen(App app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe1.jpg");
    }


    @Override
    public void setupEntities() {
        var gameMenuText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "GAME OVER!");
        gameMenuText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        gameMenuText.setFill(Color.ANTIQUEWHITE);
        gameMenuText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(gameMenuText);

        var scoreText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "Score: "); // Zet hier na "Score: " + getScore();
        scoreText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        scoreText.setFill(Color.ANTIQUEWHITE);
        scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(scoreText);

        PlayAgainButton playButton;
        playButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2, getHeight() * 4/6), app);
        addEntity(playButton);

       var quitGameButton = new QuitGameButton(new Coordinate2D(getWidth() / 2, getHeight() * 5/6), "Quit Game");
        addEntity(quitGameButton);

    }
}