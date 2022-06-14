package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class Shirt extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage shirtimage;
    public String musicprogress = "progress.wav";
    public Shirt(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            shirtimage = ImageIO.read(new File("shirtimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(game.moveshoeson == false) {
            if(game.movekeyon == false) {
            if(game.movetieon == false) {
            if(mouseOver(mx,my,80,330,110,110)){
                if(game.shirto == true) {
                game.invshirton = true;
                musicobject.playMusic(musicprogress);
                if(game.invslot1a == 0) {
                    game.invslot1a = 1;
                    game.invshirtinslot1 = true;
                }
                else if(game.invslot2a == 0) {
                    game.invslot2a = 1;
                    game.invshirtinslot2 = true;
                }
                else if(game.invslot3a == 0) {
                    game.invslot3a = 1;
                    game.invshirtinslot3 = true;
                }
                else if(game.invslot4a == 0) {
                    game.invslot4a = 1;
                    game.invshirtinslot4 = true;
                }
                else {}
                game.shirto = false;
                }
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
        g.drawImage(shirtimage,40,270,250,250,null);
    }
}
