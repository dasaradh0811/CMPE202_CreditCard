package cmpe202.validator;

public class Amex implements Validation {

    @Override
    public String validCard() {
        System.out.println("American Express");
        return "American Express";
    }
}
