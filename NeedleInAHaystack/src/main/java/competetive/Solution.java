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
        int found = -1;
        int lastIndex = needle.length() - 1;
        int firstIndex = 0;
        if(haystack.isEmpty() || needle.isEmpty()) { return -1; }
        if(haystack.equals(needle)) { return 0; }
        for(int i = 0; i < haystack.length(); i++) {
            if(
                    firstIndex <= needle.length() - 1 &&
                    haystack.charAt(i) == needle.charAt(firstIndex) &&
                            i + lastIndex < haystack.length() &&
                            haystack.charAt(i + lastIndex) == needle.charAt(lastIndex)
            ) {
                if(found == -1) {
                    found = i;
                }
                firstIndex++;
                lastIndex--;
            }
            else if(found < 0){
                firstIndex = 0;
                lastIndex = needle.length() - 1;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi", "sipp"));
    }
}
