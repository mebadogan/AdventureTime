import java.util.Random;
public abstract class AdventureZone extends Location{
    private Enemies enemy;
    private Awards award;
    private int maxEnemyCount;
    private int enemyDamage ;


    private Random rand = new Random();
    private int snakeDamage = rand.nextInt(4) + 3;

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
                case "Special Awards" -> this.getPlayer().getInventory().setSpecialAward(true);
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
            if(this.getEnemy().getEnemyName().equals("Snake")){
                snakeDamage = rand.nextInt(4) + 3;
                this.getEnemy().setEnemyDamage(snakeDamage);
                enemyDamage = this.getEnemy().getEnemyDamage() - this.getPlayer().getCharacter().getDefence();
            }
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
                    if(this.getEnemy().getEnemyName().equals("Snake")){
                        System.out.println("You have just killed a snake!");
                        getSnakeAward();
                    }
                    else {
                        System.out.println("You killed an enemy. You got " + this.getEnemy().getEnemyCoin() + " coins.");
                        this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + this.getEnemy().getEnemyCoin());
                        System.out.println("Your total coin: " + this.getPlayer().getCharacter().getMoney());
                    }
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

    public int getSnakeDamage(){
        this.snakeDamage = rand.nextInt(4) + 3;;
        return this.snakeDamage;
    }

    public void getSnakeAward(){
        int thingOrNothing = rand.nextInt(100) + 1;
        int whichAward = rand.nextInt(100) + 1;

        if(thingOrNothing >= 1 && thingOrNothing <= 55){
            if(thingOrNothing >= 1 && thingOrNothing <= 15){
                System.out.println("This snake had a weapon for you.");
                if(whichAward >= 1 && whichAward <= 50){
                    System.out.println("This snake had a pistol for you.");
                    Weapons snakeWeapon = new Weapons(1, "Pistol", 2, 0);
                    if(this.getPlayer().getInventory().getWeapon().getWeaponDamage() < snakeWeapon.getWeaponDamage()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() - this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        this.getPlayer().getInventory().setWeapon(snakeWeapon);
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                    }
                    else{
                        System.out.println("This weapon is less powerful than yours. Not worthy.");
                    }
                }
                else if(whichAward >= 51 && whichAward <= 80){
                    System.out.println("This snake had a sword for you.");
                    Weapons snakeWeapon = new Weapons(2, "Sword", 3, 0);
                    if(this.getPlayer().getInventory().getWeapon().getWeaponDamage() < snakeWeapon.getWeaponDamage()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() - this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        this.getPlayer().getInventory().setWeapon(snakeWeapon);
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                    }
                    else{
                        System.out.println("This weapon is less powerful than yours. Not worthy.");
                    }
                }
                else if (whichAward >= 81 && whichAward <= 100) {
                    System.out.println("This snake had a rifle for you.");
                    Weapons snakeWeapon = new Weapons(3, "Rifle", 7, 0);
                    if(this.getPlayer().getInventory().getWeapon().getWeaponDamage() < snakeWeapon.getWeaponDamage()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() - this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        this.getPlayer().getInventory().setWeapon(snakeWeapon);
                        this.getPlayer().getCharacter().setDamage(this.getPlayer().getCharacter().getDamage() + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                    }
                    else{
                        System.out.println("This weapon is less powerful than yours. Not worthy.");
                    }
                }
            }
            else if(thingOrNothing >= 16 && thingOrNothing <= 30){
                System.out.println("This snake had a armor for you.");

                if(whichAward >= 1 && whichAward <= 50){
                    System.out.println("This snake had a light armor for you.");
                    Armors snakeArmor = new Armors(1, "Light Armor", 1, 0);
                    if(this.getPlayer().getInventory().getArmor().getArmorDefence() < snakeArmor.getArmorDefence()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getArmor().getArmorName());
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() - this.getPlayer().getInventory().getArmor().getArmorDefence());
                        this.getPlayer().getInventory().setArmor(snakeArmor);
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() + this.getPlayer().getInventory().getArmor().getArmorDefence());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getArmor().getArmorDefence());
                    }
                    else{
                        System.out.println("This armor is less powerful than yours. Not worthy.");
                    }
                }
                else if(whichAward >= 51 && whichAward <= 80){
                    System.out.println("This snake had a moderate armor for you.");
                    Armors snakeArmor = new Armors(2,"Average Armor", 3, 0);
                    if(this.getPlayer().getInventory().getArmor().getArmorDefence() < snakeArmor.getArmorDefence()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getArmor().getArmorName());
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() - this.getPlayer().getInventory().getArmor().getArmorDefence());
                        this.getPlayer().getInventory().setArmor(snakeArmor);
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() + this.getPlayer().getInventory().getArmor().getArmorDefence());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getArmor().getArmorDefence());
                    }
                    else{
                        System.out.println("This armor is less powerful than yours. Not worthy.");
                    }
                }
                else if (whichAward >= 81 && whichAward <= 100) {
                    System.out.println("This snake had a heavy armor for you.");
                    Armors snakeArmor = new Armors(3,"Heavy Armor", 5, 0);
                    if(this.getPlayer().getInventory().getArmor().getArmorDefence() < snakeArmor.getArmorDefence()){
                        System.out.println("You dropped the " + this.getPlayer().getInventory().getArmor().getArmorName());
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() - this.getPlayer().getInventory().getArmor().getArmorDefence());
                        this.getPlayer().getInventory().setArmor(snakeArmor);
                        this.getPlayer().getCharacter().setDefence(this.getPlayer().getCharacter().getDefence() + this.getPlayer().getInventory().getArmor().getArmorDefence());
                        System.out.println("Your damage point increased by " + this.getPlayer().getInventory().getArmor().getArmorDefence());
                    }
                    else{
                        System.out.println("This armor is less powerful than yours. Not worthy.");
                    }
                }
            }
            else if (thingOrNothing >= 31 && thingOrNothing <= 55) {
                System.out.println("This snake had a few coins for you.");
                if(whichAward >= 1 && whichAward <= 50){
                    System.out.println("This snake had 10 coins for you.");
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 10);
                }
                else if(whichAward >= 51 && whichAward <= 80){
                    System.out.println("This snake had 5 coins for you.");
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 5);
                }
                else if (whichAward >= 81 && whichAward <= 100) {
                    System.out.println("This snake had 1 coin for you.");
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 1);
                }
            }
        }
        else{
            System.out.println("This snake had nothing for you.");
        }
    }

}
