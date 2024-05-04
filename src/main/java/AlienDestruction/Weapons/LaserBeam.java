package AlienDestruction.Weapons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

/**
 * Het doel van LaserBeam class:een concrete subklasse van de abstracte WeaponType klasse en maakt een LaserBeam wapen.
 * Extends: LaserBeam erft functionaliteit van de WeaponType klasse die de basis definieert voor verschillende soorten wapens.
 */
public class LaserBeam extends WeaponType {


    /**
     isUp: Bepaalt of de laserstraal omhoog of omlaag gericht is.

     true: De laserstraal is omhoog gericht.
     false: De laserstraal is omlaag gericht.

     initialLocation: De beginpositie van de laserstraal op het scherm (als Coordinate2D-object).
     owner: De entiteit die eigenaar is van de laserstraal (bijv. de speler of een vijand).
     */
    //isUp ? expression is true/false
    public LaserBeam(boolean isUp, Coordinate2D initialLocation, DynamicSpriteEntity owner) {
        super(
                isUp ? "sprites/laserup.png" : "sprites/laserdown.png",
                initialLocation,
                new Size(8,24),
                owner
        );
        if (isUp) {
            setDirection(180);
        }
        setDamagePoints(1);
    }

    /**
     * Deze methode wordt opgeroepen wanneer de laserstraal botst met andere objecten in de game (vanwege de geërfde Collider interface).
     * @param collidingObject een lijst van welke objecten een botsing kunnen maken
     */
    @Override
    public void onCollision(List<Collider> collidingObject) {
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        this.remove();
    }

}


