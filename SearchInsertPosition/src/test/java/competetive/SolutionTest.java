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
    void test1() {
       assertEquals(2, solution.searchInsert( new int[] { 1,3,5,6 }, 5));
    }

    @Test
    void test2() {
        assertEquals(4, solution.searchInsert( new int[] { 1,3,5,6 }, 7));
    }

    @Test
    void test3() {
        assertEquals(0, solution.searchInsert( new int[] { 1 }, 1));
    }
}
