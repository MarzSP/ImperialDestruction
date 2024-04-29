package AlienDestruction.Entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

/** Deze klasse is een blauwdruk voor power-ups (PowerUpLives, PowerUpLaser, PowerUpship).
 * Deze klasse is protected zodat er alleen toegang is vanuit de klasse zelf, en de subklassen, om de interne implementatiecode:
 * te verbergen van alles wat buiten scope is.
 */
public class PowerUps extends DynamicSpriteEntity implements Collider {
    protected PowerUps(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}
