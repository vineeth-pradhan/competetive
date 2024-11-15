package competetive;

import com.list.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution = new Solution();
    ListNode list1, list2;

    @BeforeAll
    static void common(){
        Solution solution = new Solution();
    }

    void prepareData(int[] inputArray1, int[] inputArray2) {
        try {
            list1 = new ListNode(inputArray1[0]);
            list1.constructLinkedList(inputArray1, list1, 0);
        }
        catch(ArrayIndexOutOfBoundsException e) {
           list1 = null;
        }
        try {
            list2 = new ListNode(inputArray2[0]);
            list2.constructLinkedList(inputArray2, list2, 0);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            list2 = null;
        }
    }

    void assertWillEqual(String output){
        assertEquals(output, ListNode.printLinkedList(solution.mergeTwoLists(list1, list2)));
    }

    @Test
    void test1() {
        prepareData(
                new int[] { 1,3,9 },
                new int[] { 2,3,4,5 }
        );

        assertWillEqual("1 -> 2 -> 3 -> 3 -> 4 -> 5 -> 9");
    }

    @Test
    void test2() {
        prepareData(
                new int[] { 1,2,4 },
                new int[] { 1,3,4 }
        );

        assertWillEqual("1 -> 1 -> 2 -> 3 -> 4 -> 4");
    }

    @Test
    void test3() {
        prepareData(
                new int[] { 2,3,4,5 },
                new int[] { 1,3,9 }
        );

        assertWillEqual("1 -> 2 -> 3 -> 3 -> 4 -> 5 -> 9");
    }

    @Test
    void test4() {
        prepareData(
                new int[] { 1 },
                new int[] {  }
        );

        assertWillEqual("1");
    }

    @Test
    void test5() {
        prepareData(
                new int[] { },
                new int[] { 2 }
        );

        assertWillEqual("2");
    }

    @Test
    void test6(){
        prepareData(
                new int[] { -10,-10,-9,-4,1,6,6 },
                new int[] { -7 }
        );

        assertWillEqual("-10 -> -10 -> -9 -> -7 -> -4 -> 1 -> 6 -> 6");
    }
}
