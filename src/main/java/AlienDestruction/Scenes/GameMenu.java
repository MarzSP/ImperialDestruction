package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.Button;
import AlienDestruction.Buttons.QuitGameButton;
import AlienDestruction.Buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.nio.MappedByteBuffer;

public class GameMenu extends MenuManager {

    public void setupScene() {
        setBackgroundImage("backgrounds/universe1.jpg");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();
        var gameMenuText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "Game Menu");
        gameMenuText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        gameMenuText.setFill(Color.ANTIQUEWHITE);
        gameMenuText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
        addEntity(gameMenuText);

        var quitGameButton = new QuitGameButton(new Coordinate2D(getWidth() / 2, getHeight() * 5/6), "Quit Game");
        addEntity(quitGameButton);

    }
}
