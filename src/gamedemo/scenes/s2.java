package gamedemo.scenes;

//import gamedemo.utils.controllers.AudioResourceController;
import gamedemo.objects.Obstacle;
import gamedemo.objects.Player;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.core.CommandSolver;
import gamedemo.utils.core.Scene;
import gamedemo.utils.gameobjects.Rect;
//import gamedemo.utils.gameobjects.Animator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class s2 extends Scene {
    Player player;
    Obstacle ob;
    int x,y;
//    Animator ar,al,as;

    @Override
    public void sceneBegin() {
        x=30;
        y=30;
        player=new Player(x,y);
        ob=new Obstacle(30,800);
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        player.paint(g);
        ob.paint(g);
        g.drawImage(ImageController.instance().tryGetImage("../../../r/ceiling.png"),0,0,800,16,null );
        g.drawImage(ImageController.instance().tryGetImage("../../../r/wall.png"),770,0,18,600,null );
        g.drawImage(ImageController.instance().tryGetImage("../../../r/wall.png"),0,0,18,600,null );
    }

    @Override
    public void update() {
        player.update();
        ob.update();
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
                    player.setState(player.LEFT);
                }
                if(commandCode== KeyEvent.VK_RIGHT)
                {
                    player.setState(player.RIGHT);
                }
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                player.setState(player.STAND_STILL);
            }

            @Override
            public void keyTyped(char c, long trigTime) {

            }
        };
    }
}
