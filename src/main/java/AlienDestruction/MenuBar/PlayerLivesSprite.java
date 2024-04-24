package AlienDestruction.MenuBar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerLivesSprite extends DynamicSpriteEntity {
    public PlayerLivesSprite(Coordinate2D location) {
        super("sprites/xWingV1.png", location, new Size(30,60));
    }
}
