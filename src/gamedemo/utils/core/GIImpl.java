package gamedemo.utils.core;

import gamedemo.utils.controllers.SceneController;
import gamedemo.utils.core.CommandSolver.*;
import java.awt.*;
import java.awt.event.MouseEvent;
public class GIImpl implements GameKernel.GameInterface, MouseCommandListener, KeyListener{
    public GIImpl(Scene startingScene){
        SceneController.instance().change(startingScene);
    }
    
    @Override
    public void paint(Graphics g) {
        SceneController.instance().paint(g);
    }

    @Override
    public void update() {
        SceneController.instance().update();
    }

   @Override
    public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
        MouseCommandListener ml = SceneController.instance().mouseListener();
        if(ml != null){
            ml.mouseTrig(e, state, trigTime);
        }
    }

    @Override
    public void keyPressed(int commandCode, long trigTime) {
        KeyListener kl = SceneController.instance().keyListener();
        if(kl != null){
            kl.keyPressed(commandCode, trigTime);
        }
    }

    @Override
    public void keyReleased(int commandCode, long trigTime) {
        KeyListener kl = SceneController.instance().keyListener();
        if(kl != null){
            kl.keyReleased(commandCode, trigTime);
        }
    }

    @Override
    public void keyTyped(char c, long trigTime) {
        KeyListener kl = SceneController.instance().keyListener();
        if(kl != null){
            kl.keyTyped(c, trigTime);
        }
    }
    
}
