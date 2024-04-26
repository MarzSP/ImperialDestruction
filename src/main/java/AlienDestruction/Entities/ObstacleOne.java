package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Weapons.LaserBeam;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class ObstacleOne extends GameEntities{
    public ObstacleOne(Coordinate2D location) {
        super("sprites/asteroidSquareV1.png", location, new Size(100,95));
        setMotion(Helper.Speed.LOW, Helper.Direction.DOWN);
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
