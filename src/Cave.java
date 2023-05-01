public class Cave extends AdventureZone{
    public Cave(Player player){
        super(player, "Cave",4);
    }
    @Override
    public boolean onLocation(){
        System.out.println("Cave");
        return true;
    }
}
