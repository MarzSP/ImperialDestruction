package AlienDestruction.Game;

import com.github.hanyaeger.api.TimerContainer;

import java.util.List;

public class Timer implements TimerContainer {

//    static final int BoostTime = 5;
//    static final int CoolDownTime = 10;
//
//    protected boolean boosterActive = false;
//    protected boolean coolingDownActive = false;
//    public Booster.SelfTimer timer = new Booster.SelfTimer(0);

    private int duration;

    private boolean durationActive;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isDurationActive() {
        return durationActive;
    }

    public void setDurationActive(boolean durationActive) {
        this.durationActive = durationActive;
    }

    @Override
    public void setupTimers() {
    }

    @Override
    public List<com.github.hanyaeger.api.Timer> getTimers() {
        return null;
    }
}
