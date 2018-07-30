package Exercise2_FormattingProblem;

public class MonthException extends Exception {

    public MonthException(){
        super("Invalid Month");
    }

    @Override
    public String getMessage(){
        return "Invalid Month";
    }
}
