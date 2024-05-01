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

    public int[][] defineLevel() {
        return new int[][] {
                {1, 1, 1, 5, 1, 2, 2, 2, 2, 5, 6, 2, 2},
                {3, 3, 3, 2, 2, 2, 5, 6, 5},
                {4, 2, 2, 2, 2, 4, 6, 5, 6},
                {5, 5, 6, 5, 6, 6, 5, 5, 5},
                {4, 4, 4}
        };
    }

//    public int[][] defineLevel() {
//    return new int[][] {
//            {1, 1},
//            {2, 2},
//            {3, 3},
//            {4}
//    };
}


