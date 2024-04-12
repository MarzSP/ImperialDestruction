package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Entities.Player;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

    public class GameScreen extends DynamicScene {

        private App app;

        public GameScreen(App app) {
            this.app = app;
        }

        @Override
        public void setupScene() {
            setBackgroundImage("backgrounds/universe2.jpg");
            //setBackgroundColor(Color.BLACK);
        }


        @Override
        public void setupEntities() {
            var gameScreenText = new TextEntity(
                    new Coordinate2D(getWidth() / 2, getHeight() / 4));
            gameScreenText.setAnchorPoint(AnchorPoint.TOP_CENTER);
            gameScreenText.setFill(Color.ANTIQUEWHITE);
            gameScreenText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
            addEntity(gameScreenText);

            var playerSprite = new Player(new Coordinate2D(getWidth() / 2, 550), new App());
            addEntity(playerSprite);

        }
    }
