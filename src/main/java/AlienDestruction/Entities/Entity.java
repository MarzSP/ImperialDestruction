package AlienDestruction.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Entity extends DynamicSpriteEntity {
    protected Entity(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
