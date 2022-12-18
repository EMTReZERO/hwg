package gamedemo.scenes;

//import gamedemo.utils.controllers.AudioResourceController;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.core.CommandSolver;
import gamedemo.utils.core.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class s2 extends Scene {
    int x,y,b;
    @Override
    public void sceneBegin() {
        x=30;
        y=30;
        b=0;
        //AudioResourceController.getInstance().shot("../../../r/bg.wav");
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageController.instance().tryGetImage("../../../r/ceiling.png"),0,0,800,16,null );
        g.drawImage(ImageController.instance().tryGetImage("../../../r/wall.png"),770,0,18,600,null );
        g.drawImage(ImageController.instance().tryGetImage("../../../r/wall.png"),0,0,18,600,null );
        if(b==0)
            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_1.png"),x,y,null );
        else if(b==1)
        {
            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_4.png"),x,y,null );
            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_5.png"),x,y,null );
        }
        else
        {
            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_2.png"),x,y,null );
            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_3.png"),x,y,null );
        }

    }

    @Override
    public void update() {
        if(b==2)
        {
            x+=20;
            if(x>739)
            {
                x=739;
            }
        }
        if(b==1)
        {
            x-=20;
            if(x<18)
            {
                x=18;
            }
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return new CommandSolver.KeyListener() {
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                if(commandCode== KeyEvent.VK_LEFT)
                {
                    b=1;
                }
                else if(commandCode== KeyEvent.VK_RIGHT)
                {
                    b=2;
                }
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                b=0;
            }

            @Override
            public void keyTyped(char c, long trigTime) {

            }
        };
    }
}
