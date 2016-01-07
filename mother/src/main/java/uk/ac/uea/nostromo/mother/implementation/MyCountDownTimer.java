package uk.ac.uea.nostromo.mother.implementation;

import android.os.CountDownTimer;

public abstract class MyCountDownTimer implements IMyCountDownTimer {
    private MyInnerTimerCountDownTimer mTimer;

    boolean updateTimeLeft = false;


    public MyCountDownTimer(long millisecsuntilfinished, long interval) {

        mTimer = new MyInnerTimerCountDownTimer(millisecsuntilfinished, interval, this);
    }

    public void resetTimer(long millisInFuture){
        mTimer = new MyInnerTimerCountDownTimer(millisInFuture, mTimer.getInterval(), this);
        mTimer.start();
    }

    public void start(){
        mTimer.start();
    }

    public void cancel(){
        mTimer.cancel();
    }

    public long getTimeLeft(){
        return mTimer.getLocalTimeUntilFinish();
    }

    private class MyInnerTimerCountDownTimer extends CountDownTimer {
        IMyCountDownTimer mtimer;
        long localTimeUntilFinish, interval;

        public MyInnerTimerCountDownTimer(long millisecondsUntilFinish, long interval, IMyCountDownTimer mtimer) {
            super(millisecondsUntilFinish, interval);
            this.localTimeUntilFinish = millisecondsUntilFinish;
            this.interval = interval;
            this.mtimer = mtimer;
        }

        @Override
        public void onTick(long l) {
            mtimer.onTick(l);
            localTimeUntilFinish = l;
        }

        @Override
        public void onFinish() {
            mtimer.onFinish();
        }

        public long getLocalTimeUntilFinish() {
            return localTimeUntilFinish;
        }

        public long getInterval() {
            return interval;
        }

        public IMyCountDownTimer getTimer() {
            return mtimer;
        }
    }
}
