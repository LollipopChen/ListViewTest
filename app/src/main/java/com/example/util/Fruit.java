package com.example.util;

/**
 * Created by TS-YFZX-CQE on 2017/6/21.
 */

public class Fruit {

    private String name;
    private int imageId;

    public Fruit(String name ,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
