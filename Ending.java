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
public class Ending extends MouseAdapter 
{
    public String musicwin = "win.wav";
    private Game game;
    private Handler handler;
    public BufferedImage backgroundimage;
    public BufferedImage pictureimage;
    public BufferedImage kosimage;
    public BufferedImage mama1image;
    public BufferedImage mama2image;
    public BufferedImage mc1image;
    public BufferedImage mc2image;
    private int cnt = 0;
    public Ending(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
        try {
            backgroundimage = ImageIO.read(new File("gamebackgroundimage.png"));
            pictureimage = ImageIO.read(new File("pictureimage.png"));
            kosimage = ImageIO.read(new File("kosimage.png"));
            mama1image = ImageIO.read(new File("mama1image.png"));
            mama2image = ImageIO.read(new File("mama2image.png"));
            mc1image = ImageIO.read(new File("mc1image.png"));
            mc2image = ImageIO.read(new File("mc2image.png"));
        } catch (IOException e) {
        }
    }
    public void tick() { 
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        Hudba musicobject = new Hudba();
        if(mouseOver(mx,my,0,0,700,500)){
            if(game.end == true) {
                if(cnt == 0) {
                    musicobject.playMusic(musicwin);
                    cnt = 1;
                }
                else if(cnt == 1) {
                    cnt = 2;
                }
                else if(cnt == 2) {
                    cnt = 3;
                }
                else if(cnt == 3) {
                    game.invslot1a = 0; game.invslot2a = 0; game.invslot3a = 0;
    game.invslot4a = 0; game.invon = true; game.suplikon = false;
    game.dvereon = true; game.movekeyon = false; game.keyon = false; 
    game.skrinin = false; game.inventorykeyon = false;
    game.skrinopen = false; game.keytaken = false; game.invkeyinslot1 = false;
    game.invkeyinslot2 = false; game.invkeyinslot3 = false;
    game.invkeyinslot4 = false; game.movekeyused = false;
    game.invshoeson = false; game.invtieon = false; game.invshirton = false;
    game.shoeso = true; game.tieo = true; game.shirto = true; 
    game.invshoesinslot1 = false; game.invshoesinslot2 = false;
    game.invshoesinslot3 = false; game.invshoesinslot4 = false; 
    game.invtieinslot1 = false; game.invtieinslot2 = false; 
    game.invtieinslot3 = false; game.invtieinslot4 = false;
    game.invshirtinslot1 = false; game.invshirtinslot2 = false;
    game.invshirtinslot3 = false; game.invshirtinslot4 = false;
    game.shirttidied = false; game.tietidied = false;
    game.shoestidied = false; game.shirtused = false; game.shoesused = false;
    game.tieused = false; game.moveshirton = false; game.movetieon = false; 
    game.moveshoeson = false; game.end = false; game.open = false;
                    game.gameState = STATE.Menu;
                    cnt = 0;
                }
            }
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void render(Graphics g) {
        g.drawImage(backgroundimage,0,0,640,440,null);
        g.drawImage(pictureimage,230,100,110,110,null);
        g.drawImage(kosimage,325,195,160,140,null);
        g.drawImage(mc1image,0,0,500,500,null);
        g.drawImage(mama1image,0,0,550,440,null);
        if(cnt == 0) {
        }
        if(cnt == 1) {
        }
        if(cnt == 2) {
            g.drawImage(mama2image,0,0,550,440,null);
            g.drawImage(mc2image,0,0,500,500,null);
        }
        if(cnt == 3) {
            g.drawImage(mama2image,0,0,550,440,null);
            g.drawImage(mc2image,0,0,500,500,null);
        }
    }
}