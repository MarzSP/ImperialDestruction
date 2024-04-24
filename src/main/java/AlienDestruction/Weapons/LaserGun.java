package AlienDestruction.Weapons;

import com.github.hanyaeger.api.entities.EntitySpawner;

public class LaserGun extends EntitySpawner implements IShootable{

    public LaserGun(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void shoot(WeaponType weaponType) {
        weaponType.setSpeed(20);
        weaponType.setDirection(180);
        this.spawn(weaponType);
    }

    @Override
    protected void spawnEntities() {

    }
}
