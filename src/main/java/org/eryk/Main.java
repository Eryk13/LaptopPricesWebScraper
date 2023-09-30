package org.eryk;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var webScraper = new LaptopWebScraper_RTVEuroAGD();
        List<Laptop> laptops = webScraper.getLaptopDeals();
        webScraper.close();
        System.out.println("Laptops: \n");
        for(Laptop item : laptops) {
            System.out.println("Name: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println();
        }

    }
}