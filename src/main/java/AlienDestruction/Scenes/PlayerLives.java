package AlienDestruction.Scenes;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerLives extends DynamicSpriteEntity {
    public PlayerLives(Coordinate2D location) {
        super("sprites/xWingV1.png", location, new Size(30,60));
    }
}
