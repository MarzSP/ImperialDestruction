package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Buttons.MusicButton;
import AlienDestruction.Entities.*;
import AlienDestruction.Game.EnemySpawner;
import AlienDestruction.Game.Level;
import AlienDestruction.MenuBar.BlackRectangle;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserGun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
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
    private double textMenu = 20;

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

        addEntity(player);

        addEntity(new BlackRectangle(
                new Coordinate2D(0, 0),
                new Size(getWidth(), 80)
        ));

        var playerLives = new PlayerLivesSprite(new Coordinate2D(textMenu,textMenu));

        addEntity(playerLives);

        // Add Player lives text:
        playerLivesText = new TextEntity(new Coordinate2D(60, textMenu), ": " + player.getLives());
        playerLivesText.setFill(Color.GOLD);
        playerLivesText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(playerLivesText);

        // Add Level Text:
        var levelText = new TextEntity(new Coordinate2D(250, textMenu),  "Level:" + level.getPlayerLevelNumber());
        levelText.setFill(Color.GOLD);
        levelText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(levelText);

        // Add Score Text
        scoreText = new TextEntity(new Coordinate2D(450, textMenu), "Score:" + player.getScore());
        scoreText.setFill(Color.GOLD);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(scoreText);

        SoundClip musicClip = new SoundClip("audio/swmaintheme.mp3", SoundClip.INDEFINITE);
        MusicButton musicButton = new MusicButton(new Coordinate2D(750, 0.5 * textMenu), musicClip, new Size(0.5*textMenu,0.5*textMenu) );
        addEntity(musicButton);

        MenuButton menuButton = new MenuButton(app, new Coordinate2D(940, textMenu));
        addEntity(menuButton);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(weaponTypeSpawner);
        addEntitySpawner(new EnemySpawner(player, level, this));

        if (weaponTypeSpawner.isActive()) {
            weaponTypeSpawner.pause();
        }
    }
    }

