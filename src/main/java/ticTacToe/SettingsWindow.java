package ticTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JPanel panBottom;
    JLabel gameMode = new JLabel("Выберите режим игры");
    ButtonGroup gameModeButtonsGroup = new ButtonGroup();
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    JLabel gameFieldTitle = new JLabel("Выберите размеры поля");
    JSlider gameFieldSize = new JSlider(3, 10);
    JLabel gameFieldLabel = new JLabel("Установленный размер поля: " + gameFieldSize.getValue());
    JLabel gameWinTitle = new JLabel("Выберите длину для победы");
    JSlider gameWinSize = new JSlider(3, 10);
    JLabel gameWinLabel = new JLabel("Установленная длина: " + gameWinSize.getValue());
    JButton btnStart = new JButton("Start new game");


    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(10, 1));

        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAi);
        panBottom.add(humanVsHuman);
        panBottom.add(gameFieldTitle);
        panBottom.add(gameFieldLabel);
        panBottom.add(gameFieldSize);
        panBottom.add(gameWinTitle);
        panBottom.add(gameWinLabel);
        panBottom.add(gameWinSize);
        panBottom.add(btnStart);

        humanVsAi.setSelected(true);

        gameFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameFieldLabel.setText("Установленный размер поля: " + gameFieldSize.getValue());
            }
        });

        gameWinSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameWinLabel.setText("Установленная длина: " + gameWinSize.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(
                        humanVsAi.isSelected() ? 0 : 1,
                        gameFieldSize.getValue(),
                        gameFieldSize.getValue(),
                        gameWinSize.getValue()
                );
                setVisible(false);
            }
        });

        add(panBottom);
    }
}
