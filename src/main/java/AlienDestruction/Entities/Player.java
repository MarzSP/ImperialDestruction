package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Buttons.BoosterButton;
import AlienDestruction.Entities.MenuBar.PlayerLivesText;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserBeam;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
// public class Player extends GameEntities implements Collided {
    private App app;
    private IShootable shootable;
    private int lives;
    private int score;

    private BoosterButton booster;
    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }
    public void setLives(int lives) {
        this.lives = lives;
        this.playerLivesText.setText(Integer.toString(lives));
    }
    protected final PlayerLivesText playerLivesText;
    public Player(PlayerLivesText playerLivesText, Coordinate2D location) {
        super("sprites/xWingV1.png", location, new Size(80,80));

        this.playerLivesText = playerLivesText;
        this.setLives(3);
        setGravityConstant(0.070);
        setFrictionConstant(0.00);
    }

    @Override
    public void setMotion( double speed, final double direction) {
        boolean boosterActive = booster.isActive();
        if (boosterActive) {
            speed *= 2;
        }
        super.setMotion(speed, direction);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.A)){
            setMotion(5,280d);          // Left + Slightly down (Simulate speed reduction)
        } else if(pressedKeys.contains(KeyCode.D)){
            setMotion(5,80d);           // Right + slightly down (simulate speed reduction)
        } else if(pressedKeys.contains(KeyCode.W)){
            setMotion(3,180d);          // Up
            checkMaxHeight();
        } else if(pressedKeys.contains(KeyCode.E)){
            setMotion(3,125d);          // Up + right
            checkMaxHeight();
        } else if(pressedKeys.contains(KeyCode.Q)){
            setMotion(3,235d);          // Up + left
            checkMaxHeight();
        } else if(pressedKeys.contains(KeyCode.SPACE)) {
            double x = getLocationInScene().getX();
            double y = getLocationInScene().getY();
            shootable.shoot(new LaserBeam(new Coordinate2D(x + 5, y))); // todo: dynamisch aanpassen aan size sprite / pos lasers on sprite
            shootable.shoot(new LaserBeam(new Coordinate2D(x + 70, y)));
            soundLaser();                              // Fire Laser
        } else if(pressedKeys.isEmpty()){
            setSpeed(1);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
    @Override
    public void onCollision(List<Collider> collidingObject) {
        setAnchorLocation(new Coordinate2D((getSceneWidth() - getWidth()) / 2, 550));
        lives = lives - 1;
        checkLives();
        System.out.println(lives);
    }

    // When [W] Booster check for maximum boost
    public void checkMaxHeight() {
        if(getLocationInScene().getY() < 500) {
            setAnchorLocationY(500);
        }
    }

    public void checkLives(){
        if(lives < 0) {
            app.setActiveScene(App.SceneIds.EndScreen);
        }
    }

    public void soundLaser() {
        var xWingLaser = new SoundClip("audio/xwinglaser.mp3");
        xWingLaser.play();
    }

    public void setWeapon(IShootable weapon) {
        this.shootable = weapon;
    }
    public BoosterButton getBooster() {
        return booster;
    }

    public void setBooster(BoosterButton booster) {
        this.booster = booster;
    }
}
