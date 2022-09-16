package utils;

import models.RecipeProvider;
import specifications.IntegerInputSpecification;

public class Constants {

    public static final IntegerInputSpecification RECIPE_SPECIFICATION =
            new IntegerInputSpecification("What do you want to buy? " + RecipeProvider.valuesToString() + ":",
                    "No such recipe", RecipeProvider.values().length, 1);

}
