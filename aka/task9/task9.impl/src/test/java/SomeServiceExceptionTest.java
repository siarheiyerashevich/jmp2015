import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by TheFallen on 3/6/16.
 */
public class SomeServiceExceptionTest {

    SomeService someService;

    @Test (expected = NullPointerException.class)
    public void testGetSomeText() {
        assertFalse(someService.getSomeText().isEmpty());
    }


}
