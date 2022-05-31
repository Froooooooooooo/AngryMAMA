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
public class Dvere extends MouseAdapter
{
    private Game game;
    private Handler handler;
    public BufferedImage dvereimage;
    public Dvere(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            dvereimage = ImageIO.read(new File("dvereimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
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
        if(game.dvereon == true) {
            g.drawImage(dvereimage,0,0,640,449,null);
        }
    }
}
