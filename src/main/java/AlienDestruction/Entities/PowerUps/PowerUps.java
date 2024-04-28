package AlienDestruction.Entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PowerUps extends DynamicSpriteEntity implements Collider {
    protected PowerUps(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}
