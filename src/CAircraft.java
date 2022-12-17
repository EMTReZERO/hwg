import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CAircraft {
    BufferedImage img;
    public int x = 350, y = 500;
    int dir = 0;

    public CAircraft() {
        try {
            img = ImageIO.read(getClass().getResource("airplane1.png"));
        } catch (IOException e) {

        }
    }

    public void move() {
        if (dir == 0) {
            this.x += 16;
        } else {
            this.x -= 16;
        }
    }

    public void changDir(int x) {
        if (this.x > x) dir = 1;
        else dir = 0;
    }

    public void paint(Graphics g) {
        g.drawImage(img, this.x, this.y, null);
    }

    public boolean checkAttack(CEnemy e) {
        int left1, left2;
        int right1, right2;
        int top1,top2;
        int bottom1,bottom2;
        left1=x;
        left2=e.x;
        right1=x+77;
        right2=e.x+48;
        top1=y;
        top2=e.y;
        bottom1=y+45;
        bottom2=e.y+44;
        if(bottom1<top2) return false;
        if (top1>bottom2) return false;
        if (right1<left2) return false;
        if(left1>right2) return false;
        return true;
    }
}
