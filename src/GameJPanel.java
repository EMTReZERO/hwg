import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;

public class GameJPanel extends javax.swing.JPanel {
    CAircraft ac;
    ArrayList<CBoom> bm;
    ArrayList<CEnemy> cm;
    int sx = 0, sy = 0;
    AudioClip clip;
    AudioClip bgmusic;
    BufferedImage img;
    Image bgImg;
    int x = 30, y = 250;
    int dir = 0;

    public GameJPanel() {
        ac = new CAircraft();
        bm = new ArrayList();
        cm = new ArrayList();
        //TODO Auto-generated constructor stub
        //initComponents();
        this.setFocusable(true);
        this.addMouseListener(new CMyListener1());
        this.addMouseMotionListener(new CMyListener1());
        try {
            bgImg=new ImageIcon(getClass().getResource("sea.png")).getImage();
            clip= Applet.newAudioClip(getClass().getResource("bomb.wav"));
            bgmusic=Applet.newAudioClip(getClass().getResource("Alarm01.wav"));
        }catch (Exception e){

        }
        bgmusic.loop();
        Timer t1 = new Timer(100,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ac.move();
                        if (Math.random() > 0.8 && cm.size() < 11) {
                            CEnemy c = new CEnemy((int) (Math.random() * 600), 0, (int) (Math.random() * 10) - 5);
                            cm.add(c);
                        }
                        for (int i = 0; i < cm.size(); i++) {
                            if (cm.get(i).move() == false) {
                                cm.remove(i);
                            } else {
                                if (ac.checkAttack(cm.get(i))) {
                                    System.exit(0);
                                }
                            }
                        }
                        for (int i = 0; i < bm.size(); i++) {
                            if (bm.get(i).move() == false) {
                                bm.remove(i);
                            } else {
                                if (bm.get(i).state == 0) {
                                    for (int j = 0; j < cm.size(); j++) {
                                        if (bm.get(i).checkAttack(cm.get(j))) {
                                            cm.remove(j);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
        t1.start();
    }

    public void paintComponent(Graphics g) {
        try {
            g.drawImage(ImageIO.read(getClass().getResource("airplane1.png")), this.x, this.y, 250, 250, this);
        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
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

    class CMyListener1 extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == e.BUTTON1) {
                sx = ac.x + 5;
                sy = ac.y - 10;
                CBoom c = new CBoom(sx, sy);
                bm.add(c);
                clip.play();
            }
        }

        public void mouseMoved(MouseEvent e) {
            ac.changDir(e.getX());
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg,0,0,700,650,this);
        ac.paint(g);
        //System.out.println(cm.size());
        for (int i = 0; i < cm.size(); i++) {
            cm.get(i).paint(g);
        }
        for (int i = 0; i < bm.size(); i++) {
            bm.get(i).paint(g);
        }
    }

}