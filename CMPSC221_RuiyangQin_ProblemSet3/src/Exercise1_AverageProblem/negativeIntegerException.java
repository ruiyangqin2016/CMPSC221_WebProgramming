package Exercise1_AverageProblem;

public class negativeIntegerException extends Exception {
    public negativeIntegerException(){
        super("N must be positive.");
    }
}
