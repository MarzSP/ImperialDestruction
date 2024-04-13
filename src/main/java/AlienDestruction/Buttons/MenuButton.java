package AlienDestruction.Buttons;

import AlienDestruction.App;
import AlienDestruction.Scenes.GameMenu;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuButton extends Button {
    private App app;
    public MenuButton(App app, Coordinate2D initialLocation) {
        super(initialLocation, "Menu");
        this.app = app;
        setFill(Color.CADETBLUE);
        setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        setAnchorPoint(AnchorPoint.TOP_RIGHT);
    }

        @Override
        public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
            app.setActiveScene(App.SceneIds.GameMenu);
            }
    }

