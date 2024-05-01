package AlienDestruction.Entities.PowerUps;
import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.ContinuousRotatable;

public class PowerUpShip extends PowerUps implements ContinuousRotatable {
    public static final long PowerUpShipTime = 10000;

    public PowerUpShip(Coordinate2D initialLocation) {
        super("sprites/PowerUpShip.png", initialLocation, new Size(Helper.Size.SMALL, Helper.Size.SMALL));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
        this.setRotationSpeed(2);
    }
}

