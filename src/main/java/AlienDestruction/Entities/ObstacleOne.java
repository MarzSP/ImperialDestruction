package AlienDestruction.Entities;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class ObstacleOne extends GameEntities{
    public ObstacleOne(Coordinate2D location, App app) {
        super("sprites/asteroidSquareV1/.png", location, new Size(100,10));
        setMotion(3, 360d);
    }
}
