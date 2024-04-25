package AlienDestruction.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PowerUps extends DynamicSpriteEntity implements Collider {
    private Player player;

    public PowerUps(Coordinate2D initialLocation) {
        super("sprites/heartpower.png", initialLocation);
        setMotion(4, 360d);

    }

    }

