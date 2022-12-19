package gamedemo.objects;

import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.gameobjects.GameObject;

import java.awt.*;

public class Obstacle extends GameObject {
    private int yspeed=-3;
    public Obstacle(double x, double y) {
        super(x, y,97,16);

    }

    @Override
    public void update() {
        this.translateY(yspeed);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(ImageController.instance().tryGetImage("../../../r/normal.png"),(int)painter().left(),(int)painter().top(),97,16,null );
    }
}
