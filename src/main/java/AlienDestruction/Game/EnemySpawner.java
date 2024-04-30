package AlienDestruction.Game;

import AlienDestruction.Entities.*;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class EnemySpawner extends EntitySpawner {

    private Player player;

    private Level level;

    public int amountThisRound = 0;
    public EnemySpawner(Player player, Level level) {
        super(2000); // intervalInMs
        this.level = level;
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        int[] enemyTypes = level.getEnemyTypes();
        int totalAmount = enemyTypes.length;

        spawnEnemyFromLevel(enemyTypes[amountThisRound]);
        amountThisRound ++;
        if (amountThisRound >= totalAmount) {
            amountThisRound = 0;
            spawnEnemyFromLevel(4);
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
            default:
                break;
        }
    }
}

//var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40), player);
//addEntity(enemySpriteOne);
