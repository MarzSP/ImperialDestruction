package AlienDestruction.Buttons;
import AlienDestruction.App;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De PlayAgainButton is een sub-klasse van Button.
 * Deze knop wordt in het Eindscherm gebruikt om het spel opnieuw op te starten nadat het is afgelopen.
 */
    public class PlayAgainButton extends Button {
        protected App app;

        public PlayAgainButton(Coordinate2D initialLocation, App app) {
            super(initialLocation, "Play again!");
            this.app = app;
            setFill(Color.BLACK);
            setStrokeWidth(2);
            setStrokeColor(Color.GOLD);
            setFont(Font.font("FUTURA BOLD", FontWeight.BOLD, 70));
            setAnchorPoint(AnchorPoint.CENTER_CENTER);
        }

        @Override
        public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
            if (button == MouseButton.PRIMARY) {
                app.setActiveScene(App.SceneIds.StartScreen);
}
        }
    }

