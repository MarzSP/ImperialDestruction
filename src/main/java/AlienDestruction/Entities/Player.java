package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Buttons.BoosterButton;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Entities.PowerUps.PowerUpShip;
import AlienDestruction.Helper;
import AlienDestruction.PowerUps.PowerUps;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserBeam;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;
import java.util.Timer;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
// public class Player extends GameEntities implements Collided {
    private App app;
    private GameScreen gameScreen;
    private IShootable shootable;
    private int lives;
    private int score;
    private boolean canShoot = true;
    private BoosterButton booster;

    private boolean laserPowerUpActive = false; // Boolean voor PowerUpLaser
    private long laserPowerUpEndTime = 0; // int voor PowerUpLaser


    public GameScreen getGameScreen() {
        return gameScreen;
    }
    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;

    }

    public Player(Coordinate2D location, GameScreen gameScreen, App app) {
        super("sprites/xWingV1.png", location, new Size(80,80));
        this.gameScreen = gameScreen;
        this.app = app;
        this.setLives(1);
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
        if(pressedKeys.contains(KeyCode.SPACE) && canShoot) {
            if (laserPowerUpActive && System.currentTimeMillis() < laserPowerUpEndTime) {
                shoot();
            } else {

                shoot();
                canShoot = false;
            }
        }
        if(pressedKeys.contains(Helper.KeyStroke.LEFT)){
            setMotion(Helper.Speed.MEDIUM,Helper.Direction.GOLEFT);
        } else if(pressedKeys.contains(Helper.KeyStroke.RIGHT)){
            setMotion(Helper.Speed.MEDIUM,Helper.Direction.GORIGHT);
        } else if(pressedKeys.contains(Helper.KeyStroke.BOOST)){
            setMotion(Helper.Speed.HIGH,Helper.Direction.GOUP);
            checkMaxHeight();
        } else if(pressedKeys.contains(Helper.KeyStroke.RIGHTBOOST)){
            setMotion(Helper.Speed.HIGH,Helper.Direction.GORIGHTUP);
            checkMaxHeight();
        } else if(pressedKeys.contains(Helper.KeyStroke.LEFTBOOST)){
            setMotion(Helper.Speed.HIGH,Helper.Direction.GOLEFTUP);
            checkMaxHeight();
        }
        if(!pressedKeys.contains(Helper.KeyStroke.FIRE)) {
            canShoot = true;
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
        boolean powerUpCollision = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof PowerUpLives) { //PowerUpLives
                powerUpCollision = true;
                lives = lives + 1;
                updateLives();
                checkLives();
                ((PowerUpLives) collider).remove(); //verwijderd de sprite van het scherm
                break;
            }
            else if (collider instanceof PowerUpLaser) { //PowerUpLaserschot x2
                powerUpCollision = true;
                activateLaserPowerUp();
                ((PowerUpLaser) collider).remove(); // verwijderd sprite uit het scherm
                break;
            }

        } if(!powerUpCollision) {
            setAnchorLocation(new Coordinate2D((getSceneWidth() - getWidth()) / 2, 550));
            lives = lives - 1;
            updateLives();
            checkLives();

        } updateLives();
        checkLives();
    }

    private void updateLives() {
        TextEntity playerLivesText;
        gameScreen.getPlayerLivesText().setText(": " + this.getLives());
    }

    // When [W] Booster check for maximum boost
    public void checkMaxHeight() {
        if(getLocationInScene().getY() < 500) {
            setAnchorLocationY(500);
        }
    }

    public void checkLives(){
        System.out.println(lives);
        if(lives < 0) {
            app.setActiveScene(Helper.SceneIds.EndScreen);
        }
    }

    public void shoot(){
        double x = getLocationInScene().getX();
        double y = getLocationInScene().getY();
        shootable.shoot(new LaserBeam(new Coordinate2D(x + 5, y))); // todo: dynamisch aanpassen aan size sprite / pos lasers on sprite
        shootable.shoot(new LaserBeam(new Coordinate2D(x + 70, y)));//
        soundLaser();                              // Fire Laser
        score++;
        updateScore();
    }

    private void updateScore() {
        TextEntity scoreText;
        gameScreen.getScoreText().setText("Score: " + getScore());
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

    public void activateLaserPowerUp() {
        laserPowerUpActive = true;
        laserPowerUpEndTime = System.currentTimeMillis() + 10000; // 10 seconds
    }
}
