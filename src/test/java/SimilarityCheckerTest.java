import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {


    @Test
    void throwExceptionWhenInputInvalidInput() {
        assertIllegalArgument(null,null);
        assertIllegalArgument("12d","1asdg");
        assertIllegalArgument("1234","asdg");
        assertIllegalArgument(null,"s");
    }

    private void assertIllegalArgument(String str1,String str2) {
        try {
            SimilarityChecker similarityChecker = new SimilarityChecker();
            similarityChecker.check(str1,str2);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }
}