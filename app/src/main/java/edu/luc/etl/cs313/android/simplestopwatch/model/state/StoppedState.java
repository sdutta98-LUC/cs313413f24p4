package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import android.util.Log;
import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements StopwatchState {

    public StoppedState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.toIncrementingState();
        sm.actionInc();
        sm.clockStart();
    }

    @Override
    public void onTick() {
        System.out.println(111);
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
