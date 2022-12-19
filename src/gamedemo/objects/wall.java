package gamedemo.objects;

import gamedemo.utils.controllers.ImageController;
import gamedemo.utils.gameobjects.GameObject;

import java.awt.*;

public class wall extends GameObject {
    public wall(double x, double y) {
        super(x, y,18,600);
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(ImageController.instance().tryGetImage("../../../r/wall.png"),(int)painter().left(),(int)painter().top(),18,600,null);
    }
}
