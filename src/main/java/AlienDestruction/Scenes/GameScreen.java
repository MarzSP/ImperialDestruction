package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.MenuButton;
import AlienDestruction.Entities.EnemyOne;
import AlienDestruction.Entities.EnemyTwo;
import AlienDestruction.Entities.Player;
import AlienDestruction.Weapons.IShootable;
import AlienDestruction.Weapons.LaserGun;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;




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
          //  menuBar = new Menubar(getWidth(), 30, "black");
            //getRootPane().addChild(menubar);

        }


        @Override
        public void setupEntities() {
            player = new Player(new Coordinate2D(getWidth() / 2, 550));
            player.setWeapon((IShootable) weaponTypeSpawner);
            addEntity(player);

            MenuButton menuButton = new MenuButton(app, new Coordinate2D(800, 10));
            addEntity(menuButton);

//            var playerSprite = new Player(new Coordinate2D(getWidth() / 2, 550));
//            addEntity(playerSprite);

            var playerLives = new PlayerLives(new Coordinate2D(20,20));
            addEntity(playerLives);

            var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40), new App());
            addEntity(enemySpriteOne);

            var enemySpriteTwo = new EnemyTwo(new Coordinate2D(140, -40), new App());
            addEntity(enemySpriteTwo);

        }

        @Override
        public void setupEntitySpawners() {
            addEntitySpawner(weaponTypeSpawner);

            if (weaponTypeSpawner.isActive()) {
                weaponTypeSpawner.pause();
            }
        }
    }
