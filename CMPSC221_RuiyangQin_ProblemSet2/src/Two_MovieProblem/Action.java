package Two_MovieProblem;

public class Action extends Movie {

    private int lateDays;

    public Action(int lateDays,String MPAAR,String IDNum, String MovieTitle){
        super(MPAAR,IDNum,MovieTitle);
        this.lateDays = lateDays;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    @Override
    public double lateFee(){
        return lateDays*3.0;
    }
}
