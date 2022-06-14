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
public class SkrinInside extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage skrininsideimage;
    public SkrinInside(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            skrininsideimage = ImageIO.read(new File("skrininsideimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(game.skrinin == true) {
            if(mouseOver(mx,my,200,50,200,320)) {
            }
            else if(mouseOver(mx,my,180,367,300,75)) {}
            else { 
                if(game.movekeyon == false) {
                    game.skrinin = false;
                }
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
        g.drawImage(skrininsideimage,100,40,380,350,null);
    }
}

