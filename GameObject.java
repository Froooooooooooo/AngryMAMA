package gamepack;
import java.awt.Graphics;
import java.awt.Color;

public abstract class GameObject
{
    protected Game game;
    protected Handler handler;
    protected int x, y;
    protected float velX, velY;
    public GameObject(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public GameObject(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public void setX(int x) {
        this.x = x;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public Game getGame() {
        return game;
    }
    public Handler getHandler() {
        return handler;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }
    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }
}
