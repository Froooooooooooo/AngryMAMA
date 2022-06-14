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
public class Klic extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage klicimage;
    public String musicprogress = "progress.wav";
    public Klic(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            klicimage = ImageIO.read(new File("keyimage.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(game.moveshoeson == false) {
            if(game.movetieon == false) {
            if(game.moveshirton == false) {
            if(mouseOver(mx,my,218,216,40,26)){
                if(game.keyon == true) {
                game.inventorykeyon = true;
                if(game.invslot1a == 0) {
                    game.invslot1a = 1;
                    game.invkeyinslot1 = true;
                }
                else if(game.invslot2a == 0) {
                    game.invslot2a = 1;
                    game.invkeyinslot2 = true;
                }
                else if(game.invslot3a == 0) {
                    game.invslot3a = 1;
                    game.invkeyinslot3 = true;
                }
                else if(game.invslot4a == 0) {
                    game.invslot4a = 1;
                    game.invkeyinslot4 = true;
                }
                else {}
                game.keyon = false;
                game.keytaken = true;
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
        g.drawImage(klicimage,195,166,95,95,null);
    }
}
