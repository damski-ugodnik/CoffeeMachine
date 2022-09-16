package utils;

import specifications.IntegerInputSpecification;
import specifications.StringInputSpecification;

public class InputValidator {

    public static boolean validateInt(String input, IntegerInputSpecification specification) {
        try {
            return specification.fitsSpecification(Integer.parseInt(input));
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean validateString(String input, StringInputSpecification specification) {
        return specification.fitsSpecification(input);
    }
}
