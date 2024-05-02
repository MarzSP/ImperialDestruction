package AlienDestruction.Game;

import AlienDestruction.Entities.*;
import AlienDestruction.Entities.PowerUps.PowerUpLaser;
import AlienDestruction.Entities.PowerUps.PowerUpLives;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import java.util.List;
import java.util.Random;

public class EnemySpawner extends EntitySpawner {

    private Player player;

    private Level level;

    private GameScreen gameScreen;
    Random random = new Random();
    private int enemyTypeIndex = 0;


    public EnemySpawner(Player player, Level level, GameScreen gameScreen) {
        super(1200);
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

        spawnEnemyFromLevel(levelData[indexLevelNumber - 1][enemyTypeIndex]);
        enemyTypeIndex ++;
        if (enemyTypeIndex >= amountInLevel) {
            enemyTypeIndex = 0;
            level.setIndexLevelNumber(indexLevelNumber + 1);
            level.setPlayerLevelNumber(level.getPlayerLevelNumber() + 1);
            updateLevelText();
        }
        if (indexLevelNumber >= amountOfLevels) {
            level.setIndexLevelNumber(1);
        }
    }

    public void spawnEnemyFromLevel(int enemyType){
        GameEntities e;
        int randomX = Helper.getRandomX(gameScreen.getWidth());

        switch (enemyType) {
            case 1:
                e = new EnemyOne(new Coordinate2D(randomX, -40), player, getSpeedIncrease());
                spawn(e);
                break;
            case 2: e = new EnemyTwo(new Coordinate2D(randomX, -40), player, getSpeedIncrease());
                spawn(e);
                break;
            case 3: e = new EnemyThree(new Coordinate2D(randomX, -40), player, getSpeedIncrease());
                spawn(e);
                break;
            case 4: e = new EnemyFour(new Coordinate2D(randomX, -40), player, getSpeedIncrease());
                spawn(e);
                break;
            case 5: e = new ObstacleOne(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            case 6: e = new ObstacleTwo(new Coordinate2D(randomX, -40), player);
                spawn(e);
                break;
            default:
                break;
        }
    }

    public void updateLevelText(){
        TextEntity levelText;
        gameScreen.getLevelText().setText("Level: " + level.getPlayerLevelNumber());
    }

    public double getSpeedIncrease() {
        double increase = level.getPlayerLevelNumber() * 0.1;
        return increase;
    }

//    public void changeLevel(){
//        gameScreen.pause();
//
//        gameScreen.resume();
//    }


}

