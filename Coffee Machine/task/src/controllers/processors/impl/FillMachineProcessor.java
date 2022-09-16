package controllers.processors.impl;

import controllers.fillers.ICoffeeMachineFiller;
import models.Machine;
import controllers.processors.ICoffeeMachineProcessor;

import java.util.List;

public class FillMachineProcessor implements ICoffeeMachineProcessor {
    private final List<ICoffeeMachineFiller> fillers;

    public FillMachineProcessor(List<ICoffeeMachineFiller> fillers) {
        this.fillers = fillers;
    }

    @Override
    public String getOperationTitle() {
        return "fill";
    }

    @Override
    public void execute(Machine coffeeMachine) {
        for (ICoffeeMachineFiller filler : fillers) {
            filler.fillSupply(coffeeMachine);
        }
    }
}
