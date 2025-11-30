package org.example.task2;

// Ось цей імпорт обов'язковий!
import java.util.EmptyStackException;

public class IntStack {
    private int[] stackArray;
    private int top;
    private int capacity;

    private static final int INITIAL_CAPACITY = 10;

    public IntStack() {
        this.capacity = INITIAL_CAPACITY;
        this.stackArray = new int[this.capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (this.top == this.capacity - 1) {
            grow();
        }
        this.stackArray[++this.top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            // Без імпорту java.util.EmptyStackException тут буде помилка
            throw new EmptyStackException();
        }
        return this.stackArray[this.top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[this.top];
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void clear() {
        this.top = -1;
    }

    private void grow() {
        this.capacity *= 2;
        int[] newArray = new int[this.capacity];
        System.arraycopy(this.stackArray, 0, newArray, 0, this.stackArray.length);
        this.stackArray = newArray;
    }
}