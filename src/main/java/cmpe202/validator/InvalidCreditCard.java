package cmpe202.validator;

public class InvalidCreditCard implements Validation {
    @Override
    public String validCard() {
        System.out.println("invalid");
        return "Invalid Card Type";
    }
}
