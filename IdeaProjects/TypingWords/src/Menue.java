import java.io.IOException;

public class Menue {

    public void menue() {
        System.out.println("\n\tMenue\n\t=====\n\t(1) Start\n\t(2) Highscore\n\t(3) Exit\n\t");

        String choice = new Main().decide();
        whatToDo(choice);
    }

    public String whatToDo(String c) {
        switch(c) {
            case "1": try { new Main().start(); } catch (IOException e) { e.printStackTrace(); } break;
            case "2": try { new Main().loadList(); } catch (IOException e) { e.printStackTrace(); } break;
            case "3": new Main().exit(); break;
            default: System.out.println("false entry!"); break;
        }

        return c;
    }
}
