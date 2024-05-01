package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Weapons.LaserBeam;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.ContinuousRotatable;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class ObstacleOne extends GameEntities {

    private Player player;

    public ObstacleOne(Coordinate2D location, Player player) {
        super("sprites/asteroidSquareV1.png", location, new Size(Helper.Size.LARGE,Helper.Size.LARGE), player);
        this.player = player;

        setMotion(Helper.Speed.LOW, Helper.Direction.DOWN);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject){
            if (collider instanceof LaserBeam){
                bounceOff((WeaponType) collider);
                //((WeaponType) collider).remove();   // remove Laser / Weapon
            }
        }
    }

    public void bounceOff(WeaponType collider){
        switch (getHitGrid(collider)) {
            case 1:
                setNewColliderDirection(collider, 90, 270);
                break;
            case 2:
                setNewColliderDirection(collider, 90, 90);
                break;
            case 3:
                setNewColliderDirection(collider, 90, 90);
                break;
            case 4:
                setNewColliderDirection(collider, 90, 270);
                break;
            default:
                break;
        }
    }

    int getHitGrid(WeaponType collider){
        double obstWidth = this.getWidth();
        double obstHeight = this.getHeight();
        double obstacleX = getLocationInScene().getX();
        double obstacleY = getLocationInScene().getY();
        double laserX = collider.getAnchorLocation().getX();
        double laserY = collider.getAnchorLocation().getY();
        boolean isLeftSide = laserX < obstacleX + (obstWidth / 2);
        boolean isTopSide = laserY < obstacleY + (obstHeight / 2);

        if (isLeftSide && isTopSide) {
            return  1;
        } else if (!isLeftSide && isTopSide){
            return  2;
        } else if (!isLeftSide && !isTopSide){
            return  3;
        } else if (isLeftSide && !isTopSide){
            return  4;
        }
        return 0;
    }

    public void setNewColliderDirection(WeaponType collider, double rotate, double direction){
        (collider).setRotate(rotate);
        (collider).setDirection(direction);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

}

