package AlienDestruction.Entities;

import AlienDestruction.Helper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.SceneBorder;
/**
   * EnemyThree:erft van de GameEntities klasse, dit is een vijand die niet kan schieten.
   * EnemyThree erft: zie constructor
**/
public class EnemyThree extends GameEntities{
    /**
     *   Player player is final:
     *  Dit betekent dat de EnemyThree-instantie altijd een geldige referentie naar de Player-instantie heeft.
     * Dit voorkomt dat er fouten optreden door null-waarden of ongeldige verwijzingen.
    */

    private final Player player;

    /**
     * Constructor:
     * EnemyThree(Coordinate2D location, Player player, double speedIncrease):
     *   Initialiseert een nieuw object van EnemyThree
     *   Slaat een referentie op naar (player), welke EnemyThree invloed op kan hebben.
     *   Stelt de afbeelding in op "sprites/tieFighterV1.png".
     *   Stelt de grootte in op Helper.Size.MEDIUM.
     *   Stelt de beweging in op Helper.Speed.MEDIUM plus de meegegeven speedIncrease in de neerwaartse richting (Helper.Direction.DOWN).
     *   Stelt de punten in op 100 (points).
     *   Stelt de aftrekpunten in op 120 (penaltyPoints).
     *   Stelt de levens in op 4 (hitPoints).
     *   Stelt canShoot in op true, wat aangeeft dat deze vijand wel kan schieten.
     */

    public EnemyThree(Coordinate2D location, Player player, double speedIncrease) {
        super("sprites/lambdaShuttleV1.png", location, new Size(Helper.Size.LARGE,Helper.Size.MEDIUM), player);
        this.player = player;

        setMotion(Helper.Speed.LOW + speedIncrease, Helper.Direction.DOWN);
        setPoints(100);
        setPenaltyPoints(120);
        setHitPoints(4);
        setCanShoot(false);
    }

    /**
     * notifyBoundaryCrossing(SceneBorder sceneBorder):
     * Deze methode wordt aangeroepen wanneer de vijand de grens van het scherm verlaat (sceneBorder).
     * De speler verliest punten gelijk aan penaltyPoints.
     * De vijand wordt verwijderd (this.remove()).
     */
    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        //gameScreen.getScoreText().setText("Score: " + player.getScore());
        player.setScore(player.getScore() - this.getPenaltyPoints());
        this.remove();
    }
}
