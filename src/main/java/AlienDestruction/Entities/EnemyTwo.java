package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class EnemyTwo extends GameEntities{
    public EnemyTwo(Coordinate2D location) {
        super("sprites/tieIntercepterV1.png", location, new Size(80,80));
        setMotion(Helper.Speed.MEDIUM, Helper.Direction.GORIGHTDOWN);
        setPoints(80);
        setPenaltyPoints(40);



    }
}
