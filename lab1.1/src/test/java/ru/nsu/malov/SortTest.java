package ru.nsu.malov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    @Test
    public void test_sorted_array() {
        int ain[] = {1, 2, 3, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test_two_usorted_elements() {
        int ain[] = {1, 4, 2, 3, 5,};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test_three_unsorted_elements() {
        int ain[] = {1, 3, 2, 4, 5};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test_unsorted_array() {
        int ain[] = {5, 4, 3, 2, 1};
        int aout[] = {1, 2, 3, 4, 5};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }

    @Test
    public void test_negative_elemets() {
        int ain[] = {-1, -4, -3, -2, 1};
        int aout[] = {-4, -3, -2, -1, 1};
        Heapsort heap = new Heapsort();
        heap.sort(ain);
        assertArrayEquals(ain, aout);
    }


}

