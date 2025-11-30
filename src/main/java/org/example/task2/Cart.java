package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] contents;
    private int index;

    public Cart(Item[] contents) {
        this.contents = contents;
    }

    public void removeById(int itemIndex) {
        if (this.index == 0)
            return;

        int foundItemIndex = findItemInArray(this.contents[itemIndex]);

        if (foundItemIndex == -1)
            return;

        if (foundItemIndex == this.index - 1) {
            this.contents[this.index - 1] = null;
            this.index--;
            return;
        }

        shiftArray(foundItemIndex);
    }

    public void shiftArray(int itemIndex) {
        for (int i = itemIndex; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.index - 1] = null;
        this.index--;
    }

    public int findItemInArray(Item item) {
        for (int i = 0; i < this.index; i++) {
            // Використовуємо геттер .getId()
            if (this.contents[i].getId() == item.getId()) {
                return i;
            }
        }
        return -1;
    }

    public void add(Item item) {
        if (isCartFull())
            return;

        this.contents[this.index] = item;
        this.index++;
    }

    public boolean isCartFull() {
        return this.index == this.contents.length;
    }


    public int getCurrentSize() {
        return this.index;
    }

    public Item getItemAtIndex(int i) {
        return this.contents[i];
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(this.contents) +
                '}' + "\n";
    }
}