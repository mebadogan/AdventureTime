public class Awards  {
    private String awardName;

    private boolean isItTaken;

    public Awards(String awardName, boolean isItTaken){
        this.awardName = awardName;
        this.isItTaken = false;
    }
    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public boolean isItTaken() {
        return isItTaken;
    }

    public void setItTaken(boolean itTaken) {
        isItTaken = itTaken;
    }
}
