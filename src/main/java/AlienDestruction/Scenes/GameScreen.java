package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Buttons.MusicButton;
import AlienDestruction.Buttons.PauseButton;
import AlienDestruction.Entities.*;
import AlienDestruction.Game.EnemySpawner;
import AlienDestruction.Game.Level;
import AlienDestruction.Game.PowerUpSpawner;
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
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De klasse GameScreen is een dynamisch scherm (extends DynamicScene) wat het speelveld maakt.
 * Deze erft van de DynamicScene klasse omdat die functionaliteit biedt voor het dynamisch toevoegen, verwijderen en wijzigen van elementen op het scherm.
 * Implements EntitySpawnerContainer: Implementeert de EntitySpawnerContainer interface die functionaliteit biedt voor het beheren van EntitySpawner objecten om Levels te kunnen maken.
 */
public class GameScreen extends DynamicScene implements EntitySpawnerContainer {

    /**
     * playerLivesText: Referentie naar de TextEntity die de levens tekst van de speler weergeeft.
     * scoreText: Referentie naar de TextEntity die de score tekst weergeeft.
     * levelText: Referentie naar de TextEntity die het level nummer weergeeft.
     * app: Referentie naar de App class waar het GameScreen wordt aangemaakt.
     * player: Instantie van de Player klasse die de speler vertegenwoordigt.
     * weaponTypeSpawner: Instantie van de EntitySpawner klasse die verantwoordelijk is voor het  initialiseren van wapens.
     * level: Instantie van de Level klasse die informatie over het level bevat.
     * textMenu: De Y-positie voor de menu-elementen.
     */
    private TextEntity playerLivesText;
    private TextEntity scoreText;
    private TextEntity levelText;

    private TextEntity pauseText;

    protected App app;
    private Player player;

    private boolean isPaused;
    private final EntitySpawner weaponTypeSpawner;

    private Level level = new Level();
    private double textMenu = 20;


    /**
     * GameScreen(App app): Initialiseert het speel scherm met een referentie naar de App class.
     * Initialiseert de levels en de weaponTypeSpawner.
     *
     * @param app
     */
    public GameScreen(App app) {
        this.app = app;
        this.level = level;
        this.weaponTypeSpawner = new LaserGun(10);
    }

    /**
     * getScoreText(): Retourneert de referentie naar de scoreText entity
     *
     * @return
     */
    public TextEntity getScoreText() {
        return scoreText;
    }

    /**
     * getPlayerLivesText(): Retourneert de referentie naar de playerLivesText entity.
     *
     * @return
     */
    public TextEntity getPlayerLivesText() {
        return playerLivesText;
    }

    /**
     * getLevelText(): Retourneert de referentie naar de levelText entity.
     *
     * @return
     */
    public TextEntity getLevelText() {
        return levelText;
    }

    /**
     * setupScene(): Zet de achtergrondafbeelding van het speel scherm.
     */
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe2.jpg");
        isPaused = false;
    }

    /**
     * setupEntities(): Initialiseert en voegt de volgende entiteiten toe aan het scherm:
     * <p>
     * Speler (met wapen van de weaponTypeSpawner).
     * Zwarte rechthoek bovenaan het scherm die fungeert als menubalk
     * Speler levens sprite (links boven in menubalk)
     * Speler levens tekst (tekst naar de PlayerLivesSprite)
     * Level tekst. (Level: 1)
     * Score tekst. (Score: 10)
     * Muziek knop. (Sprite, muziek aan of uit zetten)
     * Menu knop. (Menu Sprite die je naar een scherm brengt om het spel te verlaten)
     */
    @Override
    public void setupEntities() {
        player = new Player(new Coordinate2D(getWidth() / 2, 550), this, app);
        player.setWeapon((IShootable) weaponTypeSpawner);

        addEntity(player);

        addEntity(new BlackRectangle(
                new Coordinate2D(0, 0),
                new Size(getWidth(), 80)
        ));

        var playerLives = new PlayerLivesSprite(new Coordinate2D(textMenu, textMenu));

        addEntity(playerLives);

        // Add Player lives text:
        playerLivesText = new TextEntity(new Coordinate2D(60, textMenu), ": " + player.getLives());
        playerLivesText.setFill(Color.GOLD);
        playerLivesText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(playerLivesText);

        // Add Level Text:
        levelText = new TextEntity(new Coordinate2D(250, textMenu), "Level:" + level.getPlayerLevelNumber());
        levelText.setFill(Color.GOLD);
        levelText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(levelText);

        // Add Score Text
        scoreText = new TextEntity(new Coordinate2D(450, textMenu), "Score:" + player.getScore());
        scoreText.setFill(Color.GOLD);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, textMenu));
        addEntity(scoreText);


        SoundClip musicClip = new SoundClip("audio/swmaintheme.mp3", SoundClip.INDEFINITE);
        MusicButton musicButton = new MusicButton(new Coordinate2D(750, 10), musicClip, new Size(0.5 * textMenu, 0.5 * textMenu));
        addEntity(musicButton);

        Coordinate2D buttonLocation = new Coordinate2D(800, 15);
        PauseButton pauseButton = new PauseButton(buttonLocation, this);
        addEntity(pauseButton);

        MenuButton menuButton = new MenuButton(app, new Coordinate2D(980, textMenu));
        addEntity(menuButton);
    }

    /**
     * setupEntitySpawners(): Voegt de weaponTypeSpawner en EnemySpawner toe aan de scene en pauzeert eventueel de weaponTypeSpawner.
     */
    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(weaponTypeSpawner);
        addEntitySpawner(new EnemySpawner(player, level, this));
        addEntitySpawner(new PowerUpSpawner(level, this));

        if (weaponTypeSpawner.isActive()) {
            weaponTypeSpawner.pause();
        }
    }
}

/**
    public void pauseGame() {
        this.pause();
        if (isPaused) {
            pauseText = new TextEntity(new Coordinate2D(500, 400), "Click to continue!");
            pauseText.setFill(Color.GOLD);
            pauseText.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
            addEntity(pauseText);
            isPaused = true;
            System.out.println("LevelPause!");
        }}


        private void resumeGame() {
            this.resume();
            isPaused = false;
            System.out.println("LevelResume!");
        }

        public void onMouseButtonPressed (MouseButton button, Coordinate2D coordinate2D){
            if (isPaused) {
                resumeGame();
            } else {
                pauseGame();
            }
            isPaused = !isPaused;
        }

    }**/

