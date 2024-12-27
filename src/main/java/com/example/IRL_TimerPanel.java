package com.example;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.config.Units;

import java.time.Duration;
import java.time.Instant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class IRL_TimerPanel extends PluginPanel
{
    IRL_TimerPlugin plugin;
    JTextField textField;
    JButton startTimerButton;
    JButton addTimerButton;
    JPanel title;
    JPanel base;
    String textValue;

    public IRL_TimerPanel(IRL_TimerPlugin plugin)
    {
        this.plugin = plugin; //only useful if I want to access the plugins config file. Doesn't hurt either though.
        base = new JPanel();
        base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
        base.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.setBackground(ColorScheme.BRAND_ORANGE);

        title = new JPanel();
        title.setLayout(new GridLayout(0, 1));
        title.setBorder(new EmptyBorder(10, 10, 10, 10));
        title.setBackground(ColorScheme.DARK_GRAY_COLOR);
        title.add(new JLabel("Enter a time in minutes."));

        startTimerButton = new JButton("Start timer");
        startTimerButton.addActionListener(e-> {
            startTimer();
        });

        addTimerButton = new JButton("+");
        addTimerButton.addActionListener(e -> {
            addTimer();
        });

        textField = new JTextField();

        base.add(textField);
        base.add(title);
        add(base);
        add(startTimerButton);
        add(addTimerButton);
    }

    public void startTimer()
    {
        // Test
        textValue = textField.getText();
        System.out.println(textValue);
        //TODO: Implement timer functionality

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
        repaint();
        revalidate();
    }

}
