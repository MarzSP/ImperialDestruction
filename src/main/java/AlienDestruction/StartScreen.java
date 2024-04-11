package AlienDestruction;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScreen extends MenuManager {
    private final App app; // referentie naar app class

    public StartScreen(App app) {
        this.app = app;
    }

    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        super.setupEntities();
        var startmenuText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "Alien Destruction"
        );
        startmenuText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        startmenuText.setFill(Color.ANTIQUEWHITE);
        startmenuText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
        addEntity(startmenuText);
       int scene = 0;

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(startButton);
    }
    }

