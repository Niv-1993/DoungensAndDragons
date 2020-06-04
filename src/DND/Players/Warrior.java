package DND.Players;

import DND.Tiles.Unit;

public class Warrior extends Player {
    private int AbilityCoolDown;
    private int RemainingCoolDown;
    private final String SPECIAL_ABILITY= "Avenger’s Shield";

    public Warrior(int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int AbilityCoolDown) {
        super(x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints);
        this.AbilityCoolDown = AbilityCoolDown;
        RemainingCoolDown = 0;
    }


    @Override
    public void SpecialAbility() {

    }
    public void LevelUp(){
        super.LevelUp();
        setRemainingCoolDown(0);
        setHealthPool(getHealthPool()+ (5*getLevel()));
        setAttackPoints(getAttackPoints()+(2*getLevel()));
        setDefencePoints(getDefencePoints()+(getLevel()));
    }

    @Override
    public String describe() {
        return null;
    }

    public int getAbilityCoolDown() {
        return AbilityCoolDown;
    }

    public void setAbilityCoolDown(int abilityCoolDown) {
        AbilityCoolDown = abilityCoolDown;
    }

    public int getRemainingCoolDown() {
        return RemainingCoolDown;
    }

    public void setRemainingCoolDown(int remainingCoolDown) {
        RemainingCoolDown = remainingCoolDown;
    }

}
