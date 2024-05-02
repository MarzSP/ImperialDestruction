package AlienDestruction.Game;

import AlienDestruction.Entities.EnemyOne;
import AlienDestruction.Entities.EnemyTwo;
import AlienDestruction.Entities.GameEntities;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Entities.PowerUps.PowerUps;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class PowerUpSpawner extends EntitySpawner {

    private Level level;

    private GameScreen gameScreen;
    public PowerUpSpawner(Level level, GameScreen gameScreen) {
        super(Helper.getRandomInt(5000, 15000));
        this.level = level;
        this.gameScreen = gameScreen;
    }

    @Override
    protected void spawnEntities() {
        spawnPowerUp();
    }

    public void spawnPowerUp(){
        PowerUps e;
        int randomX = Helper.getRandomX(gameScreen.getWidth());
        int randomP = Helper.getRandomInt(1,3);

        switch (randomP) {
            case 1:
                e = new PowerUpLives(new Coordinate2D(randomX, -40));
                spawn(e);
                break;
            case 2:
                e = new PowerUpLaser(new Coordinate2D(randomX, -40));
                spawn(e);
                break;
            default:
                break;
        }
    }


}
