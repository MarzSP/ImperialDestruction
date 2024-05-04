package AlienDestruction.Entities;

import AlienDestruction.Helper;
import AlienDestruction.Weapons.WeaponType;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


import java.util.List;


/**
 * Class GameEntities:
 * Extends:
 *     DynamicSpriteEntity: Erft van de DynamicSpriteEntity klasse die functionaliteit biedt voor het hanteren van een bewegende sprite entity met een afbeelding.
 *     SceneBorderTouchingWatcher: Implementeert de SceneBorderTouchingWatcher interface om te detecteren wanneer het object de rand van het scherm raakt.
 *     Newtonian: Implementeert de Newtonian interface om physics simulatie toe te passen (zwaartekracht).
 *     Collided: Implementeert de Collided interface om te detecteren wanneer het object met andere objecten botst. (Zoals bijv Speler met Vijand)
 *     Collider: Implementeert de Collider interface voor detectie van botsingen
 *     Rotatable: Implementeert de Rotatable interface om rotatie van sprites mogelijk te maken
 *     SceneBorderCrossingWatcher: Implementeert de SceneBorderCrossingWatcher interface om te detecteren wanneer het objectbuiten de schermranden komt.
 */
public class GameEntities extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Newtonian, Collided, Collider, Rotatable, SceneBorderCrossingWatcher {
    private int points;
    private int penaltyPoints;
    private int hitPoints;
    private boolean canShoot;
    private boolean allowedToFire = true;
    /**
     * Player player is final:
     * Dit betekent dat de EnemyFour-instantie altijd een geldige referentie naar de Player-instantie heeft.
     * Dit voorkomt dat er fouten optreden door null-waarden of ongeldige verwijzingen.
     */
    private final Player player;
    private Timer fireTimer;

    /**
     * Constructor:
     * Initialiseert het object met een afbeelding, locatie, grootte en referentie naar de speler. Schakelt zwaartekracht en wrijving uit.
     * @param resource De afbeelding van de GameEntity
     * @param initialLocation De initiele locatie van de GameEntity
     * @param size Het formaat van de sprite
     * @param player de referentie naar Player zodat deze kan interageren met Player
     */
    protected GameEntities(String resource, Coordinate2D initialLocation, Size size, Player player) {
        super(resource, initialLocation);
        this.player = player;

        setGravityConstant(0.000);
        setFrictionConstant(0.00);

        fireTimer = new Timer(4000) {
            @Override
            public void onAnimationUpdate(long timestamp) {
                shoot();
            }
        };
    }

    public void shoot() {
        if (this.canShoot) {
            if (this.allowedToFire) {

                System.out.println("test");
                this.allowedToFire = false;
            }
        }
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getPenaltyPoints() {
        return penaltyPoints;
    }
    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }
//    public int getHitPoints() {
//        return hitPoints;
//    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public boolean isCanShoot() {
        return canShoot;
    }
    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
    }

    /**
     * Detecteert botsingen en handelt deze af.
     *     Botsing met WeaponType vermindert hitPoints en controleert of vernietiging nodig is.
     *     Botsing met de speler, leidt tot verwijdering van dit object.
     *     Anders: stuurt het object in een andere richting.
     * @param collidingObject a {@link List} of all instances of {@link Collider} this {@link Collided} has collided
     *                         with, during the last Game World Update.
     */
    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject){
            if (collider instanceof WeaponType){
                addDamage(((WeaponType) collider).getDamagePoints());
                checkIfDestroyed();
                ((WeaponType) collider).remove(); // remove Laser / Weapon
                break;
            } else if (collider instanceof Player){ // TODO Checken ??
                remove();
                break;
            } else {
                this.setMotion(this.getSpeed(), this.calculateCourse((int)getDirection()));
            }
        }
    }

    /**
     * calculateCourse maakt een nieuwe koers gebaseerd op de oude richting
     * @param oldDirection de richting waar de Entity vandaan kwam, zodat deze kan veranderen naar een nieuwe
     * @return newDirection de nieuwe richting waar de Entity heen gaat
     */
    public int calculateCourse(int oldDirection){
        int newDirection = 0;
        if (oldDirection < 359 && oldDirection > 271) {
            newDirection = 90 - (360-oldDirection);
        } else {
            newDirection = 360 -(360-oldDirection);
        }
        return newDirection;
    }

    /**
     * addDamage(double damage): Vermindert de hitPoints met de opgegeven schade.
     * @param damage de hoeveelheid hitPoints dat een Entity geeft
     */
    public void addDamage(double damage){
        this.hitPoints -= damage;
    }

    /**
     * checkIfDestroyed(): Controleert of het object vernietigd moet worden (hitpoints <= 0) en voegt score toe aan de speler en verwijdert zichzelf.
     */
    public void checkIfDestroyed(){
        if (this.hitPoints <= 0) {
            player.increaseScore(points);
            this.remove();                      // remove Enemy / entity
        }
    }

    /**
     * getCourse(double xPos): Berekent een nieuwe koers gebaseerd op de horizontale positie
     * @param xPos de X positie van de koers van deze Entity
     * @return de nieuwe koers van deze Entity in graden.
     * Als de xPos kleiner is dan 600, wordt een willekeurige koers tussen 10 en 40 graden gekozen.
     * Als de xPos groter is dan 500, wordt een willekeurige koers tussen 310 en 340 graden gekozen.
     * In andere gevallen wordt 0 graden (recht omhoog) geretourneerd.
     */
    public int getCourse(double xPos){
        if(xPos < 600) {
            return Helper.getRandomInt(10, 40);
        } else if (xPos >500) {
            return Helper.getRandomInt(310, 340);
        }
        return 0;
    }

    /**
     * notifyBoundaryCrossing(SceneBorder sceneBorder):
     * Deze methode wordt aangeroepen wanneer de vijand de grens van het scherm verlaat (sceneBorder).
     */
    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    }

}
