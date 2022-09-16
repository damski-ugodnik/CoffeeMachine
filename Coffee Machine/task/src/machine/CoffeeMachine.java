package machine;

import controllers.cookers.ICoffeeCooker;
import controllers.cookers.impl.*;
import controllers.fillers.ICoffeeMachineFiller;
import controllers.fillers.impl.CoffeeBeansFiller;
import controllers.fillers.impl.CupsFiller;
import controllers.fillers.impl.MilkFiller;
import controllers.fillers.impl.WaterFiller;
import controllers.indicators.ICoffeeMachineIndicator;
import controllers.indicators.impl.CoffeeBeansIndicator;
import controllers.indicators.impl.CupsIndicator;
import controllers.indicators.impl.MilkIndicator;
import controllers.indicators.impl.WaterIndicator;
import controllers.processors.ICoffeeMachineProcessor;
import controllers.processors.ProcessorFactory;
import controllers.processors.impl.*;
import models.Machine;

import java.util.LinkedList;
import java.util.List;


public class CoffeeMachine {


    public static void main(String[] args) {
        List<ICoffeeMachineFiller> fillers = new LinkedList<>(){{
            add(new WaterFiller());
            add(new MilkFiller());
            add(new CoffeeBeansFiller());
            add(new CupsFiller());
        }};
        List<ICoffeeCooker> cookers = new LinkedList<>(){{
            add(new WaterTaker());
            add(new MilkTaker());
            add(new CoffeeBeansTaker());
            add(new CupsTaker());
            add(new MoneyTaker());
        }};
        List<ICoffeeMachineIndicator> indicators = new LinkedList<>(){{
            add(new WaterIndicator());
            add(new MilkIndicator());
            add(new CoffeeBeansIndicator());
            add(new CupsIndicator());
        }};
        List<ICoffeeMachineProcessor> processors = new LinkedList<>(){{
            add(new FillMachineProcessor(fillers));
            add(new BuyCoffeeProcessor(cookers, indicators));
            add(new TakeMoneyProcessor());
            add(new RemainderProcessor());
            add(new ExitProcessor());
        }};
        ProcessorFactory factory = new ProcessorFactory(processors);
        Machine coffeeMachine = new Machine();
        Application app = new Application(factory, coffeeMachine);
        app.run();
    }
}




