package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import android.util.Log;
import edu.luc.etl.cs313.android.simplestopwatch.R;

public class IncrementingState implements StopwatchState{

    public IncrementingState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;
    private int tickCount = 0;

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.Incrementing;
    }

    @Override
    public void onStartStop() {
        sm.actionInc();
        sm.clockReset();
        tickCount = 0;
        if(sm.getTime() == 99) {
            //BEEP
            sm.startAlarm();
            sm.toRunningState();
        }
    }

    @Override
    public void onTick() {
        if (tickCount == 3 && sm.getTime() != 0) {
            sm.startAlarm();
            sm.toRunningState();
            tickCount = 0;
        } else {
            tickCount++;
        }
    }
}
