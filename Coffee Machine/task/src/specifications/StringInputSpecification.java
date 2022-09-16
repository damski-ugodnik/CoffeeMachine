package specifications;

import java.util.List;

public record StringInputSpecification(String inputMessage, String invalidValueMessage, List<String> possibleValues) {
    @Override
    public String inputMessage() {
        return inputMessage;
    }

    @Override
    public String invalidValueMessage() {
        return invalidValueMessage;
    }

    public boolean fitsSpecification(String value){
        return possibleValues.stream().anyMatch(value::equals);
    }
}
