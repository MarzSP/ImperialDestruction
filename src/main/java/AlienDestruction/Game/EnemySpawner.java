package AlienDestruction.Game;

import AlienDestruction.Entities.*;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Entities.PowerUps.PowerUpShip;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class EnemySpawner extends EntitySpawner {

    private Player player;

    private Level level;

    int enemyTypeIndex = 0;
    public EnemySpawner(Player player, Level level) {
        super(1000); // intervalInMs
        this.level = level;
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        int levelNumber = level.getLevelNumber();
        int[][] levelData = level.defineLevel();
        int amountInLevel = levelData[levelNumber - 1].length;

        //int[] enemyTypes = level.getEnemyTypes();
        //int totalAmount = enemyTypes.length;

        spawnEnemyFromLevel(levelData[levelNumber - 1][enemyTypeIndex]);
        enemyTypeIndex ++;
        if (enemyTypeIndex >= amountInLevel) {
            enemyTypeIndex = 0;
            level.setLevelNumber(levelNumber + 1);
        }

    }

    public void spawnEnemyFromLevel(int enemyType){
        GameEntities e;

        switch (enemyType) {
            case 1:
                e = new EnemyOne(new Coordinate2D(40, -40), player);
                spawn(e);
                break;
            case 2: e = new EnemyTwo(new Coordinate2D(120, -40), player);
                spawn(e);
                break;
            case 3: e = new EnemyThree(new Coordinate2D(300, -40), player);
                spawn(e);
                break;
            case 4: e = new EnemyFour(new Coordinate2D(600, -40), player);
                spawn(e);
                break;
            case 5: e = new ObstacleOne(new Coordinate2D(400, -40), player);
                spawn(e);
                break;
            case 6: e = new ObstacleTwo(new Coordinate2D(300, -40), player);
                spawn(e);
                break;
//            case 7: e = new PowerUpLives(new Coordinate2D(750, -40));
//                spawn(e);
//                break;
//            case 8: e = new PowerUpLaser(new Coordinate2D(750, -40));
//                spawn(e);
//                break;
            default:
                break;
        }
    }
}

