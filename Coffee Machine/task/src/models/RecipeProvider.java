package models;


public enum RecipeProvider {
    ESPRESSO(1) {
        @Override
        public CoffeeRecipe getRecipe() {
            return new CoffeeRecipe(this.name().toLowerCase(), 250, 0, 16, 4);
        }
    },
    LATTE(2) {
        @Override
        public CoffeeRecipe getRecipe() {
            return new CoffeeRecipe(this.name().toLowerCase(), 350, 75, 20, 7);
        }
    },
    CAPPUCCINO(3) {
        @Override
        public CoffeeRecipe getRecipe() {
            return new CoffeeRecipe(this.name(), 200, 100, 12, 6);
        }
    };


    private final int number;

    public static String valuesToString() {
        StringBuilder str = new StringBuilder();
        for (RecipeProvider value : values()) {
            str.append(value.number).append(" - ").append(value.name().toLowerCase()).append(", ");
        }
        str.delete(str.length()-2, str.length()-1);
        str.trimToSize();
        return str.toString();
    }


    RecipeProvider(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static RecipeProvider fromNumber(int number) {
        for (RecipeProvider value : values()) {
            if (value.getNumber() == number) {
                return value;
            }
        }
        throw new IllegalArgumentException("Recipe by this number not found");
    }

    public abstract CoffeeRecipe getRecipe();
}
