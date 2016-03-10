
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by TheFallen on 3/6/16.
 */
public class SomeServiceStandardTest {

    SomeService someService;

    @Before
    public void getSomeTest() {
        someService = new SomeServiceImpl();
    }

    @Test
    public void testGetSomeText() {
        assertFalse(someService.getSomeText().isEmpty());
    }


}
