package AlienDestruction.Entities;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class EnemyTwo extends GameEntities{
    public EnemyTwo(Coordinate2D location, App app) {
        super("sprites/tieIntercepterV1.png", location, new Size(80,80));

        setPoints(80);
        setPenaltyPoints(40);

        setMotion(3, 45d);

    }
}
