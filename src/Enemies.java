public abstract class Enemies {
    private int enemyID;
    private String enemyName;
    private int enemyDamage;
    private int enemyHealth;
    private int enemyCoin;

    public Enemies(int enemyID, String enemyName, int enemyDamage, int enemyHealth, int enemyCoin) {
        this.enemyID = enemyID;
        this.enemyName = enemyName;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
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
        this.enemyDamage = newEnemyDamage;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public void setEnemyHealth(int newEnemyHealth){
        this.enemyHealth = newEnemyHealth;
    }

    public int getEnemyCoin(){
        return enemyCoin;
    }

    public void setEnemyCoin(int newEnemyCoin){
        this.enemyCoin = newEnemyCoin;
    }

}
