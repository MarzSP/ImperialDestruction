package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.MenuBar.PlayerLivesSprite;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class EnemyFour extends GameEntities{

    private Player player;
    public EnemyFour(Coordinate2D location, Player player) {
        super("sprites/starDestroyerV1.png", location, new Size(160,290), player);
        this.player = player;
        setMotion(3, 45d);

        setPoints(200);
        setPenaltyPoints(100);
    }
}
