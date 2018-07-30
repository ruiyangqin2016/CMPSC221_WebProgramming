package Exercise2_FormattingProblem;

public class YearException extends Exception {

    public YearException(){
        super("Invalid Year");
    }

    @Override
    public String getMessage(){
        return "Invalid Year";
    }
}
