public class Armors {
    private int armorID;
    private String armorName;
    private int armorDefence;
    private int armorCost;

    public Armors (int armorID, String armorName, int armorDefence, int armorCost){
        this.armorID = armorID;
        this.armorName = armorName;
        this.armorDefence = armorDefence;
        this.armorCost = armorCost;
    }

    public static Armors[] armors = {new Armors(1, "Light Armor", 1, 15), new Armors(2,"Average Armor", 3, 25), new Armors(3,"Heavy Armor", 5, 40)};

    public static Armors getTheArmor(int armorID){
        return armors[armorID];
    }
    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getArmorCost() {
        return armorCost;
    }

    public void setArmorCost(int armorCost) {
        this.armorCost = armorCost;
    }
}
