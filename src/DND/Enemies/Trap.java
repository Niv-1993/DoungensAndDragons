package DND.Enemies;

import DND.Players.Player;
import DND.Tiles.Tile;
import DND.Tiles.Unit;

import java.awt.*;

public class Trap extends Enemy {
    private int visibilityTime;
    private int inVisibilityTime;
    private int ticksCount;
    private boolean visible;
    private final char tile;

    public Trap(char tile, int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int experienceValue, int visibilityTime, int inVisibilityTime) {
        super(tile, x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints, experienceValue);
        this.visibilityTime = visibilityTime;
        this.inVisibilityTime = inVisibilityTime;
        ticksCount = 0;
        visible = true;
        this.tile = tile;
    }


    @Override
    public void gameEnemyTick(Player player, Tile[][] board) {
        setVisible(getTicksCount() < getVisibilityTime());
        if (!isVisible())
            setTile('.');
        else setTile(tile);
        if (getTicksCount() == (getVisibilityTime() + getInVisibilityTime())) {
            setTicksCount(0);
        } else {
            setTicksCount(getTicksCount() + 1);
        }
        if (range(getPosition(), player.getPosition()) < 2)
            interact(player,board);
    }

    @Override
    public String describe() {
        return null;
    }

    public int getVisibilityTime() {
        return visibilityTime;
    }

    public void setVisibilityTime(int visibilityTime) {
        this.visibilityTime = visibilityTime;
    }

    public int getInVisibilityTime() {
        return inVisibilityTime;
    }

    public void setInVisibilityTime(int inVisibilityTime) {
        this.inVisibilityTime = inVisibilityTime;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public void setTicksCount(int ticksCount) {
        this.ticksCount = ticksCount;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
