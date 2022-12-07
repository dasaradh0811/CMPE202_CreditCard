package cmpe202.validator;

public class Discover implements Validation {
    @Override
    public String validCard() {
        System.out.println("DiscoverCard");
        return "Discover Card";
    }
}
