package gamedemo.objects;

import gamedemo.utils.gameobjects.Animator;
import gamedemo.utils.gameobjects.GameObject;

import java.awt.*;

public class Player extends GameObject {
    public static final int STAND_STILL = 0;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    private int c;
    Animator[] a;
    double x,y;
    public Player(double x, double y) {
        super(x, y, 30, 32);
        a = new Animator[3];
        a[STAND_STILL] = new Animator("../../../r/select.png", 5, 22, 32, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        a[RIGHT] = new Animator("../../../r/roll_right.png", 5, 30, 32, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        a[LEFT] = new Animator("../../../r/roll_left.png", 5, 30, 32, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        c = STAND_STILL;
    }

    @Override
    public void update() {
        a[c].update();
        this.translateX(x);
        x=0;
        if(c==RIGHT)
        {
            //player.update();
            x=10;
//            if(x>739)
//            {
//                x=0;
//            }
        }
        if(c==LEFT)
        {
            //player.update();
            x=-10;
//            if(x<18)
//            {
//                x=0;
//            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        a[c].paint((int) painter().left(), (int) painter().top(), g);
    }

    public void setState(int state) {
        this.c = state;
    }
}
