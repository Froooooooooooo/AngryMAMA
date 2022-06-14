package gamepack;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import gamepack.Game.STATE;
public class MoveShirt extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private BufferedImage reyimage;
    public String musicclick = "click.wav";
     public MoveShirt(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            reyimage = ImageIO.read(new File("rey.png"));
        } catch (IOException e) {
        }
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,200,90,200,70)){
            if(game.skrinin == true) {
                if(game.moveshirton == true) {
                    game.shirttidied = true;
                    game.moveshirton = false;
                    game.shirtused = true;
                    game.invshirton = false;
                    musicobject.playMusic(musicclick);
                    if(game.invshirtinslot1 == true) {
                        game.invshirtinslot1 = false;
                        game.invslot1a = 0;
                    }
                    else if(game.invshirtinslot2 == true) {
                        game.invshirtinslot2 = false;
                        game.invslot2a = 0;
                    }
                    else if(game.invshirtinslot3 == true) {
                        game.invshirtinslot3 = false;
                        game.invslot3a = 0;
                    }
                    else if(game.invshirtinslot4 == true) {
                        game.invshirtinslot4 = false;
                        game.invslot4a = 0;
                    }
                }
            }
        }
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
        if(game.moveshirton == true) {
            if(game.invshirtinslot1 == true) {
                g.drawImage(reyimage,190,378,70,70,null);
            }
            else if(game.invshirtinslot2 == true) {
                g.drawImage(reyimage,240,378,70,70,null);
            }
            else if(game.invshirtinslot3 == true) {
                g.drawImage(reyimage,290,378,70,70,null);
            }
            else if(game.invshirtinslot4 == true) {
                g.drawImage(reyimage,340,378,70,70,null);
            }
        }
    }
}