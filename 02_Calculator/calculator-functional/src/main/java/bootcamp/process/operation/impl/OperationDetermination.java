package bootcamp.process.operation.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import bootcamp.process.operation.ArithmeticOperation;
import static bootcamp.process.operation.impl.ArithmeticOperations.*;

public class OperationDetermination {
    public static Optional<ArithmeticOperation> determineOperation(final String operator) {
        final Map<String, ArithmeticOperation> operationMap = new HashMap<String, ArithmeticOperation>();
        operationMap.put("+", add);
        operationMap.put("-", subtract);
        operationMap.put("x", multiply);
        operationMap.put("/", divide);

        if (operationMap.containsKey(operator)) {
            return Optional.of(operationMap.get(operator));
        }

        return Optional.empty();
    }
}