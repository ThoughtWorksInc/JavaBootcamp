package bootcamp.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class PersonTests {
    private final Person bojo = new Person("Boris", "Johnson");
    private final Person alsoBojo = new Person("Boris", "Johnson");
    private final Person angie = new Person("Angela", "Merkel");
    private final Person abCd = new Person("ab", "cd");
    private final Person abcD = new Person("abc", "d");

    @Test
    public void samePersonIsSame() {
        assertThat(alsoBojo, is(equalTo(bojo)));
    }

    @Test
    public void differentPersonIsDifferent() {
        assertThat(bojo, is(not(equalTo(angie))));
    }

    @Test
    public void doesNotJustAddHashes() {
        assertThat(abCd.hashCode(), is(not(equalTo(abcD.hashCode()))));
    }
}