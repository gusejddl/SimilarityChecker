public class SimilarityChecker {

    public static final int MAXLENGTHPOINT = 60;
    public static final int MINPOINT = 0;
    public static final int MAXALPHAPOINT = 40;


    public int calSimilarity(String input1, String input2) {

        assertIllegalArgument(input1);
        assertIllegalArgument(input2);

        return calWordLength(input1, input2) + calWordAlpha(input1, input2);
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

    public int calWordLength(String input1, String input2) {

        if (input1.length() == input2.length()) {
            return MAXLENGTHPOINT;
        }
        int longLength = Math.max(input1.length(), input2.length());
        int shortLength = Math.min(input1.length(), input2.length());


        if (isMoreThanDoubleDiffLength(longLength, shortLength)) {
            return MINPOINT;
        }

        return (MAXLENGTHPOINT - (longLength - shortLength)*MAXLENGTHPOINT / shortLength);
    }

    private static boolean isMoreThanDoubleDiffLength(int longLength, int shortLength) {
        return longLength >= shortLength * 2;
    }

    public int calWordAlpha(String input1, String input2) {
        if (checkAllSameAlpha(input1, input2)) return MAXALPHAPOINT;
        if (checkAllDiffAlpha(input1, input2)) return MINPOINT;

        return calPartialSameAlpha(input1, input2);
    }

    private static boolean checkAllSameAlpha(String input1, String input2) {
        return getNumOfSameAlpha(input1, input2) == input1.length()
                && getNumOfSameAlpha(input2, input1) == input2.length();
    }

    private static boolean checkAllDiffAlpha(String input1, String input2) {
        return getNumOfSameAlpha(input1, input2) == 0
                && getNumOfSameAlpha(input2, input1) == 0;
    }

    private static int getNumOfSameAlpha(String input1, String input2) {
        int count = 0;
        for (int index = 0; index < input1.length(); index++) {
            if (input2.indexOf(input1.charAt(index)) > -1) {
                count++;
            }
        }
        return count;
    }

    private static int calPartialSameAlpha(String input1, String input2) {


        int sameCnt =  calSameAlpha(input1, input2);
        int totalCnt = calTotalAlpha(input1, input2);


        return (sameCnt * MAXALPHAPOINT) / totalCnt;
    }

    private static int calSameAlpha(String input1, String input2) {
        boolean sameAlpha[] = checkSameAlpha(input1, input2);

        int sameCnt = 0;
        for (int index = 0; index < 26; index++) {
            if (sameAlpha[index] == true) sameCnt++;
        }

        return sameCnt;
    }

    private static boolean[] checkSameAlpha(String input1, String input2) {
        boolean sameAlpha[] = new boolean[26];
        for (int index = 0; index < input1.length(); index++) {
            if (input2.indexOf(input1.charAt(index)) > -1) {
                sameAlpha[input1.charAt(index) - 'A'] = true;
            }
        }
        return sameAlpha;
    }

    private static int calTotalAlpha(String input1, String input2) {
        boolean[] usedAlpha = checkTotalAlpha(input1, input2);

        int totalCnt = 0;
        for (int index = 0; index < 26; index++) {
            if (usedAlpha[index] == true) totalCnt++;
        }

        return totalCnt;
    }

    private static boolean[] checkTotalAlpha(String input1, String input2) {
        boolean usedAlpha[] = new boolean[26];
        for (int index = 0; index < input1.length(); index++) {
            usedAlpha[input1.charAt(index) - 'A'] = true;
        }
        for (int index = 0; index < input2.length(); index++) {
            usedAlpha[input2.charAt(index) - 'A'] = true;
        }
        return usedAlpha;
    }
}
