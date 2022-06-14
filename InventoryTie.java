package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class InventoryTie extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage invtieimage;
    public InventoryTie(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            invtieimage = ImageIO.read(new File("ntieimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if((mouseOver(mx,my,197,380,50,57))&&(game.invtieinslot1 == true)){
            if(game.tieused == false) {
                game.movetieon = true;
            }
        }
        else if((game.invtieinslot2 == true)&&(mouseOver(mx,my,250,379,54,57))) {  
            if(game.tieused == false) {
                game.movetieon = true;
            }
        }
        else if((game.invtieinslot3 == true)&&(mouseOver(mx,my,296,379,55,57))) {
            if(game.tieused == false) {
                game.movetieon = true;
            }
        }
        else if((game.invtieinslot4 == true)&&(mouseOver(mx,my,350,379,57,57))) { 
            if(game.tieused == false) {
                game.movetieon = true;
            }
        }
        else if((mouseOver(mx,my,180,365,305,78))&&(game.movetieon == true)){
            game.movetieon = false;
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
        if(game.invtieinslot1 == true) {
            g.drawImage(invtieimage,200,390,50,50,null);
        }
        else if(game.invtieinslot2 == true) {
            g.drawImage(invtieimage,250,390,50,50,null);
        }
        else if(game.invtieinslot3 == true) {
            g.drawImage(invtieimage,300,390,50,50,null);
        }
        else if(game.invtieinslot4 == true) {
            g.drawImage(invtieimage,350,390,50,50,null);
        }
        else {}
    }
}
