package DND.Enemies;
import DND.Players.Player;
import DND.Tiles.Tile;
import DND.Tiles.Unit;



public abstract class Enemy extends Unit {

    private int experienceValue;

    public Enemy(char tile, int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int experienceValue) {
        super(tile, x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints);
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    @Override
    public void interact(Tile tile) {
        tile.accept(this);
    }

    @Override
    public void visit(Player player) { // //get in combat ---> if player wins then gets experience else endgame

    }

    @Override
    public void visit(Enemy enemy) { //nothing happens
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }



    public abstract void Turn();
    public abstract String describe();
    //VISITOR PATTERN


}
