public class Inventory {
    private Weapons weapon;
    private Armors armor;

    private boolean water = false;
    private boolean food = false;
    private boolean wood = false;

    private boolean specialAward = false;
    public Inventory(){
        this.weapon = new Weapons(0,"Shitty Spear", 0, 0);
        this.armor = new Armors(0, "Shitty Shield", 0, 0);
    }

    public Weapons getWeapon(){
        return this.weapon;
    }

    public void setWeapon(Weapons newWeapon){
        this.weapon = newWeapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isSpecialAward() {
        return specialAward;
    }

    public void setSpecialAward(boolean specialAward) {
        this.specialAward = specialAward;
    }
}
