package controllers.fillers.impl;

import controllers.fillers.ICoffeeMachineFiller;
import models.Machine;
import specifications.IntegerInputSpecification;
import utils.ConsoleReader;

public class CoffeeBeansFiller implements ICoffeeMachineFiller {
    private final IntegerInputSpecification specification = new IntegerInputSpecification(
            "Write how many grams of coffee beans you want to add:", "Invalid number",
            Integer.MAX_VALUE, 0);

    @Override
    public void fillSupply(Machine coffeeMachine) {
        int value = ConsoleReader.readInteger(specification);
        coffeeMachine.addCoffeeBeans(value);
    }
}
