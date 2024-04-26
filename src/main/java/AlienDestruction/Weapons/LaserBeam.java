package AlienDestruction.Weapons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class LaserBeam extends WeaponType {
    public LaserBeam(Coordinate2D initialLocation) {
        super("sprites/laserred.png", initialLocation, new Size(3,16));
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {

    }

}


