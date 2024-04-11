package AlienDestruction;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    //private final int scene;

    public Button(final Coordinate2D initialLocation, final String text) {
        super(initialLocation, text);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.LIGHTYELLOW);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.YELLOWGREEN);
        setCursor(Cursor.DEFAULT);
    }

}