package AlienDestruction.Game;

public class Level {

    private int levelNumber = 1;
    private int levelSize = 10;
    private int[] enemyTypes = { 1, 1, 2, 2, 3, 3};

    public int[] getEnemyTypes() {
        return enemyTypes;
    }

    public void setEnemyTypes(int[] enemyTypes) {
        this.enemyTypes = enemyTypes;
    }

    public Level (){
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getLevelSize() {
        return levelSize;
    }

    public void setLevelSize(int levelSize) {
        this.levelSize = levelSize;
    }
}
