package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.PlayAgainButton;
import AlienDestruction.Buttons.QuitGameButton;
import AlienDestruction.Entities.Player;
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
 * StaticScene: EndScreen erft van de StaticScene klasse, wat betekent dat de achtergrondafbeelding en entiteiten niet zullen veranderen tijdens het tonen van de EndScreen.
 */
public class EndScreen extends StaticScene implements YaegerScene{

    private App app;
    private Player player;

    /**
     * Constructor: initialiseert de app referentie met de meegegeven App object. Dit zodat er een sceneverandering kan plaatsvinden.
     * @param app
     * Ook initialiseert het de player referentie met het meegegeven Player object. Dit zodat de score kan worden opgehaald uit Player.
     */
    public EndScreen(App app) {
        this.app = app;
        this.player = player;
    }

    /**
     * setupScene zet de achtergrondafbeelding van deze scene.
     */
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe1.jpg");
    }

    /**
     * De methode setupEntities initialiseert en voegt de entiteiten toe aan de scene.
     * New TextEntity: Game Over
     * New TextEntity: Score: (de waarde van score wordt toegevoegd met de getScore() methode.
     * PlayAgainButton entiteit, welke een eigen class is: een actie om het spel opnieuw te starten.
     * QuitGameButton entiteit, welke een eigen class is: een actie om het spel te beeindigen.
     */
    @Override
    public void setupEntities() {
        var gameMenuText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "GAME OVER!");
        gameMenuText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        gameMenuText.setFill(Color.ANTIQUEWHITE);
        gameMenuText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, getWidth()/25));
        addEntity(gameMenuText);

        var scoreText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "Score: ");
        scoreText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        scoreText.setFill(Color.ANTIQUEWHITE);
        scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, getHeight()/ 20));
        addEntity(scoreText);

        PlayAgainButton playButton;
        playButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2, getHeight() * 4/6), app);
        addEntity(playButton);

       var quitGameButton = new QuitGameButton(new Coordinate2D(getWidth() / 2, getHeight() * 5/6), "Quit Game");
        addEntity(quitGameButton);

    }
}