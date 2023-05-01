public abstract class SafeLocation extends Location {
    public SafeLocation(Player player, String placeName, int id){
        super(player, placeName, id);
    }
    @Override
    public boolean onLocation(){
        return true;
    }
}
