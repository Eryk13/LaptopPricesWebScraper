package org.eryk;

public class Laptop {
    private String name;
    private int price;
    private String link;

    public Laptop(String name, int price, String link) {
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
