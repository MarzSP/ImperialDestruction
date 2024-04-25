package AlienDestruction.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PowerUps extends DynamicSpriteEntity implements Collider {
    private Player player;

    public PowerUps(Coordinate2D initialLocation) {
        super("sprites/xWingPowerUp.png", initialLocation, new Size(40,40));
        setMotion(4, 360d);

    }

    }
    //super("sprites/xWingV1.png", location, );

