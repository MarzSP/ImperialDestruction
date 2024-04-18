package AlienDestruction.Weapons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class LaserBeam extends WeaponType {
    public LaserBeam(Coordinate2D initialLocation) {
        super("sprites/laserred.png", initialLocation, new Size(3,16));
    }
}

//protected LaserBeam(String resource, Coordinate2D initialLocation, Size size) {
//    super(resource, initialLocation, size);
//}
