package AlienDestruction.Game;

import AlienDestruction.Entities.*;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {

    private Player player;

    private Level level;

    private GameScreen gameScreen;

    Random random = new Random();

    int enemyTypeIndex = 0;
    public EnemySpawner(Player player, Level level, GameScreen gameScreen) {
        super(1000); // intervalInMs
        this.level = level;
        this.player = player;
        this.gameScreen = gameScreen;

    }

    @Override
    protected void spawnEntities() {
        int indexLevelNumber = level.getIndexLevelNumber();
        int[][] levelData = level.defineLevel();
        int amountOfLevels = levelData.length;
        int amountInLevel = levelData[indexLevelNumber - 1].length;

        //int[] enemyTypes = level.getEnemyTypes();
        //int totalAmount = enemyTypes.length;

        spawnEnemyFromLevel(levelData[indexLevelNumber - 1][enemyTypeIndex]);
        enemyTypeIndex ++;
        if (enemyTypeIndex >= amountInLevel) {
            enemyTypeIndex = 0;
            level.setIndexLevelNumber(indexLevelNumber + 1);
            level.setPlayerLevelNumber(level.getPlayerLevelNumber() + 1);
        }
        if (indexLevelNumber >= amountOfLevels) {
            level.setIndexLevelNumber(1);
        }
    }

    public void spawnEnemyFromLevel(int enemyType){
        GameEntities e;
        int randomX = getRandomX();

        switch (enemyType) {
            case 1:
                e = new EnemyOne(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 2: e = new EnemyTwo(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 3: e = new EnemyThree(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 4: e = new EnemyFour(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 5: e = new ObstacleOne(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 6: e = new ObstacleTwo(new Coordinate2D(randomX, -40), player);
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

    int getRandomX(){
        double w = gameScreen.getWidth();  // Width GameScreen
        int minX = 40;
        int maxX = (int) w - 40;

        return Helper.getRandomInt(minX, maxX);
    }


}

