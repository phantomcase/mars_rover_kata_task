import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Mars Commander Test")
class MarsCommanderTest {
    @Test
    @DisplayName("Assignment Test")
    void assignmentTest() {
        MarsCommander marsCommander = new MarsCommander();
        assertEquals("1 3 N\n" +
                "5 1 E",marsCommander.execute("5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM"));

    }
    @Test
    @DisplayName("UnValid Command Test")
    void unValidCommandTest(){
        MarsCommander marsCommander = new MarsCommander();
        assertEquals("Not a Valid command!!!",marsCommander.execute("ABCDEFG"));
    }
}