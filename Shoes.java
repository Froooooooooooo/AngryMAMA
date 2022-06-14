package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class Shoes extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage shoesimage;
    public String musicprogress = "progress.wav";
    public Shoes(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            shoesimage = ImageIO.read(new File("shoesimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,185,280,45,45)){
            if(game.shoeso == true) {
                if(game.movetieon == false) {
                if(game.moveshirton == false) {
                game.invshoeson = true;
                if(game.invslot1a == 0) {
                    game.invslot1a = 1;
                    game.invshoesinslot1 = true;
                }
                else if(game.invslot2a == 0) {
                    game.invslot2a = 1;
                    game.invshoesinslot2 = true;
                }
                else if(game.invslot3a == 0) {
                    game.invslot3a = 1;
                    game.invshoesinslot3 = true;
                }
                else if(game.invslot4a == 0) {
                    game.invslot4a = 1;
                    game.invshoesinslot4 = true;
                }
                else {}
                game.shoeso = false;
                musicobject.playMusic(musicprogress);
                }
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
        g.drawImage(shoesimage,100,50,300,300,null);
    }
}
