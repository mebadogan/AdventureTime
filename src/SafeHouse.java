public class SafeHouse extends SafeLocation{

    public SafeHouse(Player player){
        super(player, "Safehouse",1);
    }

    public boolean onLocation(){
        System.out.println("===== SAFE HOUSE =====");
        System.out.println("Character\'s health is fulfilled.");
        this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getStartHealth());
        return true;
    }
}
