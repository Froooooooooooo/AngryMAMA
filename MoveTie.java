package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
import gamepack.Game.STATE;
public class MoveTie extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage reyimage;
    public String musicclick = "click.wav";
    public MoveTie(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            reyimage = ImageIO.read(new File("rey.png"));
        } catch (IOException e) {
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,310,270,45,35)){
            if(game.skrinin == true) {
            if(game.movetieon == true) {
                game.tietidied = true;
                game.movetieon = false;
                game.tieused = true;
                game.invtieon = false;
                if(game.invtieinslot1 == true) {
                    game.invtieinslot1 = false;
                    game.invslot1a = 0;
                }
                if(game.invtieinslot2 == true) {
                    game.invtieinslot2 = false;
                    game.invslot2a = 0;
                }
                if(game.invtieinslot3 == true) {
                    game.invtieinslot3 = false;
                    game.invslot3a = 0;
                }
                if(game.invtieinslot4 == true) {
                    game.invtieinslot4 = false;
                    game.invslot4a = 0;
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
        if(game.movetieon == true) {
            if(game.invtieinslot1 == true) {
                g.drawImage(reyimage,190,378,70,70,null);
            }
            else if(game.invtieinslot2 == true) {
                g.drawImage(reyimage,240,378,70,70,null);
            }
            else if(game.invtieinslot3 == true) {
                g.drawImage(reyimage,290,378,70,70,null);
            }
            else if(game.invtieinslot4 == true) {
                g.drawImage(reyimage,340,378,70,70,null);
            }
        }
    }
}