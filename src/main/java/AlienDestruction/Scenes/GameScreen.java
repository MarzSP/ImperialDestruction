package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.BoosterButton;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Entities.EnemyOne;
import AlienDestruction.Entities.EnemyTwo;
import AlienDestruction.Entities.MenuBar.BlackRectangle;
import AlienDestruction.Entities.MenuBar.PlayerLivesText;
import AlienDestruction.Entities.MenuBar.PlayerLivesSprite;
import AlienDestruction.Entities.Player;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserGun;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;


public class GameScreen extends DynamicScene {
    protected App app;
    public GameScreen(App app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/universe2.jpg");
    }

    public class GameScreen extends DynamicScene implements EntitySpawnerContainer {

        private App app;
        private Player player;
        private final EntitySpawner weaponTypeSpawner;

        public GameScreen (App app) {
            this.app = app;
            this.weaponTypeSpawner = new LaserGun(10);
        }

        @Override
        public void setupScene() {
            setBackgroundImage("backgrounds/universe2.jpg");
        


    @Override
    public void setupEntities() {
        var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40));

        addEntity(enemySpriteOne);


        @Override
        public void setupEntities() {
            player = new Player(new Coordinate2D(getWidth() / 2, 550));
            player.setWeapon((IShootable) weaponTypeSpawner);
            addEntity(player);

            MenuButton menuButton = new MenuButton(app, new Coordinate2D(800, 10));
            addEntity(menuButton);

//            var playerSprite = new Player(new Coordinate2D(getWidth() / 2, 550));
//            addEntity(playerSprite);

        var enemySpriteTwo = new EnemyTwo(new Coordinate2D(140, -40));
        addEntity(enemySpriteTwo);

        var playerLivesText = new PlayerLivesText(new Coordinate2D(60, 20));
        var player = new Player(playerLivesText, new Coordinate2D(getWidth() / 2, 550));


        addEntity(player);
 @Override
        public void setupEntitySpawners() {
            addEntitySpawner(weaponTypeSpawner);

            if (weaponTypeSpawner.isActive()) {
                weaponTypeSpawner.pause();
            }
        }
        addEntity(new BlackRectangle(
                new Coordinate2D(0, 0),
                new Size(1000, 80)
        ));

        var playerLives = new PlayerLivesSprite(new Coordinate2D(20,20));
        var boost = new BoosterButton("sprites/booster.png", new Coordinate2D(90,20));
        player.setBooster(boost);
        addEntity(boost);
        addEntity(playerLives);
        addEntity(playerLivesText);

        }


        MenuButton menuButton = new MenuButton(app, new Coordinate2D(930, 20));
        addEntity(menuButton);

    }
}
