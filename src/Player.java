import java.util.Scanner;
public class Player {
    private String playerName;
    private Characters character;
    private Location location;
    private Inventory inventory;
    private String currentLocation = "Safehouse";
    public static Scanner input = new Scanner(System.in);
    Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }
    public void selectCharacter() {
        System.out.println("Characters: ");
        Characters[] characterList = {new Samurai(), new Janissary(), new Knight()};
        for(Characters character : characterList){
            System.out.println("ID: " + character.getId() + " Character: " + character.getCharacterName() + " Damage: " + character.getDamage() + " Health: " + character.getHealth() + " Coin: " + character.getMoney());
        }
        System.out.println();
        System.out.println("Select a character.");
        int choose = input.nextInt();
        while(!(choose==1 || choose==2 || choose==3)){
            System.out.println("You can type 1, 2 or 3.");
            choose = input.nextInt();
        }
        switch (choose) {
            case 1:
                character = characterList[choose -1];
                break;
            case 2:
                character = characterList[choose -1];
                break;
            case 3:
                character = characterList[choose -1];
                break;
            default:
                System.out.println("!!!!!YOU MISTYPED!!!!!");
        }
        System.out.println("You have chosen the " + character.getCharacterName() + " with " + character.getHealth() + " health, " + character.getDamage() + " damage, " + character.getMoney() + " coin and ID: " + character.getId());

    }
    public void selectLocation(){
        Location[] locationList = {new SafeHouse(this), new Market(this), new Forest(this), new Cave(this), new River(this)};
        System.out.println();
        System.out.println("***** REGIONS *****");
        System.out.println();
        printPlayerHUD();
        System.out.println();
        System.out.println("YOU ARE AT " + currentLocation + " SELECT A PLACE WHERE YOU WANT TO GO!");
        int[] locationIDs = new int[4];
        boolean diffPlaceInput = true;
        for(Location loc : locationList){
            if (loc.getPlaceName() == currentLocation){
                System.out.println("ID: " + loc.getId() + " Place: " + loc.getPlaceName() + " ***** YOU ARE CURRENTLY HERE! *****");
            }
            else if (loc.getPlaceName() != currentLocation){
                System.out.println("ID: " + loc.getId() + " Place: " + loc.getPlaceName());
            }
        }
        System.out.println("Press \"0\" to end the game.");
        System.out.print("Selection: ");
        int choose = input.nextInt();
        while(!(choose == 0 || choose==1 || choose==2 || choose==3 || choose==4 || choose==5)){
            choose = input.nextInt();
        }
        switch (choose) {
            case 0:
                System.out.println("***** GAME OVER *****");
                System.exit(0);
            case 1:
                if(currentLocation == "Safehouse"){
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = new SafeHouse(this);
                break;
            case 2:
                if(currentLocation == "Market"){
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = new Market(this);
                break;
            case 3:
                if(currentLocation == "Forest"){
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = new Forest(this);
                break;
            case 4:
                if(currentLocation == "Cave"){
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = new Cave(this);
                break;
            case 5:
                if(currentLocation == "River"){
                    System.out.println("!!!!! YOU ARE CURRENTLY HERE! SELECT ANOTHER PLACE !!!!!");
                    diffPlaceInput = false;
                    break;
                }
                location = new River(this);

            default:
                System.out.println("!!!!!YOU MISTYPED!!!!!");
        }
        if (diffPlaceInput == true){
            location.onLocation();
            currentLocation = this.location.getPlaceName();
            System.out.println("You are at " + currentLocation);
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

    public void printPlayerHUD(){
        System.out.println("===== PLAYER STATS =====");
        System.out.println("Health: " + this.getCharacter().getHealth());
        System.out.println("Attack Point: " + this.getCharacter().getDamage());
        System.out.println("Defence Point: " + this.getCharacter().getDefence());
        System.out.println("Coin: " + this.getCharacter().getMoney());
        System.out.println("Armor: " + this.getInventory().getArmor().getArmorName() + " with defence point " + this.getInventory().getArmor().getArmorDefence());
        System.out.println("Weapons: " + this.getInventory().getWeapon().getWeaponName() + " with attack point " + this.getInventory().getWeapon().getWeaponDamage());
        System.out.println("Water: " + this.getInventory().isWater());
        System.out.println("Food: " + this.getInventory().isFood());
        System.out.println("Firewood" + this.getInventory().isFirewood());
        System.out.println("============*============");
    }
}