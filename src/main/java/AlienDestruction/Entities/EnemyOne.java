package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Scenes.GameScreen;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class EnemyOne extends GameEntities {

    public EnemyOne(Coordinate2D location) {

        super("sprites/tieFighterV1.png", location, new Size(80,80));
        setMotion(3, 360d);
        setPoints(50);
        setPenaltyPoints(25);
    }
}
