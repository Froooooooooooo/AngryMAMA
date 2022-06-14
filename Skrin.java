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
public class Skrin extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage skrinimage;
    public String musicclick = "click.wav";
    public Skrin(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            skrinimage = ImageIO.read(new File("skrinimage.png"));
        } catch (IOException e) {
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if((mouseOver(mx,my,500,196,20,20))&&(game.skrinopen == true)){
            if(game.movekeyon == false) {
                game.skrinopen = false;
                musicobject.playMusic(musicclick);
            }
        }
        else if((mouseOver(mx,my,500,196,20,20))&&(game.skrinopen == false)){
            if(game.movekeyon == false) {
                game.skrinopen = true;
                musicobject.playMusic(musicclick);
            }
        }
        else if((mouseOver(mx,my,490,140,10,140))&&(game.skrinopen == true)){
            if(game.movekeyon == false) {
                game.skrinin = true;
                musicobject.playMusic(musicclick);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void tick() {
    }
    public void render(Graphics g) {
        g.drawImage(skrinimage,2,0,636,445,null);
    }
}
