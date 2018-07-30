package Two_MovieProblem;

public class Movie {

    protected String MPAAR;
    protected String IDNum;
    protected String MovieTitle;

    public String getMPAAR() {
        return MPAAR;
    }

    public void setMPAAR(String MPAAR) {
        this.MPAAR = MPAAR;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        MovieTitle = movieTitle;
    }

    public Movie(String MPAAR, String IDNum, String movieTitle) {

        this.MPAAR = MPAAR;
        this.IDNum = IDNum;
        MovieTitle = movieTitle;
    }

    public double lateFee(){
        return 2.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return IDNum == movie.IDNum;
    }
}
