package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnemyFour extends GameEntities{

    private Player player;

    public EnemyFour(Coordinate2D location, Player player) {
        super("sprites/starDestroyerV1.png", location, new Size(Helper.Size.HUGE,Helper.Size.HUGE * 2), player);
        this.player = player;

        setMotion(Helper.Speed.LOW, Helper.Direction.DOWN);
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
