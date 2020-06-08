package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.function.BiFunction;

public class Calculator {

    private final HashMap<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> operatorList = getOperatorList();

    public BigDecimal calculate(final Params params) {

        String operator = params.getOperator();
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();

        BiFunction<BigDecimal, BigDecimal, BigDecimal> getOperationFromList = operatorList.get(operator);

        if (getOperationFromList == null) throw new IllegalArgumentException("Operator must be: '+', '-', '/' or 'x'");

        return getOperationFromList
                .apply(x, y)
                .setScale(2, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

    private HashMap<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> getOperatorList() {

        HashMap<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> validOperatorList = new HashMap<>();

        validOperatorList.put("+", BigDecimal::add);
        validOperatorList.put("-", BigDecimal::subtract);
        validOperatorList.put("x", BigDecimal::multiply);
        validOperatorList.put("/", BigDecimal::divide);

        return validOperatorList;

    }

}
