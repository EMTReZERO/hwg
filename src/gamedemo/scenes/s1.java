package gamedemo.scenes;

import gamedemo.utils.controllers.AudioResourceController;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.controllers.SceneController;
import gamedemo.utils.core.CommandSolver;
import gamedemo.utils.core.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class s1 extends Scene {
    int x,y;
    boolean reverse;
    @Override
    public void sceneBegin() {
        x=30;
        y=30;
        reverse=false;
        AudioResourceController.getInstance().loop("../../../r/bg.wav",-1);
    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
    }

    @Override
    public void update() {
        if(reverse){
            x++;
        }else {
            x--;
        }
        if(x>130||x<30){
            reverse=!reverse;
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        /*return new CommandSolver.MouseCommandListener() {
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {

            }
        };*/
        return null;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return new CommandSolver.KeyListener() {
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                //AudioResourceController.getInstance().shot("");
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                if(commandCode== KeyEvent.VK_SPACE){
                    SceneController.instance().change(new s2());
                }
            }

            @Override
            public void keyTyped(char c, long trigTime) {

            }
        };
        //return  null;
    }
}
