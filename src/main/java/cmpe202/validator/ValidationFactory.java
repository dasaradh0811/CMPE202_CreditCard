package cmpe202.validator;

public class ValidationFactory {
    public Validation checkCard(String str){
        if(str.isEmpty() || !str.matches("^[0-9]*$") )
            return new InvalidCreditCard();

        if(str.charAt(0) == '3' && (str.charAt(1) == '4' || str.charAt(1) == '7') && str.length() == 15){
            return new Amex();
        } else if (str.charAt(0) == '4' && (str.length() == 13 || str.length() == 16)) {
            return new Visa();
        } else if (str.charAt(0) == '5' && (str.charAt(1) >= '1' && str.charAt(1) <= '5') && str.length() == 16) {
            return new Master();
        }
        else if (str.substring(0,4).equals("6011") && str.length() == 16){
            return new Discover();
        }
        else
            return new InvalidCreditCard();
    }
}
