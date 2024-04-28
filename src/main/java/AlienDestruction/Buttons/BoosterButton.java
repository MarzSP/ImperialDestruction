package AlienDestruction.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import javafx.scene.input.MouseButton;

/**
 * BoosterButton is een implementatie van de SpriteButton klasse:
 *  de "Booster" knop in het "Game Screen" is een knop die activeert een tijdelijke boost voor de speler met een cooldown periode.

 * BoosterButton:
 * BoostTime: Statische final variabele met de duur van de boost in seconden (10). Deze is statisch final omdat deze niet zal veranderen.
 * CoolDownTime: Statische final variabele met de duur van de cooldown periode in seconden (20).
 * boosterActive: Boolean is eem variabele die aangeeft of de boost actief is (true) of niet actief (false).
 * coolingDownActive: Boolean variabele die aangeeft of de cooldown periode actief is (true) of niet (false).
 * timer: `SelfTimer` object dat gebruikt wordt om de boost en cooldown te timen.
 *
 * BoosterButton Methoden:
 * isActive(): Retourneert `true` als de boost actief is, anders `false`.
 * setBoosterActive(boolean boosterActive): Stelt de `boosterActive` variabele in.
 * setCoolingDownActive(boolean coolingDownActive): Stelt de `coolingDownActive` variabele in.
 * setupTimers(): Pauzeert de interne timer en voegt deze toe aan de lijst met timers.
 *
 * onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D):
 *  Controleert of de boost of cooldown actief is, zo ja, dan gebeurt er niks.
 *   Activeert de boost - start de timer voor de boost tijd en hervat de timer.
 *
 * BoosterButton Innerlijke klasse:
 *  SelfTimer: Extends de `Timer` klasse en handelt de boost en cooldown functies af.
 *     `onAnimationUpdate(long timestamp)`:
 *         * Pauzeert zichzelf.
 *         * Controleert of de boost actief is:
 *             * Als boost actief, schakelt deze over naar cooldown, start de cooldown timer en hervat de timer.
 *         * Controleert of de cooldown actief is:
 *             * Als cooldown actief, schakelt deze de cooldown uit.
 * Implements: TimerContainer van Yaeger
 */
public class BoosterButton extends SpriteButton implements TimerContainer {
    static final int BoostTime = 10;
    static final int CoolDownTime = 20;

    protected boolean boosterActive = false;
    protected boolean coolingDownActive = false;
    protected SelfTimer timer = new SelfTimer(0);

    public BoosterButton(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    public boolean isActive() {
        return this.boosterActive;
    }

    public void setBoosterActive(boolean boosterActive) {
        this.boosterActive = boosterActive;
    }

    public void setCoolingDownActive(boolean coolingDownActive) {
        this.coolingDownActive = coolingDownActive;
    }

    @Override
    public void setupTimers() {
        this.timer.pause();
        addTimer(this.timer);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (this.boosterActive || this.coolingDownActive) {
            return;
        }

        setBoosterActive(true);
        timer.setIntervalInMs(BoostTime*1000);
        timer.resume();
    }

    public class SelfTimer extends Timer {
        protected SelfTimer(long intervalInMs) {
            super(intervalInMs);
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            this.pause();
            if (boosterActive) {
                setBoosterActive(false);
                setCoolingDownActive(true);
                this.setIntervalInMs(CoolDownTime*1000);
                this.resume();
            } else if (coolingDownActive) {
                setCoolingDownActive(false);
            }
        }
    }

}
