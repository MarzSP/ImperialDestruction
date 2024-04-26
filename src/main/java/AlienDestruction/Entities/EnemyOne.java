package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Scenes.GameScreen;
import AlienDestruction.Weapons.LaserBeam;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class EnemyOne extends GameEntities {


    public EnemyOne(Coordinate2D location) {

        super("sprites/tieFighterV1.png", location, new Size(80,80));
        setMotion(Helper.Speed.MEDIUM, Helper.Direction.DOWN);
        setPoints(50);
        setPenaltyPoints(25);

    }

}
