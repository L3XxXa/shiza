package ru.nsu.malov;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private int size = 0;
    private int stackCapacity = 10;
    private T[] stackArr;
    final private int  NEW_LENGTH = 2;

    private void newSize(int newSize){
        while (stackArr.length < newSize) {
            stackArr = Arrays.copyOf(stackArr, stackArr.length * NEW_LENGTH);
        }
    }

    @SuppressWarnings("uncheked")
    public Stack() {
        stackArr = (T[]) new Object[stackCapacity];
    }

    public int count() {
        return size;
    }

    public void push(T x) {
        newSize(size+1);
        stackArr[size] = x;
        size++;
    }

    public void pushStack(Object[] stack) {
        newSize(size+stack.length);
        System.arraycopy(stack, 0, stackArr, size, stack.length);
        size += stack.length;
    }

    public T pop() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        return stackArr[size];
    }

    public Object[] popStack(int popSize) {
        if (popSize > size || size < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] popStack = new Object[popSize];
        newSize(popSize);
        System.arraycopy(stackArr, 0, popStack, 0, popSize);
        size = size - popSize;
        return popStack;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return !(idx == size);
            }

            @Override
            public T next() throws IndexOutOfBoundsException {
                return stackArr[idx++];
            }
        };
    }
}
