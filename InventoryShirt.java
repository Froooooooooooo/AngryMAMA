package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class InventoryShirt extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage invshirtimage;
    public InventoryShirt(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            invshirtimage = ImageIO.read(new File("shirtimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if((mouseOver(mx,my,197,380,50,57))&&(game.invshirtinslot1 == true)){
            if(game.shirtused == false) {
                game.moveshirton = true;
            }
        }
        else if((game.invshirtinslot2 == true)&&(mouseOver(mx,my,250,379,54,57))) {  
            if(game.shirtused == false) {
                game.moveshirton = true;
            }
        }
        else if((game.invshirtinslot3 == true)&&(mouseOver(mx,my,296,379,55,57))) {
            if(game.shirtused == false) {
                game.moveshirton = true;
            }
        }
        else if((game.invshirtinslot4 == true)&&(mouseOver(mx,my,350,379,57,57))) { 
            if(game.shirtused == false) {
                game.moveshirton = true;
            }
        }
        else if((mouseOver(mx,my,180,367,300,75))&&(game.moveshirton == true)){
            game.moveshirton = false;
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
        if(game.invshirtinslot1 == true) {
            g.drawImage(invshirtimage,190,378,70,70,null);
        }
        else if(game.invshirtinslot2 == true) {
            g.drawImage(invshirtimage,240,378,70,70,null);
        }
        else if(game.invshirtinslot3 == true) {
            g.drawImage(invshirtimage,290,378,70,70,null);
        }
        else if(game.invshirtinslot4 == true) {
            g.drawImage(invshirtimage,340,378,70,70,null);
        }
        else {}
    }
}
