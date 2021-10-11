package ru.nsu.malov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    private void newStack() {
        stack = new Stack<>();
    }

    @Test
    public void push_pop_size_twoElements() {
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
        Object[] pushStack = {34, 15};
        stack.pushStack(pushStack);
        Object[] res = stack.popStack(2);
        Object[] ans = {34, 15};
        assertArrayEquals(res, ans);
        Assertions.assertEquals(0, stack.count());
    }

    @Test
    public void pushStack_popStack_NotEmptyStack() {
        stack.push(12);
        stack.push(11);
        stack.push(18);
        Object[] pushStack = {34, 24};
        stack.pushStack(pushStack);
        Assertions.assertEquals(5, stack.count());
        Object[] res = stack.popStack(stack.count());
        Object[] ans = {12, 11, 18, 34, 24};
        Assertions.assertArrayEquals(res, ans);
        Assertions.assertEquals(0, stack.count());

    }

    @Test
    public void push_pop_bigStack() {
        for (int i = 0; i < 300; i++) {
            stack.push(i);
        }
        for (int i = 299; i >= 0; i--) {
            Assertions.assertEquals(i, stack.pop());
        }
    }


    @Test
    public void pop_emptyStack() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void popStack_emptyStack() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.popStack(3);
        });
    }

    @Test
    public void iterator_testMyIterator() {
        Iterator<Integer> iterator = stack.iterator();
        int[] ans = new int[100];
        Iterator<Integer> iteratorForArr = Arrays.stream(ans).iterator();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
            ans[i] = i;
        }
        while (iterator.hasNext()) {
            Assertions.assertEquals(iterator.next(), iteratorForArr.next());
        }
    }
}