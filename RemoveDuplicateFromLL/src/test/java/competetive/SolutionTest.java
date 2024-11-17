package competetive;

import com.list.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution = new Solution();
    ListNode head;
    void prepareData(int[] inputArray1) {
        try {
            head = new ListNode(inputArray1[0]);
            head.constructLinkedList(inputArray1, head, 0);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            head = null;
        }
    }

    void assertWillEqual(String output){
        assertEquals(output, ListNode.printLinkedList(solution.deleteDuplicates(head)));
    }

    @BeforeAll
    static void common(){
        Solution solution = new Solution();
    }

    @Test
    void test1() {
        prepareData( new int[] { 1,1,2 } );

        assertWillEqual("1 -> 2");
    }

    @Test
    void test2() {
        prepareData( new int[] { 1,1 } );

        assertWillEqual("1");
    }

    @Test
    void test3() {
        prepareData( new int[] { 1, 1, 2, 3, 3 } );

        assertWillEqual("1 -> 2 -> 3");
    }

    @Test
    void test4() {
        prepareData( new int[] { 9, 9, 9, 9, 9, 9 } );

        assertWillEqual("9");
    }

    @Test
    void test5() {
        prepareData( new int[] { 1,1,1,1,1,9 } );

        assertWillEqual("1 -> 9");
    }

    @Test
    void test6() {
        prepareData( new int[] { 1,1,1,1,1,9,11,11,11,11 } );

        assertWillEqual("1 -> 9 -> 11");
    }
}
