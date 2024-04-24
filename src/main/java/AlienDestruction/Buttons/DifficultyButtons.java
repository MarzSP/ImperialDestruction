package AlienDestruction.Buttons;

import AlienDestruction.App;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Dit is een sub-klasse van Button die knoppen maakt voor de verschillende moeilijkheidsgraden(Easy, Medium, Hard).
 * Constructor voor de `DifficultyButtons` klasse:
 *  @param initialLocation De initiële locatie van de knop op het scherm.
 *  @param difficultyIndex De index van de moeilijkheidsgraad in de `DIFFICULTIES` array (0 = Easy, 1 = Medium, 2 = Hard).
 */
public class DifficultyButtons extends Button {
    private static final String[] DIFFICULTIES = {"Easy", "Medium", "Hard"};
    public DifficultyButtons (Coordinate2D initialLocation, int difficultyIndex) {
        super(initialLocation, DIFFICULTIES[difficultyIndex]);
        setFill(Color.GOLD);
        setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 40));
        setAnchorPoint(AnchorPoint.CENTER_LEFT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        // Kunnen we invullen zodra er levels zijn
    }
}
