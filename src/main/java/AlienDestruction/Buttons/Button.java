package AlienDestruction.Buttons;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De abstracte Button klasse vormt de basis voor de knoppen in de game. Knoppen erven van deze klasse de abstracte methode ‘onMouseButtonPressed’.
 * Constructor: Constructor voor de Button klasse:
 *  @param coordinate2D De initiële locatie van de knop op het scherm.
 *  @param text De tekst die op de knop wordt weergegeven.*
 * Implements: MouseButtonPressedListener, MouseExitListener, MouseEnterListener.
 */
public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    abstract public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D);

    public Button(final Coordinate2D initialLocation, final String text) {
        super(initialLocation, text);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.RED);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.GOLD);
        setCursor(Cursor.DEFAULT);
    }
}