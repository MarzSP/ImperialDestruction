package AlienDestruction.Entities.PowerUps;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class PowerUpLaser extends PowerUps{
    public PowerUpLaser(Coordinate2D initialLocation) {
        super("sprites/LaserPowerUp.png", initialLocation,new Size(40, 40));
        setMotion(Helper.Speed.LOW, Helper.Direction.DOWN);
    }
}
