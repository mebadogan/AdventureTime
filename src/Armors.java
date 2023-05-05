public class Armors {
    private int id;
    private String name;
    private int defence;
    private int armorCost;

    public Armors (int id, String name, int defence, int armorCost){
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.armorCost = armorCost;
    }

    public static Armors[] armors(){
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors(1, "Light Armor", 1, 15);
        armorList[1] = new Armors(2,"Average Armor", 3, 25);
        armorList[2] = new Armors(3,"Heavy Armor", 5, 40);
        return armorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getArmorCost() {
        return armorCost;
    }

    public void setArmorCost(int armorCost) {
        this.armorCost = armorCost;
    }
}
