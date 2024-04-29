package AlienDestruction.Scenes;

import AlienDestruction.App;
import AlienDestruction.Buttons.DifficultyButtons;
import AlienDestruction.Buttons.MusicButton;
import AlienDestruction.Buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/** Deze klasse is verantwoordelijk voor het openingsscherm, deze bevat:
 * de "Imperial Destruction" titel, achtergrond afbeelding, muziek aan/uit knop, startknop
 * knoppen voor Easy, Medium, en Hard moeilijkheidsgraad.
**/
 public class StartScreen extends MenuManager {
    protected final App app;

    public StartScreen(App app) {
        this.app = app;
    }

    public void setupScene() {
        setBackgroundImage("backgrounds/universe1.jpg");

        SoundClip musicClip = new SoundClip("audio/swmaintheme.mp3", SoundClip.INDEFINITE);
        MusicButton musicButton;
        musicButton = new MusicButton(new Coordinate2D(20, 20), musicClip, new Size( 20,20) );
        addEntity(musicButton);
    }

    @Override
    public void setupEntities() {
        super.setupEntities();
        var startmenuText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "Imperial Destruction"
        );
        startmenuText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        startmenuText.setFill(Color.ANTIQUEWHITE);
        startmenuText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
        addEntity(startmenuText);

        // Start Game Button
        var startButton = new StartButton(app, new Coordinate2D(getWidth() / 2, getHeight() * 5/6));
        addEntity(startButton);

        // Difficulty Level: Easy, Medium, Hard
        Coordinate2D button1Location = new Coordinate2D(getWidth() * 1/3, getHeight() /2);
        Coordinate2D button2Location = new Coordinate2D(getWidth() * 1/2 - 35, getHeight() /2);
        Coordinate2D button3Location = new Coordinate2D(getWidth() * 2/3, getHeight() /2);

        DifficultyButtons easyButton = new DifficultyButtons(button1Location, 0);
        DifficultyButtons mediumButton = new DifficultyButtons(button2Location, 1);
        DifficultyButtons hardButton = new DifficultyButtons(button3Location, 2);

        addEntity(easyButton);
        addEntity(mediumButton);
        addEntity(hardButton);

    }
    }

