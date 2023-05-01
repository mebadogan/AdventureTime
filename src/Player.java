import java.util.Scanner;

public class Player {
    private String playerName;
    private Characters character;
    private Location location;
    Scanner input = new Scanner(System.in);
    Player(String playerName) {
        this.playerName = playerName;
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
        System.out.println("Select a place where you want to go.");
        for(Location loc : locationList){
            System.out.println("ID: " + loc.getId() + " Place: " + loc.getPlaceName());
        }
        System.out.println("Press \"0\" to end the game.");
        System.out.print("Selection: ");
        int choose = input.nextInt();
        while(!(choose == 0 || choose==1 || choose==2 || choose==3 || choose==4 || choose==5)){
            choose = input.nextInt();
        }
        switch (choose) {
            case 0:
                System.out.println("*****GAME OVER*****");
                System.exit(0);
            case 1:
                location = new SafeHouse(this);
                break;
            case 2:
                location = new Market(this);
                break;
            case 3:
                location = new Forest(this);
                break;
            case 4:
                location = new Cave(this);
                break;
            case 5:
                location = new River(this);

            default:
                System.out.println("!!!!!YOU MISTYPED!!!!!");
        }
        location.onLocation();
        System.out.println("You are at " + this.location.getPlaceName());
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
}