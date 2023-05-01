public abstract class Weapons {
    private int weaponID;
    private String weaponName;
    private int weaponDamage;
    private int weaponCost;

    public Weapons(int weaponID, String weaponName, int weaponDamage, int weaponCost){
        this.weaponID = weaponID;
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponCost = weaponCost;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(int weaponCost) {
        this.weaponCost = weaponCost;
    }
}
