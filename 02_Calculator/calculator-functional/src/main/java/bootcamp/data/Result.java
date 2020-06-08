package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    public final Status status;
    public final String statusMessage;
    public final Optional<BigDecimal> value;

    public Result(final Optional<BigDecimal> value, final Status status, final String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = value;
    }
}
