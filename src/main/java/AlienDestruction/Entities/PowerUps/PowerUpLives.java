package AlienDestruction.Entities.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PowerUpLives extends PowerUps {

    public PowerUpLives (Coordinate2D initialLocation) {
        super("sprites/xWingPowerUp.png", initialLocation, new Size(40,40));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
    }

    }


