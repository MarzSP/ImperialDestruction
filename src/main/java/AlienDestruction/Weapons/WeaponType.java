package AlienDestruction.Weapons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

public abstract class WeaponType extends DynamicSpriteEntity implements Collider, Collided {

    private double damagePoints;
    protected WeaponType(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size );
    }

    public double getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(double damagePoints) {
        this.damagePoints = damagePoints;
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
    }
}
