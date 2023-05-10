public class SafeHouse extends SafeLocation{

    public SafeHouse(Player player){
        super(player, "Safehouse",1);
    }

    public boolean onLocation(){
        areUWinningSon();
        System.out.println("===== SAFE HOUSE =====");
        healing();
        return true;
    }

    public void areUWinningSon(){
        if(this.getPlayer().getInventory().isWood() && this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater()){
            System.out.println("CONGRATULATIONS! YOU HAVE JUST FINISHED THE ADVENTURE.\nSEE YOU SOON!");
            System.exit(0);
        }
    }

    public void healing(){
        if(this.getPlayer().getCharacter().getHealth() < this.getPlayer().getCharacter().getStartHealth()){
            System.out.println("Character\'s health is fulfilled.");
            this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getStartHealth());
        }
        else{
            System.out.println("...RESTING FOR EIGHT HOURS...");
        }
    }
}
