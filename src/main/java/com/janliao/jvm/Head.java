package com.janliao.jvm;

public class Head {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Head(int height) {
        this.height = height;
    }

    public Head() {
    }

    @Override
    public String toString() {
        return "Head{" +
                "height=" + height +
                '}';
    }
}
