package AlienDestruction.Buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitGameButton extends Button{

    public QuitGameButton(Coordinate2D initialLocation, String text) {
        super(initialLocation, "Quit Game");
        setFill(Color.RED);
        setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 60));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
    System.exit(0); // Terminates the ent app
    }
}
