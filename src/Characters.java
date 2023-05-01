public abstract class Characters {
    private int id;
    private String characterName;
    private int health;
    private int startHealth;
    private int damage;
    private int money;

    public Characters(int id, String characterName, int health, int damage, int money){
        this.id = id;
        this.characterName = characterName;
        this.health = health;
        this.damage = damage;
        this.money = money;
        this.startHealth = health;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public String getCharacterName(){
        return this.characterName;
    }

    public void setCharacterName(String newCharacterName){
        this.characterName = newCharacterName;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public int getStartHealth(){
        return this.startHealth;
    }

    public void setStartHealth(int newStartHealth){
        this.startHealth = newStartHealth;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int newDamage){
        this.damage = newDamage;
    }

    public int getMoney(){
        return this.money;
    }

    public void setMoney(int newMoney){
        this.money = newMoney;
    }

}
