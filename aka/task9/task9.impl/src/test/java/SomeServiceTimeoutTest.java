import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;

/**
 * Created by TheFallen on 3/6/16.
 */
public class SomeServiceTimeoutTest {

    SomeService someService;

    @Before
    public void getSomeTest() {
        someService = new SomeServiceImpl();
    }

    @Test(timeout = 1000)
    public void testGetSomeText() {
        assertFalse(someService.getSomeText().isEmpty());
    }


}
