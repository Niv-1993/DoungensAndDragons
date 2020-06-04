package DND.Players;

import DND.Enemies.Enemy;
import DND.MessageHandler;
import DND.Tiles.Tile;
import DND.Tiles.Unit;

public abstract class Player extends Unit {
    private int experience;
    private int level;
    private static final char PLAYER_TILE ='@';

    public Player(int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints) {
        super(PLAYER_TILE, x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints);
        experience = 0;
        level = 1;
    }



    public void LevelUp() {
        int currentLevel = getLevel();
        if (getExperience() == (50 * currentLevel)) {
            setExperience(getExperience() - (50 * currentLevel));
            setLevel(currentLevel + 1);
            currentLevel = getLevel();
            setHealthPool(getHealthPool() + (10 * currentLevel));
            setHealthAmount(getHealthPool());
            setAttackPoints(getAttackPoints() + (4 * currentLevel));
            setDefencePoints(getDefencePoints() + currentLevel);
            m.sendMessage(getName() + " leveled up to " +getLevel()+ " and gained "+getAttackPoints() + " attack points and "+getDefencePoints() + " defence points");
        }
    }

    public abstract String describe();
    public abstract void SpecialAbility();


    @Override
    public void interact(Tile tile) {
        tile.accept(this);
    }

    @Override
    public void visit(Player player) { //nothing happens
    }

    @Override
    public void visit(Enemy enemy) { //get in combat ---> if player wins then gets experience else endgame

    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }








    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    //VISITOR PATTERN

}
