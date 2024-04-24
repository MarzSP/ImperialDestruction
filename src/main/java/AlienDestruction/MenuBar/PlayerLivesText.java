package AlienDestruction.MenuBar;

import AlienDestruction.App;
import AlienDestruction.Entities.Player;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerLivesText extends TextEntity {

    private Player player;

    public PlayerLivesText(Coordinate2D initialLocation, Player player) {
        super(initialLocation);
        this.player = player;

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.ANTIQUEWHITE);
        updateText(); // Update text initially
    }

    private void updateText() {
        setText("Lives: " + player.getLives());
    }
    }