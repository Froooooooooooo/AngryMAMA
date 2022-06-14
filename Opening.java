package gamepack;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class Opening extends MouseAdapter 
{
    public String musiccar = "car.wav";
    private Game game;
    private Handler handler;
    public BufferedImage backgroundimage;
    public BufferedImage pictureimage;
    public BufferedImage kosimage;
    public BufferedImage mc1image;
    public BufferedImage mc2image;
    public BufferedImage openingimage;
    private BufferedImage shirtimage;
    private BufferedImage shoesimage;
    private BufferedImage tieimage;
    public BufferedImage dvereimage;
    private int cnt = 0;
    public Opening(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            backgroundimage = ImageIO.read(new File("gamebackgroundimage.png"));
            pictureimage = ImageIO.read(new File("pictureimage.png"));
            kosimage = ImageIO.read(new File("kosimage.png"));
            mc1image = ImageIO.read(new File("mc1image.png"));
            mc2image = ImageIO.read(new File("mc2image.png"));
            openingimage = ImageIO.read(new File("openingimage.png"));
            tieimage = ImageIO.read(new File("ntieimage.png"));
            shoesimage = ImageIO.read(new File("shoesimage.png"));
            shirtimage = ImageIO.read(new File("shirtimage.png"));
            dvereimage = ImageIO.read(new File("dvereimage.png"));
        } catch (IOException e) {
        }
    }
    public void tick() { 
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,0,0,700,500)){
            if(game.open == true) {
                if(cnt == 0) {
                    cnt = 1;
                }
                else if(cnt == 1) {
                    cnt = 2;
                    musicobject.playMusic(musiccar);
                }
                else if(cnt == 2) {
                    cnt = 3;
                }
                else if(cnt == 3) {
                    cnt = 4;
                }
                else if(cnt == 4) {
                    game.gameState = STATE.Game;
                    cnt = 0;
                    game.open = false;
                }
            }
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void render(Graphics g) {
        g.drawImage(backgroundimage,0,0,640,440,null);
        g.drawImage(pictureimage,230,100,110,110,null);
        g.drawImage(kosimage,325,195,160,140,null);
        g.drawImage(dvereimage,0,0,640,449,null);
        g.drawImage(shirtimage,40,270,250,250,null);
        g.drawImage(mc1image,0,0,500,500,null);
        g.drawImage(tieimage,80,200,75,75,null);
        g.drawImage(shoesimage,100,50,300,300,null);
        if(cnt == 0) {
        }
        if(cnt == 1) {
        }
        if(cnt == 2) {
            g.drawImage(mc2image,0,0,500,500,null);
        }
        if(cnt == 3) {
            g.drawImage(openingimage,0,0,640,440,null);
        }
        if(cnt == 4) {
            g.drawImage(openingimage,0,0,640,440,null);
        }
    }
}