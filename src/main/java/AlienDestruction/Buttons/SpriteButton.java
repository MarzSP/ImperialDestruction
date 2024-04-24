package AlienDestruction.Buttons;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
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
 * De SpriteButton klasse is een abstracte klasse die de basis vormt voor de knoppen met een afbeelding in plaats van tekst.
 * Constructor voor de `SpriteButton` klasse:
 * @param resource De locatie van de sprite afbeelding die voor de knop wordt gebruikt.
 * @param initialLocation De initiële locatie van de knop op het scherm.
 * Implements: MouseButtonPressedListener
 */
public abstract class SpriteButton extends DynamicSpriteEntity implements MouseButtonPressedListener {
    abstract public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D);

    public SpriteButton(final String resource, final Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

}