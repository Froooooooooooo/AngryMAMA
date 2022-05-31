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
public class Inventar extends MouseAdapter
{
    private Game game;
    private Handler handler;
    public BufferedImage invimage;
    public BufferedImage kosimage;
    public BufferedImage pictureimage;
    public Inventar(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            invimage = ImageIO.read(new File("invimage.png"));
            kosimage = ImageIO.read(new File("kosimage.png"));
            pictureimage = ImageIO.read(new File("pictureimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
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
        g.drawImage(invimage,150,265,300,300,null);
        g.drawImage(kosimage,325,195,160,140,null);
        g.drawImage(pictureimage,230,100,110,110,null);
        if(game.dvereon == false) {
            if(game.tietidied == true) {
                if(game.shoestidied == true) {
                    if(game.shirttidied == true) {
                        game.gameState = STATE.Ending;
                        game.end = true;
                    }
                }
            }
        }
    }
}