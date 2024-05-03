package AlienDestruction.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.input.MouseButton;

public class PauseButton extends SpriteButton {

    private boolean isPaused;
    private static final String resourcePause = "sprites/pause-button.png";
    private DynamicScene gameScreen;

    public PauseButton(Coordinate2D initialLocation, DynamicScene gameScreen) {
        super(resourcePause, initialLocation);
        this.gameScreen = gameScreen;
        isPaused = false; //
    }

    private void pauseGame() {
        gameScreen.pause();
        System.out.println("Game Paused!");
    }

    private void resumeGame() {
        gameScreen.resume();
        System.out.println("Game Resumed!");
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (isPaused) {
            resumeGame();
        } else {
            pauseGame();
        }
        isPaused = !isPaused;
    }
}


