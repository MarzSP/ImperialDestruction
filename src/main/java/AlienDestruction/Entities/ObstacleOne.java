package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Weapons.LaserBeam;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.ContinuousRotatable;

import java.util.List;

public class ObstacleOne extends GameEntities {

    private Player player;
    public ObstacleOne(Coordinate2D location, Player player) {
        super("sprites/asteroidSquareV1.png", location, new Size(100,100), player);
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
        System.out.println(collider.getAnchorLocation());
        System.out.println(getHitGrid(collider));
        switch (getHitGrid(collider)) {
            case 1:
                setNewColliderDirection(collider, 90, 270);
            case 2:
                setNewColliderDirection(collider, 90, 90);
            case 3:
                setNewColliderDirection(collider, 90, 90);
            case 4:
                setNewColliderDirection(collider, 90, 270);
        }
    }

    int getHitGrid(WeaponType collider){
        double obstWidth = this.getWidth();
        double obstHeight = this.getHeight();
        double colX = collider.getAnchorLocation().getX();
        double colY = collider.getAnchorLocation().getY();
        if (colX < colX + (obstWidth / 2) && colY < colY + (obstHeight / 2)) {
            return  1;
        } else if (colX > colX + (obstWidth / 2) && colY < colY + (obstHeight / 2)){
            return  2;
        } else if (colX < colX + (obstWidth / 2) && colY > colY + (obstHeight / 2)){
            return  3;
        } else if (colX > colX + (obstWidth / 2) && colY > colY + (obstHeight / 2)){
            return  4;
        }
        return 0;
    }

    public void setNewColliderDirection(WeaponType collider, double rotate, double direction){
        ((WeaponType) collider).setRotate(rotate);
        ((WeaponType) collider).setDirection(direction);
    }

}


//public void checkMaxHeight() {
//    if(getLocationInScene().getY() < 500) {
//        setAnchorLocationY(500);
//    }
//}
