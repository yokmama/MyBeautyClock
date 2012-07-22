package mybeautyclock.server.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class KawaiiServiceTest extends AppEngineTestCase {

    private KawaiiService service = new KawaiiService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
