package DND.Players;

public class Rogue extends Player {
    private int cost;
    private int currentEnergy;
    private final String SPECIAL_ABILITY = "Fan of Knives";
    private final int MAX_ENERGY = 100;

    public Rogue(int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int cost) {
        super(x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints);
        this.cost = cost;
        currentEnergy = MAX_ENERGY;
    }

    public void LevelUp() {
        super.LevelUp();
        setCurrentEnergy(100);
        setAttackPoints(getAttackPoints() + (3 * getLevel()));
    }

    @Override
    public String describe() {
        return null;
    }


    @Override
    public void SpecialAbility() {

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }
}
