package ru.nsu.malov;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    int size = 0;
    int stackcapacity = 10;
    T[] stackarr;


    public Stack() {
        stackarr = (T[]) new Object[stackcapacity];
    }

    public int count() {
        return size;
    }

    public void push(T x) {
        int newsize = size + 1;
        while (stackarr.length < newsize) {
            stackarr = Arrays.copyOf(stackarr, stackarr.length * 2);
        }
        stackarr[size] = x;
        size++;
    }

    public void pushStack(Object[] stack) {
        int stacksize = size+ stack.length;
        while (stackarr.length < stacksize) {
            stackarr = Arrays.copyOf(stackarr, stackarr.length * 2);
        }
        System.arraycopy(stack, 0, stackarr, size, stack.length);
        size += stack.length;
    }

    public T pop() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        return stackarr[size];
    }

    public Object[] popStack(int popsize) {
        if (popsize > size || size < 0) {
            throw new IndexOutOfBoundsException();
        }
        Stack<T> stack = new Stack<>();
        Object[] popstack = new Object[popsize];
        while (stackarr.length < popsize) {
            stackarr = Arrays.copyOf(stackarr, stackarr.length * 2);
        }
        System.arraycopy(stackarr, 0, popstack, 0, popsize);
        size = size - popsize;
        return popstack;
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
                return stackarr[idx++];
            }
        };
    }
}
