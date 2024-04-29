package AlienDestruction.Entities.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.ContinuousRotatable;

public class PowerUpLaser extends PowerUps implements ContinuousRotatable {
    public PowerUpLaser(Coordinate2D initialLocation) {
        super("sprites/LaserPowerUp.png", initialLocation,new Size(40, 40));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
        this.setRotationSpeed(2);
    }
}
