import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    public void start() {
        //Beginning
        System.out.println("Welcome to the Adventure Time!");
        System.out.println("Please enter your name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hello " + player.getPlayerName() + " !");
        System.out.println("Collect food, wood and water to end the adventure.");

        player.selectCharacter(); //Select a character
        player.selectLocation(); //Select a location
    }

}
