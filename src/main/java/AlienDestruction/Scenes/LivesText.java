package AlienDestruction.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LivesText extends TextEntity {
    public LivesText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.ANTIQUEWHITE);
    }

    public void setLivesText(int lives) {

        setText(": " + lives);
    }
}
