package org.eryk;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LaptopWebScraper webScraper = new LaptopWebScraper_RTVEuroAGD();
        List<Laptop> laptops = webScraper.getLaptopDeals();
        webScraper.close();
        System.out.println("Laptops: \n");
        int i = 0;
        for(Laptop item : laptops) {
            System.out.println(i + ". Name: " + item.getName());
            System.out.println(i + ". Price: " + item.getPrice());
            System.out.println(i + ". Link: " + item.getLink());

            System.out.println();
            i++;
        }

    }
}