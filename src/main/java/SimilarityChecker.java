import java.util.ArrayList;

public class SimilarityChecker {


    public int calSimilarity(String str1, String str2) {

        int result = 0;
        assertIllegalArgument(str1);
        assertIllegalArgument(str2);

        return result;
    }

    private static void assertIllegalArgument(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        for (char number : str.toCharArray()) {
            if (number >= '0' && number <= '9') {
                throw new IllegalArgumentException();
            }
        }

    }

    public int calWordLength(String str1, String str2) {

        if (str1.length() == str2.length()) {
            return 60;
        }
        int longLength = getLongLength(str1, str2);
        int shortLength = getShortLength(str1, str2);

        if (longLength >= shortLength * 2) {
            return 0;
        }

        return (int) ((1 - (float) (longLength - shortLength) / shortLength) * 60);
    }

    public int getLongLength(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return str2.length();
        }
        return str1.length();
    }

    public int getShortLength(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return str2.length();
        }
        return str1.length();
    }

}
