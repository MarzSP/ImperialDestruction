package AlienDestruction.Game;

public class Level {

    private int levelNumber = 1;
    private int levelSize = 10;

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


    public int[][] defineLevel() {
        return new int[][] {
                {1, 5, 1, 2, 2, 6},
                {1, 2, 2, 6, 3, 3},
                {4, 2, 2, 2}
        };

//            return new int[][] {
//            {1, 1, 5},
//            {2, 2},
//            {3, 3, 6},
//            {4}
//    };

    }
}

// Test Levels
//public int[][] defineLevel() {
//    return new int[][] {
//            {1, 1},
//            {2, 2},
//            {3, 3},
//            {4}
//    };
//}