package gamedemo.scenes;

//import gamedemo.utils.controllers.AudioResourceController;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.core.CommandSolver;
import gamedemo.utils.core.Scene;
//import gamedemo.utils.gameobjects.Animator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class s2 extends Scene {
    int x,y,b;
//    Animator ar,al,as;
    @Override
    public void sceneBegin() {
        x=30;
        y=30;
//        b=0;
//        ar=new Animator("../../../r/roll_right.png",5,30,32,new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19});
//        al=new Animator("../../../r/roll_left.png",5,30,32,new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19});
//        as=new Animator("../../../r/select.png",5,22,32,new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19});

//        new int[](0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19),20
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
//        if(b==0){
////            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_1.png"),x,y,null );
//            as.paint(x,y,g);
//        }
//        else if(b==1)
//        {
////            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_4.png"),x,y,null );
////            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_5.png"),x,y,null );
//            al.paint(x,y,g);
//
//        }
//        else
//        {
////            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_2.png"),x,y,null );
////            g.drawImage(ImageController.instance().tryGetImage("../../../r/player_3.png"),x,y,null );
//            ar.paint(x,y,g);
//        }

    }

    @Override
    public void update() {

        if(b==2)
        {
//            ar.update();
            x+=10;
            if(x>739)
            {
                x=739;
            }
        }
        else if(b==1)
        {
//            al.update();
            x-=10;
            if(x<18)
            {
                x=18;
            }
        }
//        else
//        {
//            as.update();
//        }
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
