package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class InventoryKey extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage invkeyimage;
    public InventoryKey(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            invkeyimage = ImageIO.read(new File("invkeyimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if((mouseOver(mx,my,197,380,50,57))&&(game.invkeyinslot1 == true)){
            if(game.movekeyused == false) {
                game.movekeyon = true;
            }
        }
        else if((game.invkeyinslot2 == true)&&(mouseOver(mx,my,250,379,54,57))) {  
            if(game.movekeyused == false) {
                game.movekeyon = true;
            }
        }
        else if((game.invkeyinslot3 == true)&&(mouseOver(mx,my,296,379,55,57))) {
            if(game.movekeyused == false) {
                game.movekeyon = true;
            }
        }
        else if((game.invkeyinslot4 == true)&&(mouseOver(mx,my,350,379,57,57))) { 
            if(game.movekeyused == false) {
                game.movekeyon = true;
            }
        }
        else if((mouseOver(mx,my,180,367,300,75))&&(game.movekeyon == true)){
            game.movekeyon = false;
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
        if(game.invkeyinslot1 == true) {
            g.drawImage(invkeyimage,182,367,90,90,null);
        }
        else if(game.invkeyinslot2 == true) {
            g.drawImage(invkeyimage,232,367,90,90,null);
        }
        else if(game.invkeyinslot3 == true) {
            g.drawImage(invkeyimage,282,367,90,90,null);
        }
        else if(game.invkeyinslot4 == true) {
            g.drawImage(invkeyimage,332,367,90,90,null);
        }
        else {}
    }
}