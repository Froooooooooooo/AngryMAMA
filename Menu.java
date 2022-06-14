package gamepack;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import gamepack.Game.STATE;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Menu extends MouseAdapter 
{
    private Game game;
    private Handler handler;
    public BufferedImage startimage;
    public BufferedImage backgroundimage;
    public String musicclick = "click.wav";
    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            startimage = ImageIO.read(new File("startimage.png"));
            backgroundimage = ImageIO.read(new File("menubackgroundimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,200,260,230,130)){
            if(game.gameState == STATE.Menu) {
                game.gameState = STATE.Opening;
                game.open = true;
                musicobject.playMusic(musicclick);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
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
    public void tick() {
    }
    public void render(Graphics g) {
        g.drawImage(backgroundimage,0,0,640,440,null);
        g.drawImage(startimage,160,200,300,240,null);
    }
}
