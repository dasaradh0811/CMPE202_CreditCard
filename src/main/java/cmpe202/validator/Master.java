package cmpe202.validator;

public class Master implements Validation {
    @Override
    public String validCard() {
        System.out.println("MasterCard");
        return "Master Card";
    }
}
