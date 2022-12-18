/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo.utils.gameobjects;

import gamedemo.utils.Delay;
import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.Global.*;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author user1
 */
public class Animator {

    private Image img;//連續圖片
    private int count;//目前張數
    private final Delay delay;//控制切換速度
    
    int width;
    int height;
    int[] actions;
    int sourceWidth;
    int sourceHeight;
    int picSize;
    
    public Animator(String imgPath, int delayFrame, int width, int height, int[] actions){
        this(imgPath, delayFrame, width, height, actions, actions.length);
    }
    
    public Animator(String imgPath, int delayFrame, int width, int height, int[] actions, int picSize){
        count = 0;
        img = ImageController.instance().tryGetImage(imgPath);
        this.picSize = picSize;
        sourceHeight = img.getHeight(null);
        sourceWidth = img.getWidth(null) / picSize;
        delay = new Delay(delayFrame);
        delay.loop();
        
        this.width = width;
        this.height = height;
        this.actions = actions;
    }
    
    public void reset(){
        count = 0;
        delay.stop();
        delay.loop();
    }
    
    public boolean isEnd(){
        return count == actions.length - 1;
    }
    
    public void paint(int left, int top, Graphics g) {
        if (count < actions.length) {
            g.drawImage(img,
                    left, top,
                    left + width, top + height,
                    sourceWidth * actions[count], 0,
                    sourceWidth + sourceWidth * actions[count], sourceHeight, null);
        }
    }

    public void update() {
        if (delay.count()) {
            count = ++count % actions.length;
        }
    }

}
