package DND.Tiles;

import java.awt.*;

public class Empty extends Tile {
    private static final char EMPTY_TILE ='.';
    private Point position;
    public Empty(int x, int y) {
        super(EMPTY_TILE,x, y);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    @Override
    public String toString() {
        return String.valueOf(EMPTY_TILE);
    }
}