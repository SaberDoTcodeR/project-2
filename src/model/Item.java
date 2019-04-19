package model;

import java.util.ArrayList;

public abstract class Item {//Usable Item*********//////
    private String name;
    private int id;
    private int costOfBuy;
    private static ArrayList<Item> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getCostOfBuy() {
        return costOfBuy;
    }

    public void setCostOfBuy(int costOfBuy) {
        this.costOfBuy = costOfBuy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public abstract String showDetails();
}
