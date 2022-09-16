package controllers.processors;

import specifications.StringInputSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorFactory {
    private final StringInputSpecification specification;
    private final Map<String, ICoffeeMachineProcessor> processors;

    public ProcessorFactory(List<ICoffeeMachineProcessor> processorsList) {
        this.processors = processorsList.stream().collect(Collectors.toMap(ICoffeeMachineProcessor::getOperationTitle, Function.identity()));
        List<String> operationNames = new ArrayList<>();

        for (ICoffeeMachineProcessor coffeeMachineProcessor : processorsList) {
            operationNames.add(coffeeMachineProcessor.getOperationTitle());
        }

        this.specification = new StringInputSpecification(String.format("Write action (%s):",String.join(", ", operationNames)) , "Invalid operation", operationNames);
    }

    public ICoffeeMachineProcessor getProcessor(String operation) {
        ICoffeeMachineProcessor processor = processors.get(operation);
        if (processor == null) {
            throw new IllegalArgumentException("No such operation");
        }
        return processor;
    }

    public StringInputSpecification getSpecification() {
        return specification;
    }
}
