
public class River extends AdventureZone{
    public River(Player player){
        super(player, "River",5);
    }
    @Override
    public boolean onLocation(){
        System.out.println("River");
        return true;
    }
}
