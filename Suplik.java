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
public class Suplik extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage suplikimage;
    private int count = 0;
    public String musicclick = "click.wav";
    public String musicprogress = "progress.wav";
    public Suplik(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            suplikimage = ImageIO.read(new File("suplikimage.png"));
        } catch (IOException e) {
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(game.movekeyon == false) {
        if(game.moveshoeson == false) {
        if(game.moveshoeson == false) {
        if(game.moveshirton == false) {
        if(mouseOver(mx,my,205,235,32,30)){
            if(count == 0) {
                game.suplikon = true;
                musicobject.playMusic(musicclick);
                count = 1;
                if(game.keytaken == false) {
                    if(game.movetieon == false) {
                        game.keyon = true;
                        musicobject.playMusic(musicprogress);
                    }
                }
            }
        }
        if(mouseOver(mx,my,200,233,30,30)){
            if(game.movekeyon == false) {
            if(count == 1) {
                game.suplikon = false;
                count = 0;
                musicobject.playMusic(musicclick);
                game.keyon = false;
            }
            }
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
        g.drawImage(suplikimage,0,0,641,440,null);
    }
}
