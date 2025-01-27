package com.IRL_timers;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class Countdown {

    private Timer timer;
    private JTextField timerText;
    int totalSeconds;

    public Countdown(String timeString, JTextField timerText) {
        this.timerText = timerText;
        this.timer = new Timer();
        this.totalSeconds = Integer.parseInt(timeString.substring(6,8)) +
                            Integer.parseInt(timeString.substring(3,5)) * 60 +
                            Integer.parseInt(timeString.substring(0,2)) * 3600;
    }

    public void startCountdown() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(totalSeconds >= 0) {
                    timerText.setText(String.format("%02d:%02d:%02d", totalSeconds / 3600, (totalSeconds % 3600) / 60, totalSeconds % 60));
                    totalSeconds--;
                }
            }
        };
        this.timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelCountdown() {
        this.timer.cancel();
    }
}
