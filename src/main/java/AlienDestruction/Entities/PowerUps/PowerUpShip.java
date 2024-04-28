package AlienDestruction.Entities.PowerUps;
import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class PowerUpShip extends PowerUps {
    private static final long PowerUpShipTime = 10000;

    public PowerUpShip(Coordinate2D initialLocation) {
        super("sprites/PowerUpShip.png", initialLocation, new Size(40, 40));
        setMotion(Helper.Speed.HIGH, Helper.Direction.DOWN);
    }
}


// On Collision in Player - werkt niet 
//else if (collider instanceof PowerUpShip) { // PowerUp dubbelschip
//powerUpCollision = true;
//Player tempPlayer = new Player(getLocationInScene(), gameScreen, app);
// tempPlayer.isTempPlayerActive = true;  // Set flag for temporary player
//((PowerUpShip) collider).remove();
// break;

//}