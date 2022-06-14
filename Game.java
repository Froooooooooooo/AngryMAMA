package gamepack;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Game extends Canvas implements Runnable 
{
    private BufferedImage backgroundimage;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Menu menu;
    private Opening opening;
    private Ending ending;
    private Klic klic;
    private InventoryKey inventorykey;
    private MoveKey movekey;
    private Dvere dvere;
    private Suplik suplik;
    private Skrin skrin;
    private Inventar inventar;
    private SkrinInside skrininside;
    private InventoryShoes inventoryshoes;
    private Shoes shoes;
    private InventoryTie inventorytie;
    private Tie tie;
    private InventoryShirt inventoryshirt;
    private Shirt shirt;
    private ShirtOn shirton;
    private TieOn tieonc;
    private ShoesOn shoesonc;
    private ShirtOn shirtonc;
    private MoveShirt moveshirt;
    private MoveShoes moveshoes;
    private MoveTie movetie;
    public String backgroundmusic = "background.wav";
    public int invslot1a = 0, invslot2a = 0, invslot3a = 0, invslot4a = 0;
    public boolean invon = true, suplikon = false, dvereon = true, 
    movekeyon = false, keyon = false, skrinin = false, 
    inventorykeyon = false, skrinopen = false, keytaken = false, 
    invkeyinslot1 = false, invkeyinslot2 = false, invkeyinslot3 = false,
    invkeyinslot4 = false, movekeyused = false, invshoeson = false, 
    invtieon = false, invshirton = false, shoeso = true, tieo = true,
    shirto = true, invshoesinslot1 = false, invshoesinslot2 = false,
    invshoesinslot3 = false, invshoesinslot4 = false, invtieinslot1 = false,
    invtieinslot2 = false, invtieinslot3 = false, invtieinslot4 = false,
    invshirtinslot1 = false, invshirtinslot2 = false, invshirtinslot3 = false,
    invshirtinslot4 = false, shirttidied = false, tietidied = false, shoestidied = false,
    shirtused = false, shoesused = false, tieused = false, moveshirton = false,
    movetieon = false, moveshoeson = false, end = false, open = false;
    public enum STATE {
        Menu, 
        Game,
        Opening,
        Ending
    };
    public STATE gameState = STATE.Menu;
    public Game() {
        handler = new Handler();
        Hudba musicobject = new Hudba();
        musicobject.playBackground(backgroundmusic);
        menu = new Menu(this,handler);
        ending = new Ending(this,handler);
        opening = new Opening(this,handler);
        inventar = new Inventar(this,handler);
        movekey = new MoveKey(this,handler);     
        inventorykey = new InventoryKey(this,handler);
        skrin = new Skrin(this,handler);
        dvere = new Dvere(this,handler);
        suplik = new Suplik(this,handler);
        klic = new Klic(this,handler);
        skrininside = new SkrinInside(this,handler);
        inventoryshoes = new InventoryShoes(this,handler);
        inventorytie = new InventoryTie(this,handler);
        inventoryshirt = new InventoryShirt(this,handler);
        shoes = new Shoes(this,handler);
        tie = new Tie(this,handler);
        shirt = new Shirt(this,handler);
        shirtonc = new ShirtOn(this,handler);
        tieonc = new TieOn(this,handler);
        shoesonc = new ShoesOn(this,handler);
        moveshirt = new MoveShirt(this,handler);
        moveshoes = new MoveShoes(this,handler);
        movetie = new MoveTie(this,handler);
        
        this.addMouseListener(menu);
        this.addMouseListener(opening);
        this.addMouseListener(ending);
        this.addMouseListener(skrininside);
        this.addMouseListener(klic);
        this.addMouseListener(inventorykey);
        this.addMouseListener(movekey);
        this.addMouseListener(dvere);
        this.addMouseListener(suplik);
        this.addMouseListener(skrin);
        this.addMouseListener(inventoryshoes);
        this.addMouseListener(inventorytie);
        this.addMouseListener(inventoryshirt);
        this.addMouseListener(shoes);
        this.addMouseListener(tie);
        this.addMouseListener(shirt);
        this.addMouseListener(shoesonc);
        this.addMouseListener(shirtonc);
        this.addMouseListener(tieonc);
        this.addMouseListener(movetie);
        this.addMouseListener(moveshirt);
        this.addMouseListener(moveshoes);
        try {
            backgroundimage = ImageIO.read(new File("gamebackgroundimage.png"));
        } catch (IOException e) {
        }
        new Okno(WIDTH, HEIGHT, "Scary Mama", this);
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.nanoTime();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running) render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop(); 
    }
    private void tick() {
        handler.tick();
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);
        handler.render(g);
        if(gameState == STATE.Game) {
            g.drawImage(backgroundimage,0,0,640,440,null);
            if(shirto == true) {
                shirt.render(g);
            }
            if(invon == true) {
                inventar.render(g);
            }
            if(inventorykeyon == true) {
                inventorykey.render(g);
            }
            if(invshoeson == true) {
                inventoryshoes.render(g);
            }
            if(invtieon == true) {
                inventorytie.render(g);
            }
            if(invshirton == true) {
                inventoryshirt.render(g);
            }
            if(shoeso == true) {
                shoes.render(g);
            }
            if(tieo == true) {
                tie.render(g);
            }
            if(dvereon == true) {
                dvere.render(g);
            }
            if(suplikon == true) {
                suplik.render(g);
            }    
            if(keyon == true) {
                klic.render(g);
            }
            if(skrinopen == true) {
                skrin.render(g);
            }
            if(skrinin == true) {
                skrininside.render(g);
            }
             if(tietidied == true) {
                tieonc.render(g);
            }
            if(shirttidied == true) {
                shirtonc.render(g);
            }
            if(shoestidied == true) {
                shoesonc.render(g);
            }
            if(movekeyon == true) {
                movekey.render(g);
            }
            else if(moveshoeson == true) {
                moveshoes.render(g);
            }
            else if(moveshirton == true) {
                moveshirt.render(g);
            }
            else if(movetieon == true) {
                movetie.render(g);
            }
        }
        else if(gameState == STATE.Menu) {
            menu.render(g);
        }
        else if(gameState == STATE.Opening) {
            opening.render(g);
        }
        else if(gameState == STATE.Ending) {
            ending.render(g);
        }
        g.dispose();
        bs.show();
    }
    public static void main(String[] args)
    {
        new Game();
    }
}
