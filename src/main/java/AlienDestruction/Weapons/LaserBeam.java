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
     * Constructor: LaserBeam
     *
     * @param isUp            decides the sprite
     * @param initialLocation :  De beginpositie van de laserstraal op het scherm (als Coordinate2D object).
     *                        Initialiseert de laserstraal met de volgende eigenschappen:
     *                        Sprite afbeelding: "sprites/laserred.png" (rode laser)
     *                        Grootte: Size(5,16)
     *                        Schade: 1 (via de setDamagePoints methode geërfd van WeaponType)
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


