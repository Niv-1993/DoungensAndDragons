package DND.Enemies;

import DND.Players.Player;
import DND.Tiles.Tile;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Monster extends Enemy {
    private int visionRange;

    public Monster(char tile, int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int experienceValue, int visionRange) {
        super(tile, x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints, experienceValue);
        this.visionRange = visionRange;
    }

    @Override
    public String describe() {
        return null;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    @Override
    public void gameEnemyTick(Player player, Tile[][] board) {
        if(range(getPosition(),player.getPosition()) < visionRange){
            int dy = getPosition().x - player.getPosition().x;
            int dx= getPosition().y - player.getPosition().y;
            if(Math.abs(dx) > Math.abs(dy)){
                if(dx > 0)
                    moveLeft(board);
                else moveRight(board);
            }
            else {
                if (dy > 0)
                     moveUp(board);
                else  moveDown(board);
            }
        }
        else  randomMovement(board);
    }

    private void randomMovement(Tile[][] board) {
        Random r = new Random();
        int i = r.nextInt(5);
        switch (i){
            case 1: moveUp(board); break;
            case 2: moveDown(board); break;
            case 3: moveLeft(board); break;
            case 4: moveRight(board); break;
            case 5: break;
        }
    }

}
