package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.BoosterButton;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Entities.EnemyOne;
import AlienDestruction.Entities.EnemyTwo;
import AlienDestruction.MenuBar.BlackRectangle;
import AlienDestruction.MenuBar.PlayerLivesText;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import AlienDestruction.Entities.Player;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserGun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De klasse GameScreen is een dynamisch scherm (extends DynamicScene) wat het speelveld maakt.
 * GameScreen bevat een achtergrondafbeelding, speler, vijanden, menu balk met daarin: booster, levensmenu, en score.
 */
public class GameScreen extends DynamicScene implements EntitySpawnerContainer {

    protected App app;
    private Player player;
    private final EntitySpawner weaponTypeSpawner;
    public GameScreen(App app) {
        this.app = app;
        this.weaponTypeSpawner = new LaserGun(10);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe2.jpg");
    }

    @Override
    public void setupEntities() {
        player = new Player(new PlayerLivesText(new Coordinate2D(60, 20)),new Coordinate2D(getWidth() / 2, 550), app);
        player.setWeapon((IShootable) weaponTypeSpawner);

        var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40));
        addEntity(enemySpriteOne);

        var enemySpriteTwo = new EnemyTwo(new Coordinate2D(140, -40));
        addEntity(enemySpriteTwo);

        addEntity(player);

        addEntity(new BlackRectangle(
                new Coordinate2D(0, 0),
                new Size(1000, 80)
        ));

        var playerLivesText = new PlayerLivesText(new Coordinate2D(60, 20));
        //var player = new Player(playerLivesText, new Coordinate2D(getWidth() / 2, 550));

        var playerLives = new PlayerLivesSprite(new Coordinate2D(20,20));
        var boost = new BoosterButton("sprites/booster.png", new Coordinate2D(90,20));

        player.setBooster(boost);
        addEntity(boost);
        addEntity(playerLives);
        addEntity(playerLivesText);

        // Add Level Text
        var levelText = new TextEntity(new Coordinate2D(250, 20),  "Level:");
        levelText.setFill(Color.GOLD);
        levelText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        addEntity(levelText);

        // Add Score Text
        var scoreText = new TextEntity(new Coordinate2D(450, 20), "Score:");
        scoreText.setFill(Color.GOLD);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        addEntity(scoreText);

        MenuButton menuButton = new MenuButton(app, new Coordinate2D(940, 20));
        addEntity(menuButton);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(weaponTypeSpawner);

        if (weaponTypeSpawner.isActive()) {
            weaponTypeSpawner.pause();
        }
    }
}
