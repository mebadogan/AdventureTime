import java.util.Scanner;
public class Player {
    private String playerName;
    private Characters character;
    private Location location;
    private Inventory inventory;
    private String currentLocation = "Safehouse";
    private boolean isPlayerAlive = true;
    public static Scanner input = new Scanner(System.in);

    Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void selectCharacter() {
        System.out.println("Characters: ");
        Characters[] characterList = {new Samurai(), new Janissary(), new Knight()};
        for (Characters character : characterList) {
            System.out.println("ID: " + character.getId() + " Character: " + character.getCharacterName() + " Damage: " + character.getDamage() + " Health: " + character.getHealth() + " Coin: " + character.getMoney());
        }
        System.out.println();
        System.out.println("Select a character.");
        int choose = input.nextInt();
        while (choose < 1 || choose > 3) {
            System.out.println("You can type 1, 2 or 3.");
            choose = input.nextInt();
        }
        switch (choose) {
            case 1, 2, 3 -> character = characterList[choose - 1];
            default -> System.out.println("!!!!!YOU MISTYPED!!!!!");
        }
        System.out.println("You have chosen the " + character.getCharacterName() + " with " + character.getHealth() + " health, " + character.getDamage() + " damage, " + character.getMoney() + " coin and ID: " + character.getId());
    }

    public void selectLocation() {
        if (!this.isPlayerAlive) {
            System.out.println("WASTED\nGAMEOVER");
            System.exit(0);
        }
        Location[] locationList = {new SafeHouse(this), new Market(this), new Forest(this), new Cave(this), new River(this), new Mine(this)};
        System.out.println();
        System.out.println("***** REGIONS *****");
        System.out.println("YOU ARE AT " + currentLocation + " SELECT A PLACE WHERE YOU WANT TO GO!");
        boolean diffPlaceInput = true;
        for (int i = 0; i < locationList.length; i++) {
            switch (i){
                case 0, 1 ->{
                    if (locationList[i].getPlaceName().equals(currentLocation)) {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
                    }else {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName());
                    }
                }
                case 2 ->{
                    if (locationList[i].getPlaceName().equals(currentLocation)) {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
                    }
                    else if(this.getInventory().isWood() && !(locationList[i].getPlaceName().equals(currentLocation))){
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName() + " XXX!* CLEARED *!XXX");
                    }
                    else{
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName());
                    }
                }
                case 3 ->{
                    if (locationList[i].getPlaceName().equals(currentLocation)) {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
                    }
                    else if(this.getInventory().isFood() && !(locationList[i].getPlaceName().equals(currentLocation))){
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName() + " XXX!* CLEARED *!XXX");
                    }
                    else {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName());
                    }
                }
                case 4 ->{
                    if (locationList[i].getPlaceName().equals(currentLocation)) {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
                    }
                    else if(this.getInventory().isWater() && !(locationList[i].getPlaceName().equals(currentLocation))){
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName() + " XXX!* CLEARED *!XXX");
                    }
                    else{
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName());
                    }
                }
                case 5 ->{
                    if (locationList[i].getPlaceName().equals(currentLocation)) {
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
                    }
                    else if(this.getInventory().isSpecialAward() && !(locationList[i].getPlaceName().equals(currentLocation))){
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName() + " XXX!* CLEARED *!XXX");
                    }
                    else{
                        System.out.println("ID: " + locationList[i].getId() + " Place: " + locationList[i].getPlaceName() + " Award: " + locationList[i].getAward().getAwardName());
                    }
                }
            }
        }
        System.out.println("Press \"0\" to end the game.");
        System.out.print("Selection: ");
        int choose = input.nextInt();
        while (choose < 0 || choose > 6) {
            System.out.println("You have to enter a number between 0 and 5. Try again!");
            choose = input.nextInt();
        }
        switch (choose) {
            case 0 -> {
                System.out.println("***** GAME OVER *****");
                System.exit(0);
            }
            case 1, 2 -> {
                if (currentLocation.equals(locationList[choose - 1].getPlaceName())) {
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = locationList[choose - 1];
            }
            case 3, 4, 5, 6 -> {
                if (currentLocation.equals(locationList[choose - 1].getPlaceName())) {
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                if ((locationList[choose - 1].getAward().getAwardName().equals("Special Awards") && this.getInventory().isSpecialAward()) || (locationList[choose - 1].getAward().getAwardName().equals("Water") && this.getInventory().isWater()) || (locationList[choose - 1].getAward().getAwardName().equals("Food") && this.getInventory().isFood()) || (locationList[choose - 1].getAward().getAwardName().equals("Wood") && this.getInventory().isWood())) {
                    System.out.println("YOU HAVE CLEARED THIS AREA AND GOT THE AWARD.");
                    diffPlaceInput = false;
                    break;
                }
                location = locationList[choose - 1];
            }
            default -> System.out.println("!!!!!YOU MISTYPED!!!!!");
        }
        if (diffPlaceInput) {
            this.isPlayerAlive = location.onLocation();
            currentLocation = this.location.getPlaceName();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String newName) {
        this.playerName = newName;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void printPlayerHUD() {
        System.out.println("===== PLAYER STATS =====");
        System.out.println("Health: " + this.getCharacter().getHealth());
        System.out.println("Attack Point: " + this.getCharacter().getDamage());
        System.out.println("Defence Point: " + this.getCharacter().getDefence());
        System.out.println("Coin: " + this.getCharacter().getMoney());
        System.out.println("Armor: " + this.getInventory().getArmor().getArmorName() + " with defence point " + this.getInventory().getArmor().getArmorDefence());
        System.out.println("Weapon: " + this.getInventory().getWeapon().getWeaponName() + " with attack point " + this.getInventory().getWeapon().getWeaponDamage());
        System.out.println("============*============");
    }
}