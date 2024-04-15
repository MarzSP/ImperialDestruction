package AlienDestruction.Entities;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class ObstacleTwo extends GameEntities{
    public ObstacleTwo(Coordinate2D location, App app) {
        super("sprites/asteroidRectangleV1/.png", location, new Size(100,10));
        setMotion(3, 360d);
    }
}
