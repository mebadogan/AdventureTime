import java.util.Random;

public abstract class AdventureZone extends Location{
    private Enemies enemy;
    private Awards award;
    private int maxEnemyCount;
    private int enemyDamage ;

    public AdventureZone(Player player, String placeName, int id, Enemies enemy, Awards award, int maxEnemyCount){
        super(player, placeName, id);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemyCount = maxEnemyCount;
        this.enemyDamage = this.getEnemy().getEnemyDamage() - this.getPlayer().getCharacter().getDefence();
    }
    public boolean onLocation(){
        enemyDamage = Math.max(enemyDamage, 0);
        System.out.println("You are at " + this.getPlaceName());
        System.out.println("There is a reward that awaits you. It is " + this.getAward().getAwardName());
        System.out.println("(C)ontinue or (G)o back");
        String fightOrRun = Player.input.next();
        if(fightOrRun.equalsIgnoreCase("C") && combat(randomEnemyCount())){
            System.out.println("You have just conquered " + this.getPlaceName() + ". You also got that award: " + this.getAward().getAwardName());
            switch (this.getAward().getAwardName()) {
                case "Water" -> this.getPlayer().getInventory().setWater(true);
                case "Wood" -> this.getPlayer().getInventory().setWood(true);
                case "Food" -> this.getPlayer().getInventory().setFood(true);
            }
            return true;
        }
        else if(this.getPlayer().getCharacter().getHealth() <= 0){
            System.out.println("You Died.");
            return false;
        }
        else {
            System.out.println("You ran away!");
            return true;
        }
    }

    public Enemies getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemies enemy) {
        this.enemy = enemy;
    }

    public Awards getAward() {
        return award;
    }

    public void setAward(Awards award) {
        this.award = award;
    }

    public int getMaxEnemyCount() {
        return maxEnemyCount;
    }

    public void setMaxEnemyCount(int maxEnemyCount) {
        this.maxEnemyCount = maxEnemyCount;
    }
    public int randomEnemyCount(){
        Random rand = new Random();
        return rand.nextInt(this.maxEnemyCount) + 1;
    }

    public boolean combat(int enemyCount){
        System.out.println(enemyCount + " of " + this.getEnemy().getEnemyName() + " live(s) here.");
        for(int i = 1; i <= enemyCount; i++){
            System.out.println("This is the " + (i) + ". " + this.getEnemy().getEnemyName());
            this.getEnemy().setEnemyHealth(this.getEnemy().getDefaultEnemyHealth());
            if(enemyCount % 2 == 0){
                System.out.println(this.getEnemy().getEnemyName() + " has attacked first!");
                this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - this.enemyDamage);
                System.out.println("Your Health: " + this.getPlayer().getCharacter().getHealth() + "\t" + "Enemy Health: " + this.getEnemy().getEnemyHealth());
            }
            while((this.getPlayer().getCharacter().getHealth() > 0) && (this.getEnemy().getEnemyHealth() > 0)){
                System.out.println("(H)it || (R)un");
                String fightOrRun = Player.input.next();
                if(fightOrRun.equalsIgnoreCase("R")) {
                    System.out.println("You ran away!");
                    return false;
                }
                System.out.println("You hit the enemy");
                this.getEnemy().setEnemyHealth(this.getEnemy().getEnemyHealth() - this.getPlayer().getCharacter().getDamage());
                System.out.println("Your Health: " + this.getPlayer().getCharacter().getHealth() + "\t" + "Enemy Health: " + this.getEnemy().getEnemyHealth());
                if(this.getEnemy().getEnemyHealth() <= 0){
                    System.out.println("You killed an enemy. You got " + this.getEnemy().getEnemyCoin() + " coins.");
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + this.getEnemy().getEnemyCoin());
                    System.out.println("Your total coin: " + this.getPlayer().getCharacter().getMoney());
                    break;
                }
                System.out.println("An enemy hit you.");
                this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - this.enemyDamage);
                System.out.println("Your Health: " + this.getPlayer().getCharacter().getHealth() + "\t" + "Enemy Health: " + this.getEnemy().getEnemyHealth());
                if(this.getPlayer().getCharacter().getHealth() <= 0){
                    break;
                }
            }
            if(this.getPlayer().getCharacter().getHealth() <= 0){
                return false;
            }
        }
        return  true;
    }

}
