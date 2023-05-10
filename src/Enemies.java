public abstract class Enemies {
    private int enemyID;
    private String enemyName;
    private int enemyDamage;
    private int enemyHealth;

    private int defaultEnemyHealth;
    private int enemyCoin;

    public Enemies(int enemyID, String enemyName, int enemyDamage, int enemyHealth, int enemyCoin) {
        this.enemyID = enemyID;
        this.enemyName = enemyName;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
        this.defaultEnemyHealth = enemyHealth;
        this.enemyCoin = enemyCoin;
    }

    public int getEnemyID(){
        return enemyID;
    }

    public void setEnemyID(int newEnemyID){
        this.enemyID = newEnemyID;
    }

    public String getEnemyName(){
        return enemyName;
    }

    public void setEnemyName(String newEnemyName){
        this.enemyName = newEnemyName;
    }

    public int getEnemyDamage(){
        return enemyDamage;
    }

    public void setEnemyDamage(int newEnemyDamage){
        if(newEnemyDamage <= 0){
            this.enemyDamage = newEnemyDamage;
        }
        else {
            this.enemyDamage = newEnemyDamage;
        }
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public void setEnemyHealth(int newEnemyHealth){
        if(newEnemyHealth <= 0){
            this.enemyHealth = 0;
        }
        else {
            this.enemyHealth = newEnemyHealth;
        }
    }

    public int getDefaultEnemyHealth() {
        return defaultEnemyHealth;
    }

    public void setDefaultEnemyHealth(int defaultEnemyHealth) {
        this.defaultEnemyHealth = defaultEnemyHealth;
    }

    public int getEnemyCoin(){
        return enemyCoin;
    }

    public void setEnemyCoin(int newEnemyCoin){
        this.enemyCoin = newEnemyCoin;
    }

}
