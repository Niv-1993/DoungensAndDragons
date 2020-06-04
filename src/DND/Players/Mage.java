package DND.Players;

import DND.MessageHandler;

public class Mage extends Player {
    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitCounts;
    private int abilityRange;
    private final String SPECIAL_ABILITY = "Blizzard";


    public Mage(int x, int y, String unitName, int healthPool, int healthAmount, int attackPoints, int defencePoints, int manaPool, int spellPower, int hitCounts, int abilityRange) {
        super(x, y, unitName, healthPool, healthAmount, attackPoints, defencePoints);
        this.manaPool = manaPool;
        currentMana = manaPool / 4;
        this.spellPower = spellPower;
        this.hitCounts = hitCounts;
        this.abilityRange = abilityRange;
    }

    public void LevelUp() {
        super.LevelUp();
        setManaPool(getManaPool() + (25 * getLevel()));
        setCurrentMana(Math.min(getCurrentMana() + (getManaPool() / 4), getManaPool()));
        setSpellPower(getSpellPower() + (10 * getLevel()));

    }

    @Override
    public String describe() {
        return null;
    }

    @Override
    public void SpecialAbility() {

    }

    public int getManaPool() {
        return manaPool;
    }

    public void setManaPool(int manaPool) {
        this.manaPool = manaPool;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getHitCounts() {
        return hitCounts;
    }

    public void setHitCounts(int hitCounts) {
        this.hitCounts = hitCounts;
    }

    public int getAbilityRange() {
        return abilityRange;
    }

    public void setAbilityRange(int abilityRange) {
        this.abilityRange = abilityRange;
    }

}
