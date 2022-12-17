package gamedemo;

import javax.swing.JFrame;

/**
 *
 * @author user1
 */
public class GameDemo {
    public static void main(String[] args) {
        final JFrame jf = new JFrame();
        jf.setTitle("Demo Game");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 按X會關閉
        
        
        jf.setVisible(true);
    }
}
