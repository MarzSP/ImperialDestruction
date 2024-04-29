package AlienDestruction;

import AlienDestruction.Entities.Player;

public class Highscore {
    private Player player;
    private int highscore = 0;
    private int currentScore;

    public Highscore(Player player){
        this.player = player;
    }
    public void updateCurrentScore(){
       currentScore = player.getScore();
        }
    public void checkHighScore(){
        updateCurrentScore();
        if (currentScore > highscore) {
            highscore = currentScore;
            System.out.println("New Highscore!");
        }
    }

    }

