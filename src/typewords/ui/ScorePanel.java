package typewords.ui;// Created by Darius on 28.06.2016.

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    JFrame scoreFrame = new JFrame();
    JPanel subPanel = new JPanel();
    JLabel msg;
    JButton apply;

    JTextField inputName = new JTextField("Lorem", 30);

    public ScorePanel() {
        scoreFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        scoreFrame.setPreferredSize(new Dimension(100,50));
    }

    public void enterScore(){
        scoreFrame.add(this);
        msg = new JLabel("Please enter your name:");
        apply = new JButton("Apply");

        subPanel.add(msg, 0);
        subPanel.add(inputName, 1);
        subPanel.add(apply, 2);

        subPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        scoreFrame.getContentPane().add(BorderLayout.PAGE_END, subPanel);

        scoreFrame.pack();
        scoreFrame.setVisible(true);
    }

}
