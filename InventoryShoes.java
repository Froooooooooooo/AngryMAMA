package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class InventoryShoes extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage invshoesimage;
    public InventoryShoes(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            invshoesimage = ImageIO.read(new File("shoesimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if((mouseOver(mx,my,197,380,50,57))&&(game.invshoesinslot1 == true)){
            if(game.shoesused == false) {
                game.moveshoeson = true;
            }
        }
        else if((game.invshoesinslot2 == true)&&(mouseOver(mx,my,250,379,54,57))) {  
            if(game.shoesused == false) {
                game.moveshoeson = true;
            }
        }
        else if((game.invshoesinslot3 == true)&&(mouseOver(mx,my,296,379,55,57))) {
            if(game.shoesused == false) {
                game.moveshoeson = true;
            }
        }
        else if((game.invshoesinslot4 == true)&&(mouseOver(mx,my,350,379,57,57))) { 
            if(game.shoesused == false) {
                game.moveshoeson = true;
            }
        }
        else if((mouseOver(mx,my,180,367,300,75))&&(game.moveshoeson == true)){
            game.moveshoeson = false;
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
        if(game.invshoesinslot1 == true) {
            g.drawImage(invshoesimage,114,158,300,300,null);
        }
        else if(game.invshoesinslot2 == true) {
            g.drawImage(invshoesimage,164,158,300,300,null);
        }
        else if(game.invshoesinslot3 == true) {
            g.drawImage(invshoesimage,224,158,300,300,null);
        }
        else if(game.invshoesinslot4 == true) {
            g.drawImage(invshoesimage,274,158,300,300,null);
        }
        else {}
    }
}
