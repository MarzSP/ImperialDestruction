package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Buttons.MusicButton;
import AlienDestruction.Entities.*;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Entities.PowerUps.PowerUpShip;
import AlienDestruction.Game.EnemySpawner;
import AlienDestruction.Game.Level;
import AlienDestruction.MenuBar.BlackRectangle;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserGun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De klasse GameScreen is een dynamisch scherm (extends DynamicScene) wat het speelveld maakt.
 * GameScreen bevat een achtergrondafbeelding, speler, vijanden, menu balk met daarin: booster, levensmenu, en score.
 */
public class GameScreen extends DynamicScene implements EntitySpawnerContainer {

    private TextEntity playerLivesText;
    private TextEntity scoreText;

    protected App app;
    private Player player;
    private final EntitySpawner weaponTypeSpawner;

    private Level level = new Level();


    public GameScreen(App app) {
        this.app = app;
        this.level = level;
        this.weaponTypeSpawner = new LaserGun(10);
    }


    public TextEntity getScoreText() {return scoreText;}
    public TextEntity getPlayerLivesText() {
        return playerLivesText;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe2.jpg");


    }

    @Override
    public void setupEntities() {
        player = new Player(new Coordinate2D(getWidth() / 2, 550), this, app);
        player.setWeapon((IShootable) weaponTypeSpawner);

//        var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40), player);
//        addEntity(enemySpriteOne);

//        var enemySpriteTwo = new EnemyTwo(new Coordinate2D(240, -40), player);
//        addEntity(enemySpriteTwo);
//
//        var obstacleSpriteOne = new ObstacleOne(new Coordinate2D(800, -40), player);
//        addEntity(obstacleSpriteOne);
//
//        var powerUpLives = new PowerUpLives(new Coordinate2D(180, -40));
//        addEntity(powerUpLives);
//
//        var powerUpLaser = new PowerUpLaser(new Coordinate2D(360, -40));
//        addEntity(powerUpLaser);
//
//        var powerUpShip = new PowerUpShip(new Coordinate2D(300, -40));
//        addEntity(powerUpShip);

        addEntity(player);

        addEntity(new BlackRectangle(
                new Coordinate2D(0, 0),
                new Size(1000, 80)
        ));

        var playerLives = new PlayerLivesSprite(new Coordinate2D(20,20));

        addEntity(playerLives);

        // Add Player lives text:
        playerLivesText = new TextEntity(new Coordinate2D(60, 20), ": " + player.getLives());
        playerLivesText.setFill(Color.GOLD);
        playerLivesText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        addEntity(playerLivesText);

        // Add Level Text:
        var levelText = new TextEntity(new Coordinate2D(250, 20),  "Level:");
        levelText.setFill(Color.GOLD);
        levelText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        addEntity(levelText);

        // Add Score Text
        scoreText = new TextEntity(new Coordinate2D(450, 20), "Score:" + player.getScore());
        scoreText.setFill(Color.GOLD);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        addEntity(scoreText);

        SoundClip musicClip = new SoundClip("audio/swmaintheme.mp3", SoundClip.INDEFINITE);
        MusicButton musicButton = new MusicButton(new Coordinate2D(750, 10), musicClip, new Size(10,10) );
        addEntity(musicButton);

        MenuButton menuButton = new MenuButton(app, new Coordinate2D(940, 20));
        addEntity(menuButton);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(weaponTypeSpawner);
        addEntitySpawner(new EnemySpawner(player, level));

        if (weaponTypeSpawner.isActive()) {
            weaponTypeSpawner.pause();
        }
    }
    }

