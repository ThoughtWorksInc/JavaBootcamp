package bootcamp.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SummaryTests {
    static Summary summary = new Summary(new double[] { 1.2, 2.4, 8.6 });
    static Summary emptyArraySummary = new Summary(new double[0]);
    static Summary singleValueArraySummary = new Summary(new double[] { 3.0 });

    @Nested
    class Minimum {
        @Test
        public void hasMinimumValue() {
            assertThat(summary.min, is(1.2));
        }

        @Test
        public void isNanWhenInputIsEmpty() {
            assertThat(emptyArraySummary.min, is(Double.NaN));
        }

        @Test
        public void hasMinimumEvenWhenArrayOnlyHasOneValue() {
            assertThat(singleValueArraySummary.min, is(3.0));
        }
    }

    @Nested
    class Maximum {
        @Test
        public void hasMaximumValue() {
            assertThat(summary.max, is(8.6));
        }

        @Test
        public void isNanWhenInputIsEmpty() {
            assertThat(emptyArraySummary.max, is(Double.NaN));
        }

        @Test
        public void hasMaximumEvenWhenArrayOnlyHasOneValue() {
            assertThat(singleValueArraySummary.max, is(3.0));
        }
    }

    @Nested
    class Sum {
        @Test
        public void hasSum() {
            assertThat(summary.sum, is(12.2));
        }

        public void hasZeroSumWhenArrayIsEmpty() {
            assertThat(emptyArraySummary.sum, is(0.0));
        }
    }

    @Nested
    class Count {
        @Test
        public void hasCount() {
            assertThat(summary.count, is(3.0));
        }

        public void hasZeroCountWhenArrayIsEmpty() {
            assertThat(emptyArraySummary.count, is(0.0));
        }
    }

    @Nested
    class Average {
        @Test
        public void hasAverage() {
            assertThat(summary.average, is(closeTo(4.06666666667, 0.00001)));
        }

        @Test
        public void isNanWhenInputArrayIsEmpty() {
            assertThat(emptyArraySummary.average, is(Double.NaN));
        }

        @Test
        public void canCalculateAverageFromSingleValue() {
            assertThat(singleValueArraySummary.average, is(3.0));
        }
    }
}
