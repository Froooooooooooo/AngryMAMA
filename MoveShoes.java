package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class MoveShoes extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage reyimage;
    public String musicclick = "click.wav";
    public MoveShoes(Game game, Handler handler) {
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
        if(mouseOver(mx,my,200,310,200,70)){
            if(game.skrinin == true) {
            if(game.moveshoeson == true) {
                game.shoestidied = true;
                game.moveshoeson = false;
                game.shoesused = true;
                game.invshoeson = false;
                musicobject.playMusic(musicclick);
                if(game.invshoesinslot1 == true) {
                    game.invshoesinslot1 = false;
                    game.invslot1a = 0;
                }
                if(game.invshoesinslot2 == true) {
                    game.invshoesinslot2 = false;
                    game.invslot2a = 0;
                }
                if(game.invshoesinslot3 == true) {
                    game.invshoesinslot3 = false;
                    game.invslot3a = 0;
                }
                if(game.invshoesinslot4 == true) {
                    game.invshoesinslot4 = false;
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
        if(game.moveshoeson == true) {
            if(game.invshoesinslot1 == true) {
                g.drawImage(reyimage,190,378,70,70,null);
            }
            else if(game.invshoesinslot2 == true) {
                g.drawImage(reyimage,240,378,70,70,null);
            }
            else if(game.invshoesinslot3 == true) {
                g.drawImage(reyimage,290,378,70,70,null);
            }
            else if(game.invshoesinslot4 == true) {
                g.drawImage(reyimage,340,378,70,70,null);
            }
        }
    }
}