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
    void test2() { assertEquals(2, solution.mySqrt(8)); }

    @Test
    void test1() { assertEquals(3, solution.mySqrt(9)); }

    @Test
    void test3() { assertEquals(3, solution.mySqrt(11)); }

    @Test
    void test4() { assertEquals(3, solution.mySqrt(15)); }

    @Test
    void test5() { assertEquals(4, solution.mySqrt(16)); }

    @Test
    void test6() { assertEquals(46339, solution.mySqrt(2147395599)); }
}
