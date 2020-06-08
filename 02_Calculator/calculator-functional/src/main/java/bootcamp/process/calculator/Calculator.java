package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import static bootcamp.process.operation.impl.OperationDetermination.*;
import static bootcamp.process.operation.impl.ResultCalculator.*;

public class Calculator {
    public Result calculate(final Params params) {
        final var operationLambda = determineOperation(params.operator);
        return calculateResult(operationLambda, params.x, params.y);
    }
}
