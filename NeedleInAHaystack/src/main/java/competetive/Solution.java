package competetive;

class Solution {
    /*
     haystack = leetcode
     needle = leet
     returns 0

     haystack = leetcode
     needle = leeto
     returns 0
     */

    public int strStr(String haystack, String needle) {
        int lastIndex = needle.length() - 1;
        int firstIndex = 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(
                    haystack.charAt(i) == needle.charAt(firstIndex) &&
                            i + lastIndex < haystack.length() &&
                            haystack.charAt(i + lastIndex) == needle.charAt(lastIndex)
            ) {
                if(haystack.substring(i, i + lastIndex + 1).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi", "sipp"));
    }
}
