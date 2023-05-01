
public class Market extends SafeLocation{
    public Market(Player player){
        super(player,"Market",2);
    }

    @Override
    public boolean onLocation(){
        System.out.println(this.getPlaceName());
        return true;
    }
}
