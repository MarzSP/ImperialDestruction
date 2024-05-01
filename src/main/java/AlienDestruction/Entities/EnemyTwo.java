package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Weapons.LaserBeam;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class EnemyTwo extends GameEntities{

    private Player player;

    public EnemyTwo(Coordinate2D location, Player player) {
        super("sprites/tieIntercepterV1.png", location, new Size(Helper.Size.MEDIUM,Helper.Size.MEDIUM), player);
        this.player = player;

        setMotion(Helper.Speed.MEDIUM, Helper.Direction.DOWN);
        setPoints(80);
        setPenaltyPoints(40);
        setHitPoints(2);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        //gameScreen.getScoreText().setText("Score: " + player.getScore());
        player.setScore(player.getScore() - this.getPenaltyPoints());
        this.remove();
    }

}
