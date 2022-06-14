package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class Tie extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage tieimage;
    public String musicprogress = "progress.wav";
    public Tie(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            tieimage = ImageIO.read(new File("ntieimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(game.moveshoeson == false) {
            if(game.moveshirton == false) {
            if(game.movekeyon == false) {
            if(mouseOver(mx,my,80,200,75,75)){
                if(game.tieo == true) {
                game.invtieon = true;
                if(game.invslot1a == 0) {
                    game.invslot1a = 1;
                    game.invtieinslot1 = true;
                }
                else if(game.invslot2a == 0) {
                    game.invslot2a = 1;
                    game.invtieinslot2 = true;
                }
                else if(game.invslot3a == 0) {
                    game.invslot3a = 1;
                    game.invtieinslot3 = true;
                }
                else if(game.invslot4a == 0) {
                    game.invslot4a = 1;
                    game.invtieinslot4 = true;
                }
                else {}
                game.tieo = false;
                musicobject.playMusic(musicprogress);
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
        g.drawImage(tieimage,80,200,75,75,null);
    }
}
