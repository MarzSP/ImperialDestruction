package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnemyFour extends GameEntities{

    private Player player;

    public EnemyFour(Coordinate2D location, Player player) {
        super("sprites/starDestroyerV1.png", location, new Size(160,290), player);
        this.player = player;

        setMotion(1, 0d);
        setPoints(200);
        setPenaltyPoints(100);
        setHitPoints(8);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        //gameScreen.getScoreText().setText("Score: " + player.getScore());
        player.setScore(player.getScore() - this.getPenaltyPoints());
        this.remove();
    }
}
