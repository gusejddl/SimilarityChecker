public class SimilarityChecker {


    public void check(String str1, String str2) {
        assertIllegalArgument(str1,str2);
    }

    private static void assertIllegalArgument(String str1,String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException();
        }

        for (char number : str1.toCharArray()) {
            if (number >= '0' || number <= '9') {
                throw new IllegalArgumentException();
            }
        }

        for (char number : str2.toCharArray()) {
            if (number >= '0' || number <= '9') {
                throw new IllegalArgumentException();
            }
        }

    }
}
