package Two_MovieProblem;

public class Drama extends Movie {

    private int lateDays;

    public Drama(int lateDays, String MPAAR, String IDNum, String movieTitle){
        super(MPAAR, IDNum, movieTitle);
        this.lateDays=lateDays;
    }

    public int getLateDays(){
        return lateDays;
    }

    public void setLateDays(int lateDays){
        this.lateDays = lateDays;
    }

    @Override
    public double lateFee(){
       return lateDays*2.0;
    }
}
