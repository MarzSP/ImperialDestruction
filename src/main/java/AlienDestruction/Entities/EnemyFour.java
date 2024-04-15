package AlienDestruction.Entities;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class EnemyFour extends GameEntities{
    public EnemyFour(Coordinate2D location, App app) {
        super("sprites/starDestroyerV1.png", location, new Size(160,290));
        setMotion(3, 45d);

        setPoints(200);
        setPenaltyPoints(100);
    }
}
