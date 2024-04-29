public class SimilarityChecker {


    public int check(String str1, String str2) {
        int result =0;
        assertIllegalArgument(str1);
        assertIllegalArgument(str2);

        if(str1.length() == str2.length()){
            result = 60;
        }


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
}
