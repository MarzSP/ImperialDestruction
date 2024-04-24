package AlienDestruction.Buttons;

import AlienDestruction.App;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import javafx.scene.input.MouseButton;

/**
 * De MusicButton klasse is een sub-klasse van de abstracte SpriteButton klasse en specificeert een sprite knop om de achtergrondmuziek te visueel te kunnen bedienen.
 *  Constructor voor de `MusicButton` klasse:
 * @param initialLocation De initiële locatie van de knop op het scherm.
 *  @param musicClip Het `SoundClip` object dat de achtergrondmuziek bevat.
 */
public class MusicButton extends SpriteButton {

    private static final String ResourceSpeakerOn = "sprites/speaker.png";
    private final SoundClip musicClip;
    private boolean isActive = false;

    public MusicButton(
            Coordinate2D initialLocation,
            SoundClip musicClip
    ) {
        super(ResourceSpeakerOn, initialLocation);
        this.musicClip = musicClip;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (isActive) {
            isActive = false;
            musicClip.stop();
        } else {
            isActive = true;
            musicClip.play();
        }
    }
}
