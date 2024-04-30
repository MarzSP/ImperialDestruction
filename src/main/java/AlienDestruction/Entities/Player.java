package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Game.Booster;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Helper;
import AlienDestruction.Game.Highscore;
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

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {

    private App app;
    private GameScreen gameScreen;
    private IShootable shootable;
    private int lives;
    private int score;
    private boolean canShoot = true;
    private Booster booster;
    private boolean laserPowerUpActive = false; // Boolean voor PowerUpLaser
    private long laserPowerUpEndTime = 0; // int voor PowerUpLaser
    Highscore highscore = new Highscore(this);

    public Player(Coordinate2D location, GameScreen gameScreen, App app) {
        super("sprites/xWingV1.png", location, new Size(80,80));
        this.gameScreen = gameScreen;
        this.app = app;
        this.setLives(1);
        this.booster = new Booster();
        setGravityConstant(0.070);
        setFrictionConstant(0.00);
    }

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
        gameScreen.getScoreText().setText("Score: " + this.getScore());
    }
    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void setMotion( double speed, final double direction) {
        boolean boosterActive = booster.isActive();
        if (boosterActive) {
            speed *= 1.5;
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
            setMotion(Helper.Speed.TESTPLAYER3,Helper.Direction.GOLEFT);
        } else if(pressedKeys.contains(Helper.KeyStroke.RIGHT)){
            setMotion(Helper.Speed.TESTPLAYER3,Helper.Direction.GORIGHT);
        } else if(pressedKeys.contains(Helper.KeyStroke.BOOST) && canShoot){
            activateBooster();

            setMotion(Helper.Speed.TESTPLAYER5,Helper.Direction.GOUP);
            checkMaxHeight();
        } else if(pressedKeys.contains(Helper.KeyStroke.RIGHTBOOST)){
            setMotion(Helper.Speed.TESTPLAYER5,Helper.Direction.GORIGHTUP);
            checkMaxHeight();
        } else if(pressedKeys.contains(Helper.KeyStroke.LEFTBOOST)){
            setMotion(Helper.Speed.TESTPLAYER5,Helper.Direction.GOLEFTUP);
            checkMaxHeight();
        }
        if(!pressedKeys.contains(Helper.KeyStroke.FIRE)) {
            canShoot = true;
        }
    }

    private void activateBooster() {
        if (booster != null && !booster.isActive() && !booster.setCoolingDownActive(false)) {
            booster.setBoosterActive(true);
            booster.timer.resume();
            System.out.println("Booster Active");
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

    public void activateLaserPowerUp() {
        laserPowerUpActive = true;
        laserPowerUpEndTime = System.currentTimeMillis() + 10000; // 10 seconds
    }


    public void increaseScore(int points){
        this.score += points;
        highscore.updateCurrentScore();
        highscore.checkHighScore();
        updateScore();
    }
}
