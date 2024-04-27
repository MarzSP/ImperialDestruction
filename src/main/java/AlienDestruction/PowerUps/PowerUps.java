package AlienDestruction.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PowerUps extends DynamicSpriteEntity implements Collider {

    public PowerUps(Coordinate2D initialLocation) {
        super("sprites/xWingPowerUp.png", initialLocation, new Size(40,40));
        setMotion(Helper.Speed.MEDIUM, Helper.Direction.DOWN);
    }

    }


