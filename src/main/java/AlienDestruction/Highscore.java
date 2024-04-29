package AlienDestruction;

import AlienDestruction.Entities.Player;

/**De klasse Highscore houdt bij  wie de speler is (Player) en de hoogste score die de speler heeft behaald (highscore).
 * Daarnaast kan de klasse de huidige score van de speler (currentScore) bijhouden.
 *
 */
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

