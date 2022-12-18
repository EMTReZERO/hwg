package gamedemo.scenes;

//import gamedemo.utils.controllers.AudioResourceController;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.core.CommandSolver;
import gamedemo.utils.core.Scene;

import java.awt.*;

public class s2 extends Scene {
    int x,y;
    @Override
    public void sceneBegin() {
        x=30;
        y=30;
        //AudioResourceController.getInstance().shot("../../../r/bg.wav");
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImageController.instance().tryGetImage("../../../r/ceiling.png"),0,0,800,16,null );
        
        g.drawImage(ImageController.instance().tryGetImage("../../../r/player_1.png"),x,y,null );
    }

    @Override
    public void update() {

    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }
}
