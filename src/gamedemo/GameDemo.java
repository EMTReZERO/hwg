package gamedemo;

//import gamedemo.scenes.MainScenes;
import gamedemo.utils.controllers.ImageController;
//import gamedemo.utils.core.GIImpl;
import gamedemo.utils.core.GameKernel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author user1
 */
public class GameDemo {
    public static void main(String[] args) {
        final JFrame jf = new JFrame();
        jf.setTitle("小朋友下樓梯");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 按X會關閉
        int command[][] = {
                {KeyEvent.VK_W, KeyEvent.VK_W},
                {KeyEvent.VK_A, KeyEvent.VK_A},
                {KeyEvent.VK_S, KeyEvent.VK_S},
                {KeyEvent.VK_D, KeyEvent.VK_D},
                {KeyEvent.VK_SPACE, KeyEvent.VK_SPACE},
        };
        GameKernel.GameInterface gi = new GameKernel.GameInterface() {
            int x = 30;
            @Override
            public void paint(Graphics g) {
                g.drawImage(ImageController.instance().tryGetImage("r/player_1.png"),0,0,null);
            }

            @Override
            public void update() {
                x += 1;
            }
        };
        GameKernel gk=new GameKernel.Builder(gi,60,60)
                .gen();
        jf.add(gk);
        jf.setVisible(true);
        gk.run(false);
    }
}
