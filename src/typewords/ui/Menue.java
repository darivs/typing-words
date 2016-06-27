package typewords.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menue extends JPanel {
    JFrame menue = new JFrame("typewords.ui.Menue");
    JPanel panel = new JPanel();

    JButton btStart = new JButton("Start");
    JButton btList = new JButton("Highscore");
    JButton btExit = new JButton("Exit");

    public void menue() {
        SwingUtilities.invokeLater(this::btEvent);
    }

    public void btEvent() {
        menue.setVisible(true);
        menue.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        menue.setSize(100, 117);
        menue.add(panel);

        panel.add(btStart);
        panel.add(btList);
        panel.add(btExit);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        //menue.getContentPane().add(BorderLayout.PAGE_END, panel);

        btStart.addActionListener(new StartGame());
        btList.addActionListener(new LoadList());
        btExit.addActionListener(new ExitGame());
    }

    class StartGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            menue.setVisible(false);
            try { new GamePanel().startGame(); } catch (IOException e1) { e1.printStackTrace(); }
        }
    }

    class ExitGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            new Main().exit();
        }
    }

    class LoadList implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            JOptionPane.showMessageDialog(null, "No highscore list available.");
        }
    }
}
