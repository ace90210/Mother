package uk.ac.uea.nostromo.mother.implementation;

import android.os.CountDownTimer;

public interface IMyCountDownTimer {

    void start();
    void cancel();
    void onTick(long l);
    void onFinish();

}
