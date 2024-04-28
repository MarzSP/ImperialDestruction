package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Weapons.LaserBeam;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class ObstacleTwo extends GameEntities{
    public ObstacleTwo(Coordinate2D location) {
        super("sprites/asteroidRectangleV1.png", location, new Size(140,100));
        setMotion(3, 360d);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject){
            if (collider instanceof LaserBeam){
                ((WeaponType) collider).remove();   // remove Laser / Weapon
            }
        }
    }
}
