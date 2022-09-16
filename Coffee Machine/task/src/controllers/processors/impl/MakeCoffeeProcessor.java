package controllers.processors.impl;

import controllers.cookers.ICoffeeCooker;
import controllers.indicators.ICoffeeMachineIndicator;
import models.CoffeeRecipe;
import models.Machine;
import controllers.processors.ICoffeeMachineProcessor;
import models.RecipeProvider;
import utils.ConsoleReader;
import utils.Constants;

import java.util.List;

public class MakeCoffeeProcessor implements ICoffeeMachineProcessor {

    private final List<ICoffeeCooker> cookers;
    private final List<ICoffeeMachineIndicator> indicators;

    public MakeCoffeeProcessor(List<ICoffeeCooker> cookers, List<ICoffeeMachineIndicator> indicators) {
        this.cookers = cookers;
        this.indicators = indicators;
    }

    @Override
    public String getOperationTitle() {
        return "buy";
    }

    @Override
    public void execute(Machine coffeeMachine) {
        RecipeProvider coffee = RecipeProvider.fromNumber(ConsoleReader.readInteger(Constants.RECIPE_SPECIFICATION));
        CoffeeRecipe recipe = coffee.getRecipe();
        for (ICoffeeMachineIndicator indicator : indicators) {
            if(!indicator.isEnough(coffeeMachine,recipe)){
                System.out.printf("Sorry, not enough %s!\n", indicator.getSupplyName());
                return;
            }
        }
        System.out.println("I have enough resources, making you a coffee!");
        for (ICoffeeCooker cooker : cookers) {
           cooker.makeCoffee(coffeeMachine, recipe);
        }
    }
}
