package cmpe202.validator;

public class Visa implements Validation {
    @Override
    public String validCard() {
        System.out.println("Visa Card");
        return "visa Card";
    }
}
