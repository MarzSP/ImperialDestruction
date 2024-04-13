package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.MenuButton;
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
            MenuButton menuButton = new MenuButton(app, new Coordinate2D(800, 10));
            addEntity(menuButton);


            var playerSprite = new Player(new Coordinate2D(getWidth() / 2, 550), new App());
            addEntity(playerSprite);

        }
    }
