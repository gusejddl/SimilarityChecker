import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {


    private SimilarityChecker similarityChecker;

    @BeforeEach
    void setUp() {
        similarityChecker = new SimilarityChecker();
    }

    @Test
    void throwExceptionWhenInputInvalidInput() {
        assertIllegalArgument(null,null);
        assertIllegalArgument("12d","1asdg");
        assertIllegalArgument("1234","asdg");
        assertIllegalArgument(null,"s");
    }

    private void assertIllegalArgument(String str1,String str2) {
        try {

            similarityChecker.calSimilarity(str1,str2);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void returnPointIfSameLength(){
        assertEquals(60, similarityChecker.calWordLength("ABC","ABC"));
    }


    @Test
    void returnPointIfMoreThanDoubleDiffLength(){
        assertEquals(0, similarityChecker.calWordLength("ABCDEF","ABC"));
    }

    @Test
    void returnPartialPointForLength(){
        assertEquals(19, similarityChecker.calWordLength("ABCDE","ABC"));
    }





}