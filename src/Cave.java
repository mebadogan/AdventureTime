public class Cave extends AdventureZone {
    public Cave(Player player) {
        super(player, "Cave", 4, new Zombie(), new Awards("Food", false), 3);
    }

}