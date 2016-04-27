import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by TheFallen on 3/6/16.
 */
public class SomeServiceMocksTest {

    @Test
    public void testGetSomeText() {
        SomeService someService = mock(SomeServiceImpl.class);

        when(someService.getSomeText()).thenReturn("someText");

        assertFalse(someService.getSomeText().isEmpty());
    }


}
