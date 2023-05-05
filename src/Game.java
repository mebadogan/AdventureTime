public class Game {
    public boolean gameOn;
    public void start() {
        //Beginning
        System.out.println("Welcome to the Adventure Time!");
        System.out.println("Please enter your name: ");
        String playerName = Player.input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hello " + player.getPlayerName() + " !");
        System.out.println("Collect food, wood and water to end the adventure.");

        player.selectCharacter(); //Select a character
        gameOn = true;
        while(gameOn == true){
            player.selectLocation(); //Select a location
        }
    }

}
