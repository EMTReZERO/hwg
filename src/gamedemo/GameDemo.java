package gamedemo;

import gamedemo.utils.core.GIImpl;
import gamedemo.utils.core.GameKernel;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;

import static gamedemo.utils.Global.FRAME_LIMIT;
import static gamedemo.utils.Global.UPDATE_TIMES_PER_SEC;

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
        int[][] command={
                {KeyEvent.VK_LEFT,KeyEvent.VK_LEFT},
                {KeyEvent.VK_RIGHT,KeyEvent.VK_RIGHT},
                /*{KeyEvent.VK_UP,KeyEvent.VK_UP},
                {KeyEvent.VK_DOWN,KeyEvent.VK_DOWN},
                {KeyEvent.VK_A,KeyEvent.VK_LEFT},
                {KeyEvent.VK_D,KeyEvent.VK_RIGHT},
                {KeyEvent.VK_W,KeyEvent.VK_UP},
                {KeyEvent.VK_S,KeyEvent.VK_DOWN},*/
                {KeyEvent.VK_SPACE,KeyEvent.VK_SPACE},
        };
        /*GameKernel.GameInterface gi = new GameKernel.GameInterface() {
            int x = 30, y = 30;

            @Override
            public void paint(Graphics g) {
                g.setColor(Color.red);
                g.drawOval(x,y, 100, 100);
            }

            @Override
            public void update() {
                x ++;
            }
        };*/
        GIImpl gi=new GIImpl(new DemoScene());
        GameKernel gk = new GameKernel.Builder(gi,FRAME_LIMIT,UPDATE_TIMES_PER_SEC)
                .initListener(command)
                .enableMouseTrack(gi)
                .enableKeyboardTrack(gi)
                /*.enableMouseTrack((e, state, trigTime) -> {
                    if(state!=null){
                        System.out.println(state);
                    }
                })*/
                .mouseForceRelease()
                /*.enableKeyboardTrack(new CommandSolver.KeyListener() {
                    @Override
                    public void keyPressed(int commandCode, long trigTime) {//按下
                        System.out.println(commandCode+"按下");
                    }

                    @Override
                    public void keyReleased(int commandCode, long trigTime) {//放開
                        System.out.println(commandCode+"放開");
                    }

                    @Override
                    public void keyTyped(char c, long trigTime) {
                        System.out.println(c+"按了什麼");
                    }
                })*/
                .keyCleanMode() // detect release one times.
                //.keyTypedMode() // detect one times.
                // up two function will use the second one, first will be covered.
                .trackChar() // when write this KeyTyped() will enable else not work.
                .gen();
        jf.add(gk);
        jf.setVisible(true);
        gk.run(false);
    }
}
