package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Buttons.BoosterButton;
import AlienDestruction.Entities.MenuBar.PlayerLivesText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

//public class Player extends DynamicSpriteEntity implements  KeyListener, SceneBorderTouchingWatcher, Newtonian {
public class Player extends GameEntities implements Collided {
    private App app;

    public int lives;
    private BoosterButton booster;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        this.playerLivesText.setText(Integer.toString(lives));
    }


    protected final PlayerLivesText playerLivesText;
    public Player(PlayerLivesText playerLivesText, Coordinate2D location) {
        super("sprites/xWingV1.png", location, new Size(55,100));

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
        //var laserRedSprite = new Laser(new Coordinate2D(getLocationInScene().getX(), getLocationInScene().getY()), new App());

        xWingLaser.play();
    }


    public BoosterButton getBooster() {
        return booster;
    }

    public void setBooster(BoosterButton booster) {
        this.booster = booster;
    }
}
