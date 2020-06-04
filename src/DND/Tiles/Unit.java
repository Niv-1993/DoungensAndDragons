package DND.Tiles;
import DND.Enemies.Enemy;
import DND.Players.Player;

import java.awt.*;


public abstract class Unit extends Tile {
    private String name;
    private int healthPool;
    private   int healthAmount;
    private int attackPoints;
    private int defencePoints;

    public Unit(char tile, int x, int y, String unitName, int healthPool,int healthAmount, int attackPoints, int defencePoints) {
        super(tile, x, y);
        name = unitName;
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
    }
    public double range(Unit a, Unit b){
        return a.getPosition().distance(b.getPosition());
    }

    // moving functions
    public void moveDown(){
        getPosition().move((int)getPosition().getX(),((int)getPosition().getY()-1));
    }
    public void goUp(){
        getPosition().move((int)getPosition().getX(),((int)getPosition().getY()+1));
    }
    public void goLeft(){
        getPosition().move(((int)getPosition().getX()-1),(int)getPosition().getY());
    }
    public void goRight(){
        getPosition().move(((int)getPosition().getX()+1),(int)getPosition().getY());
    }


    //visitor pattern
    public abstract void interact(Tile tile);
    public abstract void visit(Enemy enemy);
    public abstract void visit(Player player);

    public void visit(Wall wall){ //nothing happen
    }
    public void visit(Empty empty){ //swap positions
        Point tmp = new Point(getPosition());
        empty.setPosition(this.getPosition());
        this.setPosition(tmp);
    }
    //-------



    @Override
    public String toString() {
        return String.valueOf(getTile());
    }











    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public int getHealthPool() {
        return healthPool;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefencePoints(int defencePoints) {
        this.defencePoints = defencePoints;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }

    public void setHealthPool(int healthPool) {
        this.healthPool = healthPool;
    }
}
