package AlienDestruction.Weapons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

/**
 * Deze abstracte class WeaponType is de basis voor verschillende soorten wapens in de game.
 * Extends:
 * DynamicSpriteEntity: klasse die sprites met posities en afmetingen in de gamewereld beheert.
 * Collide interface: aangeeft dat wapens kunnen botsen met andere objecten in de game.
 * Collided interface: Om te reageren wanneer een wapen met een ander object of entiteit botst.
 */
public abstract class WeaponType extends DynamicSpriteEntity implements Collider, Collided, SceneBorderCrossingWatcher {
    /**
     * damagePoints: Een double waarde die de hoeveelheid schade vertegenwoordigt die het wapen toebrengt bij een botsing.
     */
    private double damagePoints;

    /**
     * Protected constructor:Door de constructor protected te maken, beperkt de klasse het direct aanmaken van WeaponType-objecten buiten het pakket of door ongerelateerde klassen.
     * @param resource : De locatie van het sprite-bestand (afbeelding) dat voor het wapen wordt gebruikt.
     * @param initialLocation : De beginpositie van het wapen op het scherm (als Coordinate2D object).
     * @param size : De grootte van de wapen sprite (als Size object).
     **/
    protected WeaponType(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size );
    }

    /**
     * getDamagePoints()
     * @return retourneert de hoeveelheid schade die het wapen toebrengt.
     */
    public double getDamagePoints() {
        return damagePoints;
    }

    /**
     * setDamagePoints()
     * @param damagePoints stelt de hoeveelheid schade die het wapen toebrengt in.
     */
    public void setDamagePoints(double damagePoints) {
        this.damagePoints = damagePoints;
    }

    /**
     * onCollision:Deze methode wordt opgeroepen wanneer het wapen botst met andere objecten in de game (vanwege de Collider interface implementatie).
     * @param collidingObject a {@link List} of all instances of {@link Collider} this {@link Collided} has collided
     *                         with, during the last Game World Update.
     */
    @Override
    public void onCollision(List<Collider> collidingObject) {
    }

}
