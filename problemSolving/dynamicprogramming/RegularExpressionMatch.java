package dynamicprogramming;

public class RegularExpressionMatch {
    boolean charMismatch = false;

    public static void main(String arg[]) {
        RegularExpressionMatch regularExpressionMatch = new RegularExpressionMatch();
        System.out.println((regularExpressionMatch.isMatch("aaa", "a*")));
        System.out.println((regularExpressionMatch.isMatch("acz", "a?a")));
        System.out.println((regularExpressionMatch.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "a***************************************b***********************************************")));
        System.out.println((regularExpressionMatch.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "a**************************************************************************************")));
        System.out.println((regularExpressionMatch.isMatch("bcaccbabaa", "bb*c?c*?")));

    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        int i = m - 1;

        String cloneB = trimStar(B);
        m = cloneB.length();

        return matchExpression(A, cloneB, n - 1, m - 1);
    }

    int matchExpression(String inpString, String pattern, int stringIndex, int patternIndex) {

        if (patternIndex < 0 && stringIndex < 0) {
            return 1;
        } else if (patternIndex < 0 && stringIndex >= 0) {
            return 0;
        }

        char inp = stringIndex < 0 ? '#' : inpString.charAt(stringIndex);
        char pat = patternIndex < 0 ? '#' : pattern.charAt(patternIndex);

        if (isLowerCaseAlphabet(inp) && isLowerCaseAlphabet(pat)) {
            if (inpString.charAt(stringIndex) == pattern.charAt(patternIndex)) {
                return matchExpression(inpString, pattern, stringIndex - 1, patternIndex - 1);
            } else if (inpString.charAt(stringIndex) != pattern.charAt(patternIndex)) {
                charMismatch = true;
                return 0;
            }
        }

        if (pat == '?') {
            if (inp == '#') {
                return 0;
            }
            return matchExpression(inpString, pattern, stringIndex - 1, patternIndex - 1);
        }

        if (pat == '*') {
            if (inp == '#') {
                if (inpString.charAt(0) == pattern.charAt(0) && !charMismatch) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                int index_1 = 0;
                int index_2 = 0;

                index_1 = matchExpression(inpString, pattern, stringIndex, patternIndex - 1);
                if (!charMismatch && index_1 > 0) {
                    return 1;
                } else if (charMismatch) {
                    return 0;
                } else {
                    index_2 = matchExpression(inpString, pattern, stringIndex - 1, patternIndex);
                }

                if (charMismatch) {
                    return 0;
                }
                return Math.max(index_1, index_2);
            }
        }

        return 0;
    }


    boolean isLowerCaseAlphabet(char inpChar) {
        return (inpChar > 96 && inpChar < 123);
    }

    boolean hasAlphabets(String str) {
        for (int i = 0; i < str.length(); i++) {
            char find = str.charAt(i);
            if ((find > 96 && find < 123) || find == '?') {
                return false;
            }
        }

        return true;
    }

    String trimStar(String inpStr) {
        if (inpStr.startsWith("**")) {
            int lead = 0;
            for (int i = 0; i < inpStr.length(); i++) {
                if (inpStr.charAt(i) != '*') {
                    break;
                }
                lead++;
            }

            inpStr = "*" + inpStr.substring(lead, inpStr.length());
        }
        int n = inpStr.length();
        if (inpStr.endsWith("**")) {
            int trail = 0, j = n - 1;
            for (; j >= 0; j--) {
                if (inpStr.charAt(j) != '*') {
                    break;
                }
                trail++;
            }
            inpStr = inpStr.substring(0, n - trail) + "*";
        }

        while (inpStr.contains("**")) {
            inpStr = inpStr.replace("**", "*");
        }

        return inpStr;

    }
}
