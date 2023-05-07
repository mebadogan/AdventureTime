
public class Weapons{
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
    public static Weapons weaponList [] = {new Weapons(1, "Pistol", 2, 25), new Weapons(2, "Sword", 3, 35), new Weapons(3, "Rifle", 7, 45)};

    public static Weapons getTheWeapon(int weaponID){
        return weaponList[weaponID];
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
