import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Menue extends JPanel {
    JFrame menue = new JFrame("Menue");
    JPanel panel = new JPanel();

    JButton btStart = new JButton("Start");
    JButton btList = new JButton("Highscore");
    JButton btExit = new JButton("Exit");

    public void menue() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {btEvent();}
        });
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

        btStart.addActionListener(new StartGame());
        btExit.addActionListener(new ExitGame());
    }

    class StartGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            menue.setVisible(false);
            try { new Main().start(); } catch (IOException e1) { e1.printStackTrace(); }
        }
    }

    class ExitGame implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            new Main().exit();
        }
    }

    /* console-ui
    public String whatToDo(String c) {
        switch(c) {
            case "1": try { new Main().start(); } catch (IOException e) { e.printStackTrace(); } break;
            case "2": try { new Main().loadList(); } catch (IOException e) { e.printStackTrace(); } break;
            case "3": new Main().exit(); break;
            default: System.out.println("false entry!"); break;
        }

        return c;
    }*/
}
