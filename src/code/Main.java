package code;

import javax.swing.JFrame;
import code.core.GamePanel;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
//        System.out.println("Hello");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Rooted");

        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();
    }
}
