package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnemyThree extends GameEntities{
    private Player player;

    public EnemyThree(Coordinate2D location, Player player) {
        super("sprites/lambdaShuttleV1.png", location, new Size(120,80), player);
        this.player = player;

        setMotion(3, 45d);

        setPoints(100);
        setPenaltyPoints(50);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        //gameScreen.getScoreText().setText("Score: " + player.getScore());
        player.setScore(player.getScore() - this.getPenaltyPoints());
        this.remove();
    }
}
