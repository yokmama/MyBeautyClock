package mybeautyclock.server.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DanshiTest extends AppEngineTestCase {

    private Danshi model = new Danshi();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
