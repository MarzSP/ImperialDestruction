package AlienDestruction.Buttons;

import AlienDestruction.App;
import AlienDestruction.Buttons.Button;
import AlienDestruction.Helper;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De StartButton klasse is een sub-klasse van de abstracte Button klasse en specificeert de knop om het spel te starten.
 * Constructor voor de `StartButton` klasse.
 *  @param app De instantie van de hoofdapplicatie.
 *  @param initialLocation De initiële locatie van de knop op het scherm.
 * Implements: MouseButtonPressedListener
 */
public class StartButton extends Button implements MouseButtonPressedListener {

    protected App app;


    public StartButton (App app, Coordinate2D initialLocation) {
        super(initialLocation, "Start Game!");
        this.app = app;
        setFill(Color.BLACK);
        setStrokeWidth(2);
        setStrokeColor(Color.GOLD);
        setFont(Font.font("FUTURA BOLD", FontWeight.BOLD, 80));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mousebutton, Coordinate2D coordinate2D){
        app.setActiveScene(Helper.SceneIds.GameScreen);
    }
}
