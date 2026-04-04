
public class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m > n) return -1;

        int[] lps = buildLPS(needle);
        int i = 0, j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) { i++; j++; }

            if (j == m) return i - j;

            if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                j = (j != 0) ? lps[j - 1] : 0;
                if (j == 0) i++;
            }
        }
        return -1;
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
} 