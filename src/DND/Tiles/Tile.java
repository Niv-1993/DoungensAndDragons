package DND.Tiles;
import DND.MessageHandler;

import java.awt.*;

public abstract class Tile {
    protected MessageHandler m;
    private char tile;
    private Point position;

    public Tile(char tile, int x, int y){
        this.tile = tile;
        this.position = new Point(x, y);
    }
    public char getTile() {
        return tile;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public abstract void accept(Unit unit);

}
