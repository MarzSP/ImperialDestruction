package AlienDestruction.Scenes;

import AlienDestruction.App;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.YaegerScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScreen extends StaticScene implements YaegerScene{

    private App app;

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }


    @Override
    public void setupEntities() {
        var endscreenText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "End Screen text");
        endscreenText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        endscreenText.setFill(Color.ANTIQUEWHITE);
        endscreenText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
        addEntity(endscreenText);

    }
}