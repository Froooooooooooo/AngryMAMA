package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class TieOn extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage tieonimage;
    public TieOn(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            tieonimage = ImageIO.read(new File("tieimage.png"));
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
        if(game.tietidied == true) {
            if(game.skrinin == true) {
                g.drawImage(tieonimage,130,46,340,340,null);
            }
        }
    }
}