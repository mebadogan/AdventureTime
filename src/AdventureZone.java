public abstract class AdventureZone extends Location{
    public AdventureZone(Player player, String placeName, int id){
        super(player, placeName, id);
    }
    public boolean onLocation(){
        return true;
    }
}
