package AlienDestruction.Entities.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.ContinuousRotatable;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

/**De klasse PowerUpLives is een power-up in de game die 1 extra leven toevoegt aan de speler.
 * Deze klasse erft van de PowerUps klasse en implementeert de ContinuousRotatable interface.
 * De implementatie van PowerUpLives zit in Player in OnCollision.
 */
public class PowerUpLives extends PowerUps implements ContinuousRotatable {

    public PowerUpLives (Coordinate2D initialLocation) {
        super("sprites/xWingPowerUp.png", initialLocation, new Size(40,40));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
        this.setRotationSpeed(2);
    }

    }


