import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTests {
    @Test
    public void exampleTests() {
        assertArrayEquals(new int[]{8, 64}, DeadFish.parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, DeadFish.parse("iiisdosodddddiso"));
    }
}
