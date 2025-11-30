package org.example.task2;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be > 0");
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Width must be > 0");
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be > 0");
        this.height = height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public double getSurfaceArea() {
        return 2 * (this.length * this.width + this.length * this.height + this.width * this.height);
    }

    public void printInfo() {
        System.out.println("Box Volume: " + getVolume());
    }
}
