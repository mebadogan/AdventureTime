public abstract class Location {
    private Player player;
    private String placeName;
    private int id;

    private Awards award;

    private boolean isTheAwardTaken = false;



    public Location(Player player, String placeName, int id) {
        this.player = player;
        this.placeName = placeName;
        this.id = id;
        this.award = null;
    }

    public boolean onLocation(){
        return true;
    }
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getPlaceName(){
        return placeName;
    }

    public void setPlaceName(String newPlaceName){
        this.placeName = newPlaceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Awards getAward() {
        return award;
    }

    public void setAward(Awards award) {
        this.award = award;
    }

    public boolean isTheAwardTaken() {
        return isTheAwardTaken;
    }

    public void setTheAwardTaken(boolean theAwardTaken) {
        isTheAwardTaken = theAwardTaken;
    }
}
