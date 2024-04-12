package AlienDestruction.Scenes;

import AlienDestruction.App;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

    public class GameScreen extends MenuManager {

        private App app;

        @Override
        public void setupScene() {
            setBackgroundColor(Color.BLACK);
        }


        @Override
        public void setupEntities() {
            var gameScreenText = new TextEntity(
                    new Coordinate2D(getWidth() / 2, getHeight() / 4),
                    "Game Screen text");
            gameScreenText.setAnchorPoint(AnchorPoint.TOP_CENTER);
            gameScreenText.setFill(Color.ANTIQUEWHITE);
            gameScreenText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
            addEntity(gameScreenText);

        }
    }
