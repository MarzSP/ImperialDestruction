package AlienDestruction.Buttons;

import AlienDestruction.App;
import AlienDestruction.Buttons.Button;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends Button implements MouseButtonPressedListener {
    private App app;

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
        app.setActiveScene(App.SceneIds.GameScreen);

    }
}
