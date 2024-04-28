package AlienDestruction.Entities;

import AlienDestruction.App;
import AlienDestruction.Helper;
import AlienDestruction.Weapons.LaserBeam;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class EnemyTwo extends GameEntities{

    private Player player;
    public EnemyTwo(Coordinate2D location, Player player) {
        super("sprites/tieIntercepterV1.png", location, new Size(80,80), player);
        this.player = player;
        setMotion(Helper.Speed.MEDIUM, Helper.Direction.GORIGHTDOWN);
        setPoints(80);
        setPenaltyPoints(40);

    }

}
