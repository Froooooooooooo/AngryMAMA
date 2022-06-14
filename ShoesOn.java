package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class ShoesOn extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage shoesonimage;
    public ShoesOn(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            shoesonimage = ImageIO.read(new File("shoesimage.png"));
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
        if(game.shoestidied == true) {
            if(game.skrinin == true) {
                g.drawImage(shoesonimage,230,70,310,310,null);
            }
        }
    }
}