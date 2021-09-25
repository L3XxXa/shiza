package ru.nsu.malov;

import org.junit.jupiter.api.Test;
import ru.nsu.malov.Heapsort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestHeapsort {
    @Test
    public void testsortedarray() {
        int ain[] = {1, 2, 3, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void testunsorted2elem() {
        int ain[] = {1, 4, 2, 3, 5,};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void testunsorted3elem() {
        int ain[] = {1, 3, 2, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void testunsortedarray() {
        int ain[] = {5, 4, 3, 2, 1};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void testnegelems() {
        int ain[] = {-1, -4, -3, -2, 1};
        int aout[] = {-4, -3, -2, -1, 1};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void testemptyarr() {
        int ain[] = {};
        int aout[] = {};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }
}
