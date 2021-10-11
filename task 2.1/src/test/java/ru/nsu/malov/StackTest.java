package ru.nsu.malov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @Test
    public void push_pop_size_twoElements() {
        stack = new Stack<>();
        stack.push(10);
        stack.push(-12);
        int size = stack.count();
        int x = stack.pop();
        int y = stack.pop();
        Assertions.assertEquals(2, size);
        Assertions.assertEquals(x, -12);
        Assertions.assertEquals(y, 10);
        Assertions.assertEquals(0, stack.count());
    }

    @Test
    public void pushStack_popStack_smallStackToEmptyStack() {
        stack = new Stack<>();
        Object[] pushstack = {34, 15};
        stack.pushStack(pushstack);
        Object[] res = stack.popStack(2);
        Object[] ans = {34, 15};
        assertArrayEquals(res, ans);
        Assertions.assertEquals(0, stack.count());
    }

    @Test
    public void pushStack_popStack_NotEmptyStack() {
        stack = new Stack<>();
        stack.push(12);
        stack.push(11);
        stack.push(18);
        Object[] pushstack = {34, 24};
        stack.pushStack(pushstack);
        Assertions.assertEquals(5, stack.count());
        Object[] res = stack.popStack(stack.count());
        Object[] ans = {12, 11, 18, 34, 24};
        Assertions.assertArrayEquals(res, ans);
        Assertions.assertEquals(0, stack.count());

    }

    @Test
    public void push_pop_bigStack() {
        stack = new Stack<>();
        for (int i = 0; i < 300; i++) {
            stack.push(i);
        }
        for (int i = 299; i >= 0; i--) {
            Assertions.assertEquals(i, stack.pop());
        }
    }


    @Test
    public void pop_emptyStack() {
        stack = new Stack<>();
        IndexOutOfBoundsException e = null;
        try {
            stack.pop();
        } catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
    }

    @Test
    public void popStack_emptyStack() {
        stack = new Stack<>();
        IndexOutOfBoundsException e = null;
        try {
            stack.popStack(3);
        } catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertNotNull(e);
    }

    @Test
    public void iterator_testMyIterator() {
        stack = new Stack<>();
        Iterator<Integer> iterator = stack.iterator();
        int[] ans = new int[100];
        Iterator<Integer> iteratorforarr = Arrays.stream(ans).iterator();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
            ans[i] = i;
        }
        while (iterator.hasNext()) {
            Assertions.assertEquals(iterator.next(), iteratorforarr.next());
        }
    }


}