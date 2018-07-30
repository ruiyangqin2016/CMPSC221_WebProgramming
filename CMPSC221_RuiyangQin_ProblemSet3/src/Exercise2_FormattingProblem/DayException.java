package Exercise2_FormattingProblem;

public class DayException extends Exception{

    public DayException(){
        super("Invalid Day");
    }

    @Override
    public String getMessage(){
        return "Invalid Day";
    }

}
