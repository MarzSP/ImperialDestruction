package AlienDestruction.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import javafx.scene.input.MouseButton;

public class BoosterButton extends SpriteButton implements TimerContainer {
    static final int BoostTime = 10;
    static final int CoolDownTime = 20;

    protected boolean boosterActive = false;
    protected boolean coolingDownActive = false;

    public boolean isActive() {
        return this.boosterActive;
    }

    public void setBoosterActive(boolean boosterActive) {
        this.boosterActive = boosterActive;
    }

    public void setCoolingDownActive(boolean coolingDownActive) {
        this.coolingDownActive = coolingDownActive;
    }

    protected SelfTimer timer = new SelfTimer(0);

    @Override
    public void setupTimers() {
        this.timer.pause();
        addTimer(this.timer);
    }

    public BoosterButton(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
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
