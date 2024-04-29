package AlienDestruction.Entities;

import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Weapons.LaserBeam;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class GameEntities extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Newtonian, Collided, Collider, Rotatable, SceneBorderCrossingWatcher {
    private int points;
    private int penaltyPoints;

    private int hitPoints;
    private Player player;
    private GameScreen gameScreen;


    protected GameEntities(String resource, Coordinate2D initialLocation, Size size, Player player) {
        super(resource, initialLocation);
        this.player = player;
        this.gameScreen = gameScreen;
        setGravityConstant(0.000);
        setFrictionConstant(0.00);
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getPenaltyPoints() {
        return penaltyPoints;
    }
    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject){
            if (collider instanceof WeaponType){
                addDamage(((WeaponType) collider).getDamagePoints());
                checkIfDestroyed();
                ((WeaponType) collider).remove(); // remove Laser / Weapon
            }
        }
    }

    public void addDamage(double damage){
        this.hitPoints -= damage;
    }

    public void checkIfDestroyed(){
        if (this.hitPoints <= 0) {
            player.increaseScore(points);
            this.remove();                      // remove Enemy / entity
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}
