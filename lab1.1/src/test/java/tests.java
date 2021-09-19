import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class tests {
    @Test
    public void test1() {
        int ain[] = {1, 2, 3, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
       Heapsort heap = new Heapsort();
        heap.sort(ain);
       assertArrayEquals (ain, aout);
        //assert
    }

    @Test
    public  void test2() {
        int ain[] = {1, 4, 2, 3, 5,};
        int aout[] = {1, 2, 3, 4, 5};
       Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test3() {
        int ain[] = {1, 3, 2, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
       Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test4() {
        int ain[] = {5, 4, 3, 2, 1};
        int aout[] = {1, 2, 3, 4, 5};
       Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }
    @Test
    public void test5() {
        int ain[] = {-1, 4, 3, 2, 1};
        int aout[] = {-1, 1, 2, 3, 4};
       Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

}
