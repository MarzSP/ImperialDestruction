package AlienDestruction.Entities;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class EnemyThree extends GameEntities{
    public EnemyThree(Coordinate2D location, App app) {
        super("sprites/lambdaShuttleV1.png", location, new Size(120,80));
        setMotion(3, 45d);

        setPoints(100);
        setPenaltyPoints(50);
    }
}
