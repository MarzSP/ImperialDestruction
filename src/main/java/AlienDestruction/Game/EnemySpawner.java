package AlienDestruction.Game;

import AlienDestruction.Entities.*;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class EnemySpawner extends EntitySpawner {

    private Player player;
    public EnemySpawner(Player player) {
        super(1000); // intervalInMs

        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        GameEntities e;
        e = new EnemyOne(new Coordinate2D(40, -40), player);
        spawn(e);
    }
}

//var enemySpriteOne = new EnemyOne(new Coordinate2D(40, -40), player);
//addEntity(enemySpriteOne);
