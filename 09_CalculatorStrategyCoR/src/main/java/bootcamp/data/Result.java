package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final Optional<BigDecimal> value;

    public Result(Status status, Optional<BigDecimal> value) {
        this.status = status;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public Optional<BigDecimal> getValue() {
        return value;
    }

    public String getMessage(){
        return status.getMessage();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Result r = (Result) obj;
        return status.equals(r.status) && value.equals(r.value);
    }

    @Override
    public String toString() {
        if(value.isEmpty()){
            return "";
        }
        return " = " + value.get();
    }
}
