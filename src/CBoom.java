import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CBoom {
    BufferedImage img,imgB;
    public int x=0,y=0;
    int state=0;
    public CBoom(int sx,int sy)
    {
        this.x=sx;
        this.y=sy;
        try {
            img= ImageIO.read(getClass().getResource("boom.png"));
            imgB= ImageIO.read(getClass().getResource("boom2.png"));
        }catch (IOException e){

        }
    }
    public boolean paint(Graphics g)
    {
        if(state==0)
        {
            g.drawImage(img,x,y,null);
        }
        else
        {
            g.drawImage(imgB,x,y,null);
        }
        return true;
    }
    public boolean move()
    {
        if(state==0)
        {
            y-=18;
            if(y<0){
                return false;
            }
        }
        else
        {
            state++;
            if (state>6){
                return false;
            }
        }
        return true;
    }
    public boolean checkAttack(CEnemy e) {
        int left1, left2;
        int right1, right2;
        int top1,top2;
        int bottom1,bottom2;
        left1=x;
        left2=e.x;
        right1=x+34;
        right2=e.x+48;
        top1=y;
        top2=e.y;
        bottom1=y+40;
        bottom2=e.y+44;
        if(bottom1<top2) return false;
        if (top1>bottom2) return false;
        if (right1<left2) return false;
        if(left1>right2) return false;
        state=1;
        return true;
    }
}
