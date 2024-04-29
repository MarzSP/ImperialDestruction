package AlienDestruction.Entities.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.ContinuousRotatable;

/**De klasse PowerUpLaser is een power-up in de game die de laser van de speler upgradet.
 * Deze klasse erft van de PowerUps klasse en implementeert de ContinuousRotatable interface.
 * De implementatie van deze klasse bevind zich in Player in public void activateLaserPowerUp():
 * Wanneer de Spatiebalk ingedrukt wordt, kan de speler 10 seconden lang extra snel lasers afvuren.
 */
public class PowerUpLaser extends PowerUps implements ContinuousRotatable {
    public PowerUpLaser(Coordinate2D initialLocation) {
        super("sprites/LaserPowerUp.png", initialLocation,new Size(40, 40));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
        this.setRotationSpeed(2);
    }
}
