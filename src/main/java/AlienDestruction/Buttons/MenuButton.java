package AlienDestruction.Buttons;

import AlienDestruction.App;
import AlienDestruction.Scenes.GameMenu;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * De MenuButton is sub-klsse van de Button klasse.
 * De knop wordt gebruikt om een menu met opties weer te geven wanneer de speler erop klikt.
 * De constructor initialiseert een nieuw MenuButton-object en stelt de volgende eigenschappen in:
 * initialLocation, Tekstlabel "Menu", tekstkleur, lettertype en ankerpunt.
 */
public class MenuButton extends Button {
    private App app;
    public MenuButton(App app, Coordinate2D initialLocation) {
        super(initialLocation, "Menu");
        this.app = app;
        setFill(Color.GOLD);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        setAnchorPoint(AnchorPoint.TOP_RIGHT);
    }

        @Override
        public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
            app.setActiveScene(App.SceneIds.GameMenu);
            }
    }

