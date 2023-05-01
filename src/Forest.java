
public class Forest extends AdventureZone{
    public Forest(Player player){
        super(player, "Forest",3);
    }
    @Override
    public boolean onLocation(){
        System.out.println("Forest");
        return true;
    }
}
