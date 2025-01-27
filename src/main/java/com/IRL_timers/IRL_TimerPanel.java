package com.IRL_timers;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class IRL_TimerPanel extends PluginPanel
{
    IRL_TimerPlugin plugin;
    JTextField textField;
    JButton startTimerButton;
    JButton cancelTimerButton;
    JPanel title;
    JPanel base;
    String textValue;
    Countdown countdown;


    public IRL_TimerPanel(IRL_TimerPlugin plugin)
    {
        this.plugin = plugin; //only useful if I want to access the plugins config file. Doesn't hurt either though.
        base = new JPanel();
        //base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
        base.setBorder(new EmptyBorder(10, 50, 50, 50));

        title = new JPanel();

        //title.setBorder(new EmptyBorder(10, 10, 10, 10));
        title.setBackground(ColorScheme.DARK_GRAY_COLOR);
        title.add(new JLabel("Enter a time in minutes."));

        startTimerButton = new JButton("Start timer");
        startTimerButton.addActionListener(e-> {
            startTimer();
        });

        cancelTimerButton = new JButton("Cancel timer");
        cancelTimerButton.addActionListener(e-> {
            stopTimer();
        });
        cancelTimerButton.setEnabled(false);
        cancelTimerButton.setVisible((false));

        textField = new JTextField();

        base.add(textField);
        base.add(title);
        base.add(startTimerButton);
        base.add(cancelTimerButton);
        add(base);
    }

    public void startTimer()
    {
        // Test
        textValue = textField.getText();
        textField.removeAll();
        this.countdown = new Countdown(textValue, textField);
        this.countdown.startCountdown();
        startTimerButton.setEnabled(false);
        startTimerButton.setVisible(false);
        textField.setEnabled(false);
        cancelTimerButton.setEnabled(true);
        cancelTimerButton.setVisible((true));


    }

    public void stopTimer() {
        this.countdown.cancelCountdown();
        cancelTimerButton.setEnabled(false);
        cancelTimerButton.setVisible((false));
        startTimerButton.setEnabled(true);
        startTimerButton.setVisible((true));
        textField.setEnabled(true);


    }

    public void addTimer()
    {
        //TODO: needs to correctly add a new JPanel with the timer and related variables
        repaint();
        revalidate();
    }

    public void removeTimer(JPanel timerPanel)
    {
        //TODO: Remove the selected JPanel and unset the variables for the related timer
        timerPanel.removeAll();
        repaint();
        revalidate();
    }

}
