package mybeautyclock.server.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class JoshiTest extends AppEngineTestCase {

    private Joshi model = new Joshi();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
