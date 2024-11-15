package competetive;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution = new Solution();

    @BeforeAll
    static void common(){
        Solution solution = new Solution();
    }

    @Test
    void test1() { assertEquals(0, solution.strStr("leetcode", "leet")); }
    @Test
    void test2() { assertEquals(-1, solution.strStr("leetcode", "leet0")); }
    @Test
    void test3() { assertEquals(2, solution.strStr("leetcode", "etc")); }
    @Test
    void test4() { assertEquals(4, solution.strStr("leetcode", "code")); }
    @Test
    void test5() { assertEquals(-1, solution.strStr("leetcode", "")); }
    @Test
    void test6() { assertEquals(0, solution.strStr("leetcode", "leetcode")); }
    @Test
    void test7() { assertEquals(-1, solution.strStr("lee", "leetcode")); }
    @Test
    void test8() { assertEquals(-1, solution.strStr("", "leetcode")); }
    @Test
    void test9() { assertEquals(-1, solution.strStr("", "")); }
    @Test
    void test10() { assertEquals(2, solution.strStr("hello", "ll")); }
    @Test
    void test11() { assertEquals(0, solution.strStr("a", "a")); }
    @Test
    void test11() { assertEquals(0, solution.strStr("mississippi", "sipp")); }
}
