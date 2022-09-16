package specifications;

public record IntegerInputSpecification(String inputMessage, String invalidValueMessage, int maxValue, int minValue) {

    @Override
    public String inputMessage() {
        return inputMessage;
    }

    @Override
    public String invalidValueMessage() {
        return invalidValueMessage;
    }

    public boolean fitsSpecification(int value) {
        return value >= minValue && value <= maxValue;
    }
}
