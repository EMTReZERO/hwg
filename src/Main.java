import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        final JFrame f = new JFrame();
        GameJPanel gm = new GameJPanel();
        f.setTitle("小朋友下樓梯");
        f.setSize(700, 650);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(gm);
        f.setVisible(true);
        Timer timer = new Timer(100,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.repaint();
                    }
                });
        timer.start();
    }
}